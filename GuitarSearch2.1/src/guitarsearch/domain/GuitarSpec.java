package guitarsearch.domain;

public class GuitarSpec {

	private Builder builder;
	private String model;
	private Type type;
	private int numStrings;
	private Wood backWood;
	private Wood topWood;
	
	public GuitarSpec(){};
	
	public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.numStrings = numStrings;
		this.backWood = backWood;
		this.topWood = topWood;
	}
	
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setNumStrings(int numStrings) {
		this.numStrings = numStrings;
	}

	public void setBackWood(Wood backWood) {
		this.backWood = backWood;
	}

	public void setTopWood(Wood topWood) {
		this.topWood = topWood;
	}

	public Builder getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public int getNumStrings() {
		return numStrings;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}

	public boolean matches(GuitarSpec otherSpec) {
		if (! builder.equals(otherSpec.builder)) {
			return false;
		}
		return true;
	}
}
