package manager;

import java.util.HashMap;
import java.util.Map;

import manager.Appliance.ComponentName;
import manager.behavior.Behavior.Button;
import manager.behavior.*;

/**
 * Helps user get objects from strings.
 */
public final class ComponentLookup {
	private static Map<String,Class> stringToAppliance = new HashMap<String,Class>();
	private static Map<String,Class> stringToButtonEnum = new HashMap<String,Class>();
	{
		stringToAppliance.put("Blender", Blender.class);
		stringToAppliance.put("CoffeeMaker", CoffeeMaker.class);
		stringToAppliance.put("Light", Light.class);
		
		stringToButtonEnum.put("Powerable", Powerable.PowerState.class);
		stringToButtonEnum.put("Scalable", Scalable.RigidScaleState.class);
		stringToButtonEnum.put("Startable", Startable.StartState.class);				
	}
	
	private static final ComponentLookup cl = new ComponentLookup();
	public static ComponentLookup getInstance(){
		return cl;
	}
	
	/**
	 * Takes a string and returns corresponding {@linkplain ComponentName}
	 * @param appType the class of an appliance
	 * @param cname String representation of a component
	 * @return The {@link Appliance.ComponentName} represented by {@link cname}
	 */
	public<T extends Appliance> ComponentName getComponentName(Class<T> appType, String cname){
		if (appType == null || cname == null) return null;
		for (Class clazz : appType.getDeclaredClasses()){
			if (!(clazz.isEnum())) continue;
			for (Object component: clazz.getEnumConstants())
				if (((Enum) component).name().equals(cname))
					return (ComponentName)component;
		}
		return null;
	}
	
	public Class stringToAppliance(String key){
		return stringToAppliance.get(key);
	}
	public Class stringToButtonEnum(String key){
		return stringToButtonEnum.get(key);		
	}
}
