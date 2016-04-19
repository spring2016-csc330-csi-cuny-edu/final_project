package manager;

public interface Appliance{
	void pushButton(manager.behavior.Button button);
	String getReadableName();
	int getId();
	boolean equals(Appliance other);
}
