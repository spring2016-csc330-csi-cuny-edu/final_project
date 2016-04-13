package Human_Interface;
import java.util.HashMap;
import java.util.Map;

import manager.*;

public class Driver {
	static ApplianceManager home = new ApplianceManager();
	
	private static void addAppliance(Appliance a, String name){
	}
	
	public static void main(String[] args){
		//ApplianceManager home = new ApplianceManager();
		//Map<Integer,String> appMap = new HashMap<Integer,String>();
		
		home.addAppliance(new SlicerAndDicerModel7(), "cool");		
		//home.addAppliance(new SlicerAndDicerModel7());
		//home.pushButton(((Blender)a).HIGH_SPEED);
		
		
		//this is funn stuff right
	}
}
