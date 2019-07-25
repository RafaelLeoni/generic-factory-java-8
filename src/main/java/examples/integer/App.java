package examples.integer;

import java.util.logging.Logger;

import br.com.rafaelleoni.Factory;

public class App {
	
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	
	public static void main(String[] args) {
		
		Factory<Integer, StatusType> statusFactory = Factory.factory(builder -> {
			builder.add(1, EmAnalise::new);
			builder.add(2, Analisado::new);
			builder.add(3, Recusado::new);
		});
		
		StatusType one = statusFactory.create(1);
		StatusType two = statusFactory.create(2);
		StatusType three = statusFactory.create(3);
		
		LOGGER.info(one.status());
		LOGGER.info(two.status());
		LOGGER.info(three.status());
	}

}
