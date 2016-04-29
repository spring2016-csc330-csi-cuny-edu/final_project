package manager;
import manager.behavior.*;

public interface Appliance{
	interface ComponentName<T extends Behavior.Button>{Class<T> type();};
	<T extends Behavior.Button> Component<T> getComponent(ComponentName<T> ac);
	<T extends Behavior.Button> void pushButton(T button, Component<T> component);
	String getReadableName();
	//AppInfo getAppInfo();
	int getId();
	boolean equals(Appliance other);
	
	/*
	public class AppInfo{
		private Class<Appliance> clazz;
		
		public AppInfo(Class<Appliance> clazz){
			this.clazz = clazz;			
		}
		public Class<Appliance> getAppClass(){
			return clazz;
		}
	}*/
}
