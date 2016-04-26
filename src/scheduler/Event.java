package scheduler;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Event implements Delayed{
	private long startTime;
	private int eid;
	private Schedulable obj;
	private Schedulable.EventPackage eventPack;
	
	public Event(long startTime, Schedulable obj,Schedulable.EventPackage eventPack){
		this.startTime = System.currentTimeMillis()/1000 + startTime;
		this.obj = obj;
		this.eventPack = eventPack;
		this.eid = -1;
	}
	
	protected boolean trigger(){
		return obj.fireEvent(eventPack);
	}
	
	public boolean equals(Event other){
		return this.eid == other.eid;		
	}
	
	protected void setEID(int eid){
		this.eid = eid;
	}
	public int getEID(){
		return eid;
	}
	
	public int compareTo(Delayed other) {
        if (this.startTime < ((Event)other).startTime) {
            return -1;
        }
        if (this.startTime > ((Event)other).startTime) {
            return 1;
        }

		return 0;
	}
	
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis()/1000;
		return unit.convert(diff, TimeUnit.SECONDS);
	}
}
