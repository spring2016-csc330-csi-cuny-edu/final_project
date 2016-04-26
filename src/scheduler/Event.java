package scheduler;

public class Event{
	private int time;
	private int eid;
	private Schedulable obj;
	private Schedulable.EventPackage eventPack;
	
	public Event(int time, Schedulable obj,Schedulable.EventPackage eventPack){
		this.time = time;
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
}
