package br.com.rafaelleoni;

import java.util.function.Supplier;

/**
 * Functional interface that allows adding builder with name to the factory.
 */
public interface Builder<T, I> {
	
	void add(T name, Supplier<I> supplier);

}
