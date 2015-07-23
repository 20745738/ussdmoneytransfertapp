package com.sifast.ussd.business;

public interface DongleState {
	
	public DongleState makeBusy();
	
	public DongleState frees();
	
	public boolean isFree();

}
