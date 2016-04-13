package Human_Interface;
import java.util.HashMap;
import java.util.Map;

import manager.*;

public class Driver {
	static ApplianceManager home = new ApplianceManager();
	
	public static void main(String[] args){
		home.addAppliance(SlicerAndDicerModel7.class, "cool");
		home.pushButton("cool", Blender.HIGH_SPEED);
	}
}
