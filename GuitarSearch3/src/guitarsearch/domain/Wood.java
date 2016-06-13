package guitarsearch.domain;

public enum Wood {

	INDIAN_ROSEWOOD("Indian Rosewood"), BRAZILIAN_ROSEWOOD("Brazilian Rosewood"), MAHOGANY("Mahogany"),
	MAPLE("Maple"), COCOBOLO("Cocobolo"), CEDAR("Cedar"), ADIRONDACK("Adirondack"),
	ALDER("Alder"), SITKA("Sitka");
	
	private final String name;
	
	private Wood(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static Wood exchangeWood(String name) {
		Wood temp = null;
		for(Wood w : Wood.values()) {
			if(w.getName().equals(name)){
				temp = w;
			}
		}
		return temp;
	}
	
	public String toString() {
		switch (this) {
		case INDIAN_ROSEWOOD: return "Indian Rosewood";
		case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
		case MAHOGANY: return "Mahogany";
		case MAPLE: return "Maple";
		case COCOBOLO: return "Cocobolo";
		case CEDAR: return "Cedar";
		case ADIRONDACK: return "Adirondack";
		case ALDER: return "Alder";
		case SITKA: return "Sitka";
		default: return "unspecified";
		}
	}

	public static Wood[] wood = Wood.values();
	
	public Wood[] getWood() {
		return wood;
	}
}
