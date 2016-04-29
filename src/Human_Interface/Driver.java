package Human_Interface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import manager.*;
import manager.Blender.PowerComponent;
import manager.behavior.*;
import manager.behavior.Behavior.Button;
import manager.behavior.Powerable.PowerState;
import scheduler.*;
import manager.behavior.Schedulable.SchedulableInstance;

public class Driver {
	
	private ApplianceManager home;
	private Map<String,Class> names;
	private final ComponentLookup cl = ComponentLookup.getInstance();
	
	public Driver(){
		home = new ApplianceManager();
		names = new HashMap<String,Class>();
	}


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Driver demo = new Driver();
		demo.home.addAppliance(Blender.class,"cool");
		demo.names.put("cool",Blender.class);
		//demo.addAppliance();
		//for (int i = 0; i < 2; i++)
		//	demo.mainMenu(sc);
		//sc.close();
		demo.pushButton(sc);
	}
	private void mainMenu(Scanner sc){
		
		int choice = 0;
		String c1="Add an appliance", 
				c2="Remove an appliance", 
				c3="Interact with appiance", 
				c4="Schedule Event";
		System.out.println("Input a number to choose.");
		System.out.printf("1 %s\n2 %s\n3 %s\n4 %s\n",c1,c2,c3,c4);
		
		if (sc.hasNextInt()){
			choice = sc.nextInt();
			sc.nextLine();
		}
		
		
		switch(choice){
		case 1:
			addAppliance(sc);
			break;
		case 2:
			removeAppliance(sc);
			break;
		case 3:
			pushButton(sc);
			break;
		case 4:
			scheduleEvent(sc);
			break;
		default:
			//invalid
			break;
		}
	}
	private void addAppliance(Scanner sc){
		Class appType;
		String name;
		
		System.out.print("App Type:");
		if ((appType = cl.stringToAppliance(sc.nextLine())) == null) return;
		
		appType = cl.stringToAppliance("Blender");
		
		System.out.print("App name:");
		name = sc.nextLine();
		home.addAppliance(appType,name);
		
		names.put(name,appType);
	}
	private void removeAppliance(Scanner sc){
		System.out.print("App name:");
		home.removeAppliance(sc.nextLine());
	}
	private void pushButton(Scanner sc){
		String name;
		Button button;
		ComponentLookup.ComponentInfo cinfo;
		String buttonInput;
		
		System.out.print("Name:");
		name = sc.nextLine();
		
		System.out.print("Component:");
		cinfo = cl.getComponentInfo(names.get(name),sc.nextLine());
		
		System.out.println(Arrays.toString(PowerComponent.values()));
		
		//System.out.print("Button:");
		//buttonInput = sc.nextLine();
		//System.out.println(Enum.valueOf(cinfo.ctype,buttonInput));
		//for (Object b: cinfo.ctype.getEnumConstants())
			//System.out.println(b);
			//if (((Enum)b).name().equals(buttonInput))
				//button = (T)b;
		
		//if ((appType = stringToAppliance.get(sc.nextLine())) == null) return;
		//System.out.println(ap);
		
		//home.pushButton(name, button, cname);
	}
	private void scheduleEvent(Scanner sc){
	}
	
	private void demo(){
		//home.addAppliance(SlicerAndDicerModel7.class, "cool");
		home.addAppliance(Light.class, "steve");
		home.addAppliance(CoffeeMaker.class, "cool");
		home.pushButton("cool",Powerable.PowerState.OFF , CoffeeMaker.PowerComponent.MainPower);
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
