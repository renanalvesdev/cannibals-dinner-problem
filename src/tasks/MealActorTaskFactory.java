package tasks;

import static util.TimeUtil.*;

import java.util.ArrayList;
import java.util.List;

import domain.ActorType;
import domain.Cannibal;
import domain.Cauldron;
import domain.Cooker;
import domain.MealActor;

public class MealActorTaskFactory {

	private List<Thread> tasks = new ArrayList<Thread>();
	private List<MealActor> actors = new ArrayList<MealActor>();
	
	private Cauldron cauldron;
	private long startTime;
	private long finishTime;
	
	
	public MealActorTaskFactory(Cauldron cauldron) {
		this.cauldron = cauldron;
	}
	
	
	public void create(ActorType type, int number) {
		
		MealActor actor = null;
		
		for(int i = 0; i < number; i++) {
			
			if(type.equals(ActorType.CANNIBAL)) {
				actor = new Cannibal(i, cauldron);
			}
			
			else if(type.equals(ActorType.COOKER)) {
				actor = new Cooker(i, cauldron);
			}
			
			actors.add(actor);
			tasks.add(new Thread(new MealActorTask(actor), type.toString() + i));
		}
	}
	
	public void execute() {
		start();
		join();
		printReport();
	}
	
	private void start() {
		
		startTime = now();
		
		tasks.stream().forEach(t -> {
			t.start();
		});
	}
	
	private void join() {
		
		tasks.stream().forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		finishTime = now();
	}
	
	private long duration() {
		return finishTime - startTime;
	}
	
	private void printReport() {
		System.out.println("\n\n-----------------Relatorio Final ---------------------\n\n");
		actors.stream().forEach(a -> a.reportData());
		System.out.printf("Duracao total: %.2f", miliToMinutes(duration()));
	}
}


