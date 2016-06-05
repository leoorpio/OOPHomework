package duck.Impl;

import duck.Interface.IQuackBehavior;

public class Quack implements IQuackBehavior {

	@Override
	public void quack() {
		System.out.println("Guang Guang Guang...");
	}

}
