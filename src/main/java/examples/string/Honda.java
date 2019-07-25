package examples.string;

public class Honda implements CarBrand {

	private enum Models {
		CIVIC, FIT, HR_V;
	}
	
	@Override
	public Enum<?>[] getModels() {
		return Models.values();
	}

}
