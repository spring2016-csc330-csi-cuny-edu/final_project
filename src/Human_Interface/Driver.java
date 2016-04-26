package Human_Interface;

import manager.*;
import manager.behavior.Powerable;
import manager.behavior.Schedulable;
import manager.behavior.Schedulable.SchedulableInstance;
import scheduler.*;
//import manager.behavior.Powerable;
//import manager.behavior.Scalable;

public class Driver {
	static ApplianceManager home = new ApplianceManager();
	public static void main(String[] args){
//		home.addAppliance(SlicerAndDicerModel7.class, "cool");
		home.addAppliance(Light.class, "steve");
		home.addAppliance(CoffeeMaker.class, "cool");
		//home.pushButton("cool",Powerable.PowerState.OFF , CoffeeMaker.PowerComponent.MainPower);
		//home.pushButton("steve", Powerable.PowerState.ON, Light.PowerComponent.MainPower);
		SchedulableInstance thing = home.getSchedulable("steve");
		System.out.println("Begining Demo...");
		
		Event e = thing.GenerateEvent(1, Powerable.PowerState.OFF, Light.PowerComponent.MainPower);
		Scheduler.getInstance().addEvent(e);
		e = thing.GenerateEvent(2, Powerable.PowerState.ON, Light.PowerComponent.MainPower);
		Scheduler.getInstance().addEvent(e);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
