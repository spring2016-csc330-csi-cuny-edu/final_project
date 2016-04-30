package scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Scheduler {
	private final static Scheduler s = new Scheduler();
	private static int nextEID = 0;
	private static DelayQueue<Event> events = new DelayQueue<Event>();
	private static Thread executer;
	
	{
	 executer =  new Thread(new Runnable() {
		        public void run() {
		            while (true) {
		                try {
		                	Event e = null;
		                	e = events.take();
		                	if (e!=null)	        		
			                	e.trigger();
		                    Thread.sleep(200);
		                } catch (InterruptedException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        }
		    });
	 executer.setDaemon(true);
	 executer.start();
	}

	
	private Scheduler(){
		events = new DelayQueue<Event>();
	}
	public static Scheduler getInstance(){
		return s;
	}
	public int addEvent(Event e){
		if (!events.add(e))
			return -1;
		e.setEID(nextEID);
		nextEID++;
		return nextEID -1;
	}
	public boolean exeEvent(int eid){
		Event found = getEvent(eid);
		if (found==null) return false;
		found.trigger();
		events.remove(found);
		return true;
	}
	private Event getEvent(int eid){
		for (Event e: events)
			if (e.getEID()==eid)
				return e;
		return null;
	}
	public boolean cancelEvent(int eid){
		Event found = getEvent(eid);
		if (found==null) return false;
		events.remove(found);
		return true;
	}
}
