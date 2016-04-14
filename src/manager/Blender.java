package manager;

public interface Blender extends Appliance{
	static public final int LOW_SPEED = Appliance.BASE_EVENT+1;
	static public final int MID_SPEED = Appliance.BASE_EVENT+2;
	static public final int HIGH_SPEED = Appliance.BASE_EVENT+3;
	static final int BASE_EVENT = HIGH_SPEED;
}

