package examples.string;

public class Toyota implements CarBrand {

	private enum Models {
		COROLLA, RAV4, YARIS;
	}
	
	@Override
	public Enum<?>[] getModels() {
		return Models.values();
	}

}
