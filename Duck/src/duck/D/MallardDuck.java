package duck.D;

import duck.Impl.FlyWithWings;
import duck.Impl.Quack;

public class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("I am a Mallard");
	}
}
