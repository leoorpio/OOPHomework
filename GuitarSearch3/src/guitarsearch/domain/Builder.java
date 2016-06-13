package guitarsearch.domain;


public enum Builder {

	FENDER("Fender"), MARTIN("Martin"), GIBSON("Gibson"), COLLINGS("Collings"), OLSON("Olson"), RYAN("Ryan"), PRS("PRS");
	
	private final String name;
	
	private Builder(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static Builder exchangeBuilder(String name) {
		Builder temp = null;
		for(Builder b : Builder.values()){
			if(b.getName().equals(name)){
				temp = b;
			} 
		}
		return temp;
	}
	public String toString() {
		switch (this) {
		case FENDER: return "Fender";
		case MARTIN: return "Martin";
		case GIBSON: return "Gibson";
		case COLLINGS: return "Collings";
		case OLSON: return "Olson";
		case RYAN: return "Ryan";
		case PRS: return "PRS";
		default: return "Unspecified";
		}
	}

	public static Builder[] builder = Builder.values();

	public Builder[] getBuilder() {
		return builder;
	}

}
