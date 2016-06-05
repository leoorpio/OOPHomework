package duck.Impl;

import duck.Interface.IQuackBehavior;

public class MuteQuack implements IQuackBehavior {

	@Override
	public void quack() {
		System.out.println("Can not quack!");
	}

}
