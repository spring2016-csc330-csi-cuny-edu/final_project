package manager;

public abstract class Blender extends Appliance{
	public Blender(){super();}
	public Blender(String name) {
		super(name);
	}
	static public final int LOW_SPEED = Appliance.BASE_EVENT+1;
	static public final int MID_SPEED = Appliance.BASE_EVENT+2;
	static public final int HIGH_SPEED = Appliance.BASE_EVENT+3;
	static protected final int BASE_EVENT = HIGH_SPEED;
}

