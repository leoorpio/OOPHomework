package duck.test;

import duck.D.Duck;
import duck.D.MallardDuck;
import duck.Impl.Squeak;

public class DuckSimulator extends Duck{
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.setQuackBehavior(new Squeak());
		mallard.performQuack();
	}
}
