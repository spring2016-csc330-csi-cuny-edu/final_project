package manager;
import java.util.HashSet;
import java.util.Set;

import manager.Appliance.ComponentName;
import manager.behavior.Behavior.Button;
import manager.behavior.Schedulable;
import manager.behavior.Schedulable.SchedulableInstance;


/**
 * In charge of interfacing with other packages.
 * Provides public functionality to add, remove
 * and update appliances. 
 * */
public class ApplianceManager {
	private Set<Appliance> apps;
	private static int nextId = 0;
	
	public ApplianceManager(){
		apps = new HashSet<Appliance>();
	}
	
	
	/**
	 * Using intraspection, a new instance is created and added to the master set.
	 * @param appType the class of appliance
	 * @param name	the name of the appliance
	 * @return success of the operation
	 * */
	public <AppType extends AbstractAppliance> boolean addAppliance(Class<AppType> appType, String name){
		if (appType.isInterface() ||  java.lang.reflect.Modifier.isAbstract(appType.getModifiers()))
			return false;
		
		AppType app = null;
		
		try {
			app = appType.getDeclaredConstructor(String.class).newInstance(name);
		} catch (Exception e){
			e.printStackTrace();
		}

		if (app==null) return false;
		
		apps.add(app);	
		nextId++;
		return true;
	}
	
	/**
	 * Removes every appliance with a name matching {@paramref name}
	 * @param name the name of the appliance to be removed
	 * */
	public void removeAppliance(String name){
		Set<Appliance> toRemove = getAppliance(name);
		for (Appliance app : toRemove){
			removeAppliance(app);	
		}
	}
	
	private void removeAppliance(Appliance app){
		apps.remove(app);		
	}

	/**
	 * @param name the name of the appliance to be matched
	 * @return a set of all appliances matching {@paramref name}
	 * */
	private Set<Appliance> getAppliance(String name){
		Set<Appliance> found = new HashSet<Appliance>();
		for (Appliance app: apps){
			if (app.getReadableName().equals(name))
				found.add(app);
		}
		return found;
	}
	
	/**
	 * Calls the {@link Appliance#pushButton(Button, Component)}
	 * for every appliance with a name matching {@paramref name}
	 * */
	public <T extends Button>void pushButton(String name, T button, ComponentName<T> cname){
		Set<Appliance> matchs = getAppliance(name);
		for (Appliance app: matchs){
			app.pushButton(button, app.getComponent(cname));
		}
	}
	
	/**
	 * @param name
	 * @return a proxy of the schedulable appliance with a name
	 * matching {@paramref name}
	 */
	public SchedulableInstance getSchedulable(String name){
		Set<Appliance> matchs = getAppliance(name);
		for (Appliance app: matchs){
			if (app instanceof Schedulable){
				return (new SchedulableInstance((Schedulable)app));
			}
		}
		return null;
	}
	
	/**
	 * for the use of appliances...
	 * @see AbstractAppliance
	 * */
	protected static int getNextId(){
		return nextId;
	}
}
