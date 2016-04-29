package manager;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import manager.Appliance.ComponentName;
import manager.behavior.Behavior;
import manager.behavior.Behavior.Button;
import manager.behavior.Schedulable;
import manager.behavior.Schedulable.AppEventPackage;
import manager.behavior.Schedulable.SchedulableInstance;

public class ApplianceManager {
	private Set<Appliance> apps;
	private static int nextId = 0;
	
	public ApplianceManager(){
		apps = new HashSet<Appliance>();
	}
	
	public <AppType extends AbstractAppliance> boolean addAppliance(Class<AppType> AppClass, String name){
		if (AppClass.isInterface() ||  java.lang.reflect.Modifier.isAbstract(AppClass.getModifiers()))
			return false;
		
		AppType app = null;
		
		try {
			app = AppClass.getDeclaredConstructor(String.class).newInstance(name);
		} catch (Exception e){
			e.printStackTrace();
		}

		if (app==null) return false;
		
		apps.add(app);	
		nextId++;
		return true;
	}
	
	public void removeAppliance(String name){
		Set<Appliance> toRemove = getAppliance(name);
		for (Appliance app : toRemove){
			removeAppliance(app);	
		}
	}
	
	private void removeAppliance(Appliance app){
		apps.remove(app);		
	}

	private Set<Appliance> getAppliance(String name){
		Set<Appliance> found = new HashSet<Appliance>();
		for (Appliance app: apps){
			if (app.getReadableName().equals(name))
				found.add(app);
		}
		return found;
	}
	
	/*
	public Set<Appliance.AppInfo> getInfo(String name){
		Set<Appliance.AppInfo> found = new HashSet<Appliance.AppInfo>();
		for (Appliance app: apps){
			if (app.getReadableName().equals(name))
				found.add(app.getAppInfo());
		}
		return found;
	}*/
	
	public <T extends Button>void pushButton(String name, T button, ComponentName<T> componentName){
		Set<Appliance> matchs = getAppliance(name);
		for (Appliance app: matchs){
			app.pushButton(button, app.getComponent(componentName));
		}
	}
	
	public SchedulableInstance getSchedulable(String name){
		Set<Appliance> matchs = getAppliance(name);
		for (Appliance app: matchs){
			if (app instanceof Schedulable){
				return (new SchedulableInstance((Schedulable)app));
			}
		}
		return null;
	}
	
	protected static int getNextId(){
		return nextId;
	}
}
