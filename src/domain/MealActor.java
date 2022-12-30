package domain;

import static util.Util.print;

import exception.CauldronUnavailableException;

public abstract class MealActor {

	private Integer id;
	private Cauldron cauldron;
	
	public MealActor(Integer id, Cauldron cauldron) {
		super();
		this.id = id;
		this.cauldron = cauldron;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cauldron getCauldron() {
		return cauldron;
	}

	public void setCauldron(Cauldron cauldron) {
		this.cauldron = cauldron;
	}
	
	public void start() {
		
		try {
			while(true) {
				init();
			}			
		} catch (CauldronUnavailableException e) {
			synchronized (cauldron) {			
				System.out.println("Caldeirao inativo. " + toString() + " parou a execucao.");
				cauldron.notifyAll();
			}		
		}
		
	}
	
	protected void msg(String msg) {
		print(toString() +  msg);
	}
	
	public abstract void init();
	public abstract void reportData();
	
}
