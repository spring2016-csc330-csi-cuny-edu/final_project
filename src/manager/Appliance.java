package manager;
import manager.behavior.*;

public interface Appliance{
	interface ApplianceComponent{};
	Component getComponent(ApplianceComponent ac);
	void pushButton(Behavior.Button button, Component component);
	String getReadableName();
	int getId();
	boolean equals(Appliance other);
}
