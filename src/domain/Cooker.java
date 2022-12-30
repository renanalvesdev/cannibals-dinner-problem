package domain;

import static util.Util.*;

public class Cooker extends MealActor{

	
	private static final String MSG_SLEEP = " dorme, pois ainda tem comida no caldeirao";
	private static final String MSG_PREPARE_MEAT = " prepara o jantar";
	private static final String MSG_FINISH_MEAT = " concluiu o jantar. Agora vai acordar os canibais";
	private static final String MSG_BACK_TO_SLEEP = " volta a dormir";

	private int fills;
	
	public Cooker(Integer id, Cauldron cauldron) {
		super(id, cauldron);
		this.fills = 0;
	}

	public void prepareMeat() {
		synchronized (getCauldron()) {
			
			while(getCauldron().hasFood()) {
				msg(MSG_SLEEP);
				getCauldron().waitResource();
			}
			
			msg(MSG_PREPARE_MEAT);
			sleep(5);
			msg(MSG_FINISH_MEAT);
			
			getCauldron().fill();
			fills++;
			getCauldron().notifyAll();
			msg(MSG_BACK_TO_SLEEP);
			getCauldron().waitResource();
		}
	}

	@Override
	public String toString() {
		return "Cooker [ID=" + getId() + ", ENCHEU= " + fills +"]";
	}

	@Override
	public void init() {
		prepareMeat();
	}
	
	public int getFills() {
		return this.fills;
	}
	
	@Override
	public void reportData() {
		print("COOKER "+ +getId() + " | " + "Numero de vezes que encheu o caldeirao: " + fills);
	}
}
