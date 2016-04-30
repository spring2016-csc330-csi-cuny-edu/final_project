package manager;
import manager.behavior.*;

public interface Appliance{
	/** The link between Enums and {@link Component}*/
	interface ComponentName<T extends Behavior.Button>{Class<T> type();};
	
	<T extends Behavior.Button> Component<T> getComponent(ComponentName<T> ac);
	<T extends Behavior.Button> void pushButton(T button, Component<T> component);
	String getReadableName();
	int getId();
	
	/**All Appliances are expected to be in a collection*/
	boolean equals(Appliance other);
}
