package manager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApplianceManager {
	private Set<Appliance> apps;
	//private List<Appliance> apps;
	//private Map<String, Appliance> apps;
	
	public ApplianceManager(){
		apps = new HashSet<Appliance>();
		//apps = new ArrayList<Appliance>();	
		//apps = new HashMap<String,Appliance>();
		//names = new ArrayList<String>();
	}
	
	public <AppType extends Appliance> void addAppliance(Class<AppType> AppClass, String name){
		if (AppClass.isInterface() ||  java.lang.reflect.Modifier.isAbstract(AppClass.getModifiers()))
			return;
		
		AppType app = null;
		try {
			app = (AppType)AppClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		if (app==null) return;
		
		app.setReadableName(name);
		apps.add(app);	
	}
	
	public void removeAppliance(String name){
		Set<Appliance> toRemove = getAppliance(name);
		for (Appliance app : toRemove){
			removeAppliance(app);	
		}
	}
	
	public void removeAppliance(Appliance app){
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
	
	private Appliance getAppliance(int id){
		Appliance found = null;
		for (Appliance app: apps){
			if (app.getId()==id){
				found = app;
				break;
			}
		}
		return found;
	}
	
	public void pushButton(String name, int button){
		Set<Appliance> matchs = getAppliance(name);//pushButton(button);
		for (Appliance app: matchs){
			app.pushButton(button);
		}
	}
	
	public void main(String[] args){
		
		
		
	}
}
