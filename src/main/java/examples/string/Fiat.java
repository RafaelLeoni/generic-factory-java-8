package examples.string;

public class Fiat implements CarBrand {
	
	private enum Models {
		ARGO, GRAND_SIENA, MOBI, UNO;
	}
	
	@Override
	public Enum<?>[] getModels() {
		return Models.values();
	}

}
