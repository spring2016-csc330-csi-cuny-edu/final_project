package manager;

public interface Appliance{
	static final int ON = 0;
	static final int BASE_EVENT = ON;
	
	void pushButton(int button);
	String getReadableName();
	int getId();
	boolean equals(Appliance other);
}
