package Human_Interface;

import manager.*;
import manager.behavior.Powerable;
import manager.behavior.Scalable;

public class Driver {
	static ApplianceManager home = new ApplianceManager();
	public static void main(String[] args){
//		home.addAppliance(SlicerAndDicerModel7.class, "cool");
		home.addAppliance(Blender.class, "hi");
		home.addAppliance(CoffeeMaker.class, "cool");
		home.pushButton("cool",Powerable.PowerState.OFF , CoffeeMaker.PowerComponent.MainPower);
	}
}
