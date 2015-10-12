package homeworkFall2015;

import java.util.ArrayList;
import java.util.List;

public class FivePhilosophers {
	
	static class Philosopher implements Runnable {
		
		private String name;
		private Object leftStick;
		private Object rightStick;
		
		public Philosopher (String name, Object leftStick, Object rightStick) {
			this.name = name;
			this.leftStick = leftStick;
			this.rightStick = rightStick;
		}

		@Override
		public void run() {
			System.out.println(this + " wants to eat");
			while(true) {
				eat();
				System.out.println(this + " is full");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this + " wants to eat again");
			}
		}
		
		public void eat() {
			synchronized (leftStick) {
				synchronized (rightStick) {
					System.out.println(this + " eats");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		@Override
		public String toString() {
			return name;
		}
		
	}
	public static void main(String[] args) {
		System.out.println("Getting the dinner ready");
		
		Object Stick0 = new Object();
		Object Stick1 = new Object();
		Object Stick2 = new Object();
		Object Stick3 = new Object();
		Object Stick4 = new Object();
		
		List<Philosopher> philosophers = new ArrayList<>();
		
		philosophers.add(new Philosopher("Elon", Stick0, Stick1));
		philosophers.add(new Philosopher("Steve", Stick1, Stick2));
		philosophers.add(new Philosopher("Sundar", Stick2, Stick3));
		philosophers.add(new Philosopher("Tim", Stick3, Stick4));
		philosophers.add(new Philosopher("Jeff", Stick4, Stick0));
		
		for (Philosopher philosopher : philosophers) {
			new Thread (philosopher).start();
		}
	}
}
