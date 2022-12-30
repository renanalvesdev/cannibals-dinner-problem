package tasks;

import domain.MealActor;

public class MealActorTask implements Runnable{

	private MealActor mealActor;
	
	public MealActorTask(MealActor mealActor) {
		this.mealActor = mealActor;
	}
	
	@Override
	public void run() {
		this.mealActor.start();
	}

}
