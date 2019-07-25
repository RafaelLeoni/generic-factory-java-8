package br.com.rafaelleoni;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FactoryTest {
	
	private interface ITest {}
	
	private class Number implements ITest {}
	
	private class Text implements ITest {}
	
	private class Bool implements ITest {}
	
	private Factory<Object, ITest> factory;
	
	@Before
	public void before() {
		factory = Factory.factory(builder -> {
			builder.add(1, Number::new);
			builder.add("Text", Text::new);
			builder.add(true, Bool::new);
	    });
	}
	
	@Test
	public void testIfFactoryCreatedAnInstanceOfNumber() {
		ITest number = factory.create(1);
		verify(number, Number.class);
	}
	
	@Test
	public void testIfFactoryCreatedAnInstanceOfText() {
		ITest text = factory.create("Text");
		verify(text, Text.class);
	}
	
	@Test
	public void testIfFactoryCreatedAnInstanceOfBoolean() {
		ITest bool = factory.create(true);
		verify(bool, Bool.class);
	}
	
	@Test(expected = NullPointerException.class)
	public void testInvalidKey() {
		factory.create("");
	}
	
	private void verify(ITest test, Class<?> clazz) {
		assertTrue("Test object must be an instance of: " + clazz.getName(), clazz.isInstance(test));
	}

}
