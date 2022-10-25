package cookbook;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/** 
 * Timer and Date 
 */

public class Clock
{
	
	int timePassed = 0;
	
	Timer timer = new Timer();
	
	TimerTask task = new TimerTask() 
	{
		public void run() 
		{
		// time passed
		timePassed++;
		System.out.println("Time started: " + timePassed);
		}
	};
	
	public static void main(String[] args) 
	{
		Clock clock = new Clock();
		clock.start();
	}
	
	public void start() 
	{
		System.out.println(new Date ());
		timer.scheduleAtFixedRate(task, 1000, 1000);
		completeTask();
		//System.out.println("Timer finished: " + new Date());
	}
	
	private void completeTask()
	{
		try
		{
			// assume it takes 20 seconds 
			Thread.sleep(20000);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		//cancel after sometime
		try
		{
			Thread.sleep(120000);
		}
			catch(InterruptedException ex)
		{
				ex.printStackTrace();
		}
	}
	
	/**public void start()
	{
		{
			System.out.println("Time started: " + new Date());
			completeTask();
			System.out.println("Timer finished: " + new Date());
		}
	}

	private void completeTask()
	{
		try
		{
			// assume it takes 20 seconds 
			Thread.sleep(20000);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		TimerTask timerTask = new Clock();
		//
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
		System.out.println("TimerTask started");
		
		//cancel after sometime
		try
		{
			Thread.sleep(120000);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}

		
	} **/
}
