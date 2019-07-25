package br.com.rafaelleoni;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Functional interface, a factory design pattern for any type of object.
 * <br>Instance created locally gives an opportunity to define
 * which objects types the instance of a factory will be able to create.
 * <br>Factory is a placeholder for {@link Builder}s
 * with {@link Factory#create(T)} method to initialize new objects.
 */
public interface Factory<T, I> {
	
	/**
	 * Creates an instance of the given type.
	 * @param name representing the key of an object type to be created.
	 * @return new instance of a requested class implementing I interface.
	*/
	I create(T name);
	
	/**
	 * Creates factory - placeholder for specified {@link Builder}s.
	 * @param <T> The type of the key
	 * @param <I> The interface type of the desired object
	 * @param consumer for the new builder to the factory.
	 * @return factory with specified {@link Builder}s
	 * @throws {@link NullPointerException} - If the key passed is invalid.
	*/
	static <T, I> Factory<T, I> factory(Consumer<Builder<T, I>> consumer) {
		Map<T, Supplier<I>> map = new HashMap<>();
		consumer.accept(map::put);
		return name -> map.get(name).get();
	}

}
