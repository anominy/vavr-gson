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

package io.github.anominy.vavrgson;

import io.github.anominy.gsonfactory.AbstractTypeAdapterFactory;
import io.github.anominy.vavrgson.deserializers.VavrLazyJsonDeserializer;
import io.github.anominy.vavrgson.deserializers.VavrOptionJsonDeserializer;
import io.github.anominy.vavrgson.deserializers.VavrTryJsonDeserializer;
import io.vavr.Lazy;
import io.vavr.control.Option;
import io.vavr.control.Try;

/**
 * A type adapter factory.
 *
 * <p><hr>
 * <pre>{@code
 *     new GsonBuilder()
 *             .registerTypeAdapterFactory(new VavrTypeAdapterFactory())
 *             .create();
 * }</pre>
 * <hr>
 */
@SuppressWarnings("unused")
public final class VavrTypeAdapterFactory extends AbstractTypeAdapterFactory {

	/**
	 * Initialize a {@link VavrTypeAdapterFactory} instance.
	 */
	public VavrTypeAdapterFactory() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object initTypeAdapter(Class<?> clazz) {
		if (clazz == Option.class) {
			return new VavrOptionJsonDeserializer();
		}

		if (clazz == Lazy.class) {
			return new VavrLazyJsonDeserializer();
		}

		if (clazz == Try.class) {
			return new VavrTryJsonDeserializer();
		}

		return null;
	}
}
