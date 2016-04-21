package Human_Interface;

import manager.*;
import manager.behavior.Powerable;
import manager.behavior.Startable;

public class Driver {
	static ApplianceManager home = new ApplianceManager();
	
	public static void main(String[] args){
		home.addAppliance(SlicerAndDicerModel7.class, "cool");
		home.pushButton("cool", Powerable.PowerState.ON, Blender.PowerComponent.MainPower);
	}
}
