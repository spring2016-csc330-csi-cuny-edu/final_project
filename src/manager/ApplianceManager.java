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
	
	public void addAppliance(Appliance appliance, String name){
		//names.add(name);
		apps.add(appliance);	
		//return appliance.getId();
		//apps.put(name, appliance);
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

	public Set<Appliance> getAppliance(String name){
		Set<Appliance> found = new HashSet<Appliance>();
		for (Appliance app: apps){
			if (app.getReadableName().equals(name))
				found.add(app);
		}
		return found;
	}
	
	public Appliance getAppliance(int id){
		Appliance found = null;
		for (Appliance app: apps){
			if (app.getId()==id){
				found = app;
				break;
			}
		}
		return found;
	}
	
	public void pushButton(int id, int button){
		getAppliance(id).pushButton(button);
	}
	
	public void main(String[] args){
		
		
		
	}
}
