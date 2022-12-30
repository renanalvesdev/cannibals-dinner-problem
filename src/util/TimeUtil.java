package util;

public class TimeUtil {

	
	public static long now() {
		return System.currentTimeMillis();
	}
	
	
	public static long durationSince(long start) {
		return now() - start;
	}
	
	public static long toMillis(int minutes) {
		return minutes * 60 * 1000;
	}
	
	public static double miliToSeconds(long milis) {
		return (double) milis/1000;
	}
	
	public static double miliToMinutes(long milis) {
		double seconds = miliToSeconds(milis);
		return seconds/60;
	}
}
