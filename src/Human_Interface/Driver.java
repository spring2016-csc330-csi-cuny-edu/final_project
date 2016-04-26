package Human_Interface;

import manager.*;
import manager.behavior.Powerable;
import manager.behavior.Schedulable;
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
		Schedulable thing = home.getSchedulable("steve");
		Event e = new Event(1,thing,new Schedulable.AppEventPackage(Powerable.PowerState.OFF , Light.PowerComponent.MainPower));
		Scheduler.getInstance().addEvent(e);
		Scheduler.getInstance().exeEvent(e);
	}
}
