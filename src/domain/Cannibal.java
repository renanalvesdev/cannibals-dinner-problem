package domain;

import static util.Util.*;

public class Cannibal extends MealActor {
	
	private static final String MSG_WILL_SERVE = " Deseja se servir";
	private static final String MSG_CANNOT_SERVE_SLEEP = " nao pode se servir e dorme,  pois o caldeirao esta vazio ...";
	private static final String MSG_IS_SERVING = " Está se servindo ...";
	private static final String MSG_SERVED = " Se serviu. ";
	private static final String MSG_EATING = " Está comendo. ";
	private static final String MSG_EATED = " Terminou de comer. ";
	
	private int meals;
	
	public Cannibal(Integer id, Cauldron cauldron) {
		super(id, cauldron);
		this.meals = 0;
	}
	
	@Override
	public void init() {
		serve();
		eat();			
	}
	
	private void serve() {
		
		msg(MSG_WILL_SERVE);
		
		synchronized (getCauldron()) {
			
			while(getCauldron().hasNoFood()) {
				
				getCauldron().notifyAll();
				msg(MSG_CANNOT_SERVE_SLEEP);
				getCauldron().waitResource();
				
			}
			
			msg(MSG_IS_SERVING);
			sleep(1);
			msg(MSG_SERVED);
			
			getCauldron().decrease();
			getCauldron().notifyAll();
			
		}		
	}
	
	private void eat() {
		msg(MSG_EATING);
		sleep(3);
		this.meals++;
		msg(MSG_EATED);
	}

	public double getMeals() {
		return this.meals;
	}
	
	@Override
	public String toString() {
		return "Cannibal [ID=" + getId() + ", REFEICOES=" + meals +"]";
	}

	@Override
	public void reportData() {
		print("CANIBAL "+getId() + " | " + "Numero de refeicoes realizadas: " + meals);
	}
	
}
