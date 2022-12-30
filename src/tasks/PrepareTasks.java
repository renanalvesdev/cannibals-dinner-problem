package tasks;

import domain.ActorType;
import domain.Cauldron;
import static util.TimeUtil.*;

public class PrepareTasks {
	
	
	public void startTasks() {
		
		MealActorTaskFactory factory = new MealActorTaskFactory(new Cauldron(5, toMillis(1)));
		
		factory.create(ActorType.COOKER, 1);
		factory.create(ActorType.CANNIBAL, 3);
		factory.execute();
		

	}
	
}
