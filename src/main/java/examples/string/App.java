package examples.string;

import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.rafaelleoni.Factory;

public class App {
	
	private static final Logger LOGGER = Logger.getLogger(App.class.getName());
	
	public static void main(String[] args) {
		
		Factory<String, CarBrand> carFactory = Factory.factory(builder -> {
			builder.add("Fiat", Fiat::new);
			builder.add("Ford", Ford::new);
			builder.add("Volkswagen", Volkswagen::new);
			builder.add("Toyota", Toyota::new);
			builder.add("Honda", Honda::new);
		});
		
		CarBrand fiat = carFactory.create("Fiat");
		CarBrand ford = carFactory.create("Ford");
		CarBrand volkswagen = carFactory.create("Volkswagen");
		CarBrand toyota = carFactory.create("Toyota");
		CarBrand honda = carFactory.create("Honda");
		
		LOGGER.info(Stream.of(fiat.getModels()).map(value -> value.name().replaceAll("_", " ")).collect(Collectors.joining(", ")));
		LOGGER.info(Stream.of(ford.getModels()).map(value -> value.name().replaceAll("_", " ")).collect(Collectors.joining(", ")));
		LOGGER.info(Stream.of(volkswagen.getModels()).map(value -> value.name().replaceAll("_", " ")).collect(Collectors.joining(", ")));
		LOGGER.info(Stream.of(toyota.getModels()).map(value -> value.name().replaceAll("_", " ")).collect(Collectors.joining(", ")));
		LOGGER.info(Stream.of(honda.getModels()).map(value -> value.name().replaceAll("_", " ")).collect(Collectors.joining(", ")));
	}

}
