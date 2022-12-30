package domain;

import exception.CauldronUnavailableException;
import util.TimeUtil;

public class Cauldron {

	private long creationTime;
	private long durationTime;
	private Integer portions;
	private Integer maxPortions;

	public Cauldron(Integer maxPortions, long durationTime) {
		this.creationTime = TimeUtil.now();
		this.durationTime = durationTime;
		this.maxPortions = maxPortions;
		fill();
	}
	
	public void decrease() {
		portions--;
		System.out.println(this);
		
	}
	
	public void fill() {
		portions =  maxPortions;
	}

	public boolean hasFood() {
		return !hasNoFood();
	}
	
	public boolean hasNoFood() {
		return portions == 0;
	}
	
	public boolean isActive() {
		return TimeUtil.durationSince(creationTime) < durationTime ;
	}
	
	public void waitResource() {

		if(!isActive()) {
			throw new CauldronUnavailableException();
		}

		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "Cauldron [portions=" + portions + "]";
	}
	
}
