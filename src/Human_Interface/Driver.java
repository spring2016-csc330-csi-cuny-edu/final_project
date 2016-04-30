package Human_Interface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import manager.*;
import manager.behavior.*;
import manager.behavior.Behavior.Button;
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
		Scanner humanInput = new Scanner(System.in);
		Driver demo = new Driver();
		
		File file = new File("test.txt");
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		if (file.exists()){
			Scanner fileInput;
			try {
				fileInput = new Scanner(new FileInputStream(file));
				while (fileInput.hasNextLine()){
					demo.addAppliance(fileInput,new PrintStream("NUL:"));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		while(demo.mainMenu(humanInput));
		humanInput.close();
	}
	private boolean mainMenu(Scanner sc){
		int choice = 0;
		String c1="Add an appliance", 
				c2="Remove an appliance", 
				c3="Interact with appiance", 
				c4="Schedule Event";
		System.out.println("Input a number to choose.");
		System.out.printf("1 %s\n2 %s\n3 %s\n4 %s\n",c1,c2,c3,c4);
		
		if (sc.hasNextInt()){
			choice = sc.nextInt();
		}
		sc.nextLine();
		System.out.println("");
		
		switch(choice){
		case 1:
			addAppliance(sc,System.out);
			break;
		case 2:
			removeAppliance(sc,System.out);
			break;
		case 3:
			pushButton(sc,System.out);
			break;
		case 4:
			scheduleEvent(sc,System.out);
			break;
		case -1:
			return false;
		default:
			System.out.println("Invalid Input!");
			break;
		}
		System.out.println("");
		return true;
	}
	private void addAppliance(Scanner in, PrintStream out){
		Class appType;
		String name;
		
		out.print("App Type:");
		if ((appType = cl.stringToAppliance(in.nextLine())) == null) return;
				
		out.print("App name:");
		name = in.nextLine();
		
		home.addAppliance(appType,name);
		names.put(name,appType);
	}
	private void removeAppliance(Scanner in, PrintStream out){
		out.print("App name:");
		home.removeAppliance(in.nextLine());
	}
	private void pushButton(Scanner in, PrintStream out){
		String name;
		Button button = null;
		Appliance.ComponentName cname;
		String buttonInput;
		
		out.print("Name:");
		name = in.nextLine();
		
		out.print("Component:");
		cname = cl.getComponentName(names.get(name),in.nextLine());
		
		if (cname == null) return;
		
		out.print("Button:");
		buttonInput = in.nextLine();
		for (Object b: cname.type().getEnumConstants())
			if (((Enum)b).name().equals(buttonInput))
				button = (Button) b;
		
		if (button == null) return;
		
		home.pushButton(name, button, cname);
	}
	private void scheduleEvent(Scanner in, PrintStream out){
		String name;
		Button button = null;
		Appliance.ComponentName cname;
		String buttonInput;
		Long time = 0L;
		
		out.print("Name:");
		name = in.nextLine();
		
		out.print("Component:");
		cname = cl.getComponentName(names.get(name),in.nextLine());
		
		if (cname == null) return;
		
		out.print("Button:");
		buttonInput = in.nextLine();
		for (Object b: cname.type().getEnumConstants())
			if (((Enum)b).name().equals(buttonInput))
				button = (Button) b;
		
		if (button == null) return;
		
		out.println("Timeoffset:");
		if (in.hasNextLong()) time = in.nextLong();
		else return;
		
		SchedulableInstance app = home.getSchedulable(name);
		if (app == null) return;
		
		Scheduler.getInstance().addEvent(app.GenerateEvent(time, button, cname));
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
