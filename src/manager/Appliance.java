package manager;
import manager.behavior.*;

public interface Appliance{
	interface ComponentName<T extends Behavior.Button>{};
	<T extends Behavior.Button> Component<T> getComponent(ComponentName<T> ac);
	<T extends Behavior.Button> void pushButton(T button, Component<T> component);
	String getReadableName();
	int getId();
	boolean equals(Appliance other);
}
