package cookbook;

import java.util.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/** 
 * Timer and Date 
 */

public class Clock extends TimerTask
{
	private boolean isRunning = false;
	static int timePassed = 0;							// counter
	
	static Timer timer = new Timer();

	static TimerTask task = new TimerTask() 
	{
		public void run() {
		timePassed++;
		System.out.println("Time started: " + timePassed);
		}
	};
	
	public static void main(String[] args) 
	{
		TimerTask Clock = new Clock();
		timer.schedule(Clock, 1000, 1000);
		Clock clock = new Clock();
		clock.start();
	}
	
	/**
	 * Start timer and set timer
	 */
	public static void start() 
	{
		System.out.println(new Date ());

		Scanner sc = new Scanner(System.in);			// user input
		System.out.print("Set your time: ");
		int input = sc.nextInt();
		
		try {
			timer.scheduleAtFixedRate(task, 1000, 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		completeTask();
	}
	
	private static void completeTask()
	{
		try
		{
			// assume it takes 
			Thread.sleep(10000);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		timer.cancel();
		
		System.out.print("Time's up");
	}
	
	/**
	 * Pause timer
	 */
	public void pause()
	{
		if(!isRunning)
			return;
		task.cancel();
		isRunning = false;
	}
	
	/**
	 * Resume timer
	 */
	public void resume()
	{
		Clock.start();
	}
	
	public static void reset()
	{
		Clock.reset();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
