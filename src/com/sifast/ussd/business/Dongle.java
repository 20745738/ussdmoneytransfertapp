package com.sifast.ussd.business;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Dongle implements Observable {
	
	/* DP :: State */
	private DongleState state;
	
	public void makeBusy() {
		state = state.makeBusy();
	}
	
	public void frees() {
		state = state.frees();
		notifyObservers();
	}
	
	public boolean isFree() {
		return state.isFree();
	}
	
	/*DP :: Observer */
	private List<Observer> observers;

	@Override
	public void attachObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detachObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.refresh(this);
		}
	}
	
	/** Queue :: File d'attente
	 * 
	 * queue.offer(string) : void :: enfiler :: insert un nouveau string
	 * queue.poll() : void :: defiler :: supprimer la tête de la file
	 * queue.peek() : String :: premier :: récuperer l'objet à la tête de la file sans le supprimer
	 * 
	 */
	private Queue<String> queue = new LinkedList<String>();

	public Queue<String> getQueue() {
		return queue;
	}
	

}
