package com.sifast.ussd.business;

public class Cheduler implements Observer {

	@Override
	public void refresh(Observable observable) {
		if((observable instanceof Dongle) && ((Dongle)observable).isFree()) {
			Dongle dongle = (Dongle) observable;
			if(!dongle.getQueue().isEmpty()) {
				String next = dongle.getQueue().peek();
				dongle.getQueue().poll();
				//TODO execute next string
			}
		}
	}

}
