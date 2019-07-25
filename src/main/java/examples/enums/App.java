package examples.enums;

import java.util.logging.Logger;

import br.com.rafaelleoni.Factory;

public class App {
	
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	
	public enum Animals {
		DOG, CAT, MOUSE, BIRD;
	}
	
	public static void main(String[] args) {
		
		Factory<App.Animals, AnimalsType> animalsFactory = Factory.factory(builder -> {
			builder.add(Animals.DOG, Dog::new);
			builder.add(Animals.CAT, Cat::new);
			builder.add(Animals.MOUSE, Mouse::new);
			builder.add(Animals.BIRD, Bird::new);
		});
		
		AnimalsType dog = animalsFactory.create(Animals.DOG);
		AnimalsType cat = animalsFactory.create(Animals.CAT);
		AnimalsType mouse = animalsFactory.create(Animals.MOUSE);
		AnimalsType bird = animalsFactory.create(Animals.BIRD);
		
		LOGGER.info(cat.type());
		LOGGER.info(dog.type());
		LOGGER.info(mouse.type());
		LOGGER.info(bird.type());
	}

}
