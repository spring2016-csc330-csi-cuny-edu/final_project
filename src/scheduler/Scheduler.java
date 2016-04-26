package scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Scheduler {
	private static Scheduler s = new Scheduler();
	private static int nextEID = 0;
	private static DelayQueue<Event> events = new DelayQueue<Event>();
	private static Thread executer;
	{
	 executer =  new Thread(new Runnable() {
		        @Override
		        public void run() {
		            while (true) {
		                try {
		                	Event e = null;
		                	e = events.take();
		                	if (e!=null)		        		
			                	e.trigger();
		                    Thread.sleep(1000);
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
	public boolean exeEvent(){
		Event e = null;
		e = events.poll();
		if (e==null) return false;
		e.trigger();
		return true;
	}
	public Event getEvent(int eid){
		for (Event e: events)
			if (e.getEID()==eid)
				return e;
		return null;
	}
	
}
