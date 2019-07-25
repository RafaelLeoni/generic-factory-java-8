package examples.string;

public class Volkswagen implements CarBrand {

	private enum Models {
		GOLF, PASSAT, POLO, JETTA;
	}
	
	@Override
	public Enum<?>[] getModels() {
		return Models.values();
	}

}
