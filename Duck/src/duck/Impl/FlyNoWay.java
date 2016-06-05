package duck.Impl;

import duck.Interface.IFlyBehavior;

public class FlyNoWay implements IFlyBehavior {

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Can not fly");
	}

}
