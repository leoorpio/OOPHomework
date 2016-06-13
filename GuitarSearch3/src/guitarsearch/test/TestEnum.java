package guitarsearch.test;

public class TestEnum {
	public enum Season {
		SPRING, SUMMER, FALL, WINTER,;
		public String toString() {
			switch(this) {
				case SPRING: return "spring";
				case SUMMER: return "summer";
				case FALL:	return "fall";
				case WINTER: return "winter";
				default: return "stranger";
			}
		}
	}
	
	public static void main(String[] args) {
		// Season s = Season.aa;	Enum.name 这个name必须存在
	}
}
