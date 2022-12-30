package util;

public class Util {

	
	public static void sleep(long segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void print(String msg) {
		System.out.println(msg);
	}
	
	
}
