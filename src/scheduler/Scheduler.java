package scheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	private static Scheduler s = new Scheduler();
	private static int nextEID = 0;
	private List<Event> events = new ArrayList<Event>();
	
	private Scheduler(){
		events = new ArrayList<Event>();
	}
	public static Scheduler getInstance(){
		if (s == null)
			s = new Scheduler();
		return s;
	}
	public int addEvent(Event e){
		if (!events.add(e))
			return -1;
		e.setEID(nextEID);
		nextEID++;
		return nextEID -1;
	}
	public boolean exeEvent(Event e){
		return e.trigger();
	}
	public Event getEvent(int eid){
		for (Event e: events)
			if (e.getEID()==eid)
				return e;
		return null;
	}
}
