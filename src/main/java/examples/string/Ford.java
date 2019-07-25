package examples.string;

public class Ford implements CarBrand {

	private enum Models {
		KA, FIESTA, FOCUS, FUSION;
	}
	
	@Override
	public Enum<?>[] getModels() {
		return Models.values();
	}

}
