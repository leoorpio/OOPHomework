package guitarsearch.domain;

public enum Type {

	ACOUSTIC("acoustic"), ELECTRIC("electric");
	
	private final String name;
	
	private Type(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static Type exchangeType(String name) {
		Type temp = null;
		for(Type t : Type.values()) {
			if(t.getName().equals(name)){
				temp = t;
			}
		}
		return temp;
	}
	
	public String toString() {
		switch (this) {
		case ACOUSTIC: return "acoustic";
		case ELECTRIC: return "electric";
		default: return "unspecified";
		}
	}
	
	public static Type[] type = Type.values();
	
	public Type[] getType() {
		return type;
	}

}
