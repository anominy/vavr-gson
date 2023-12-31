/*
 * Copyright 2023 anominy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.anominy.vavrgson.deserializers;

import com.google.gson.*;
import io.vavr.Lazy;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * A {@link Lazy} JSON deserializer.
 */
@SuppressWarnings({"unused", "CallToPrintStackTrace"})
public final class VavrLazyJsonDeserializer implements JsonDeserializer<Lazy<?>> {

	/**
	 * Initialize a {@link VavrLazyJsonDeserializer} instance.
	 */
	public VavrLazyJsonDeserializer() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Lazy<?> deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
		return Lazy.of(() -> {
			if (json == null || json.isJsonNull()) {
				return null;
			}

			try {
				return context.deserialize(json, ((ParameterizedType) type).getActualTypeArguments()[0]);
			} catch (Throwable t) {
				t.printStackTrace();
			}

			return null;
		});
	}
}
