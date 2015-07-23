package com.sifast.ussd.business;


public class DongleStateBusy implements DongleState {
	
	private static DongleStateBusy dongleStateBusy = new DongleStateBusy();
	
	private DongleStateBusy() {
		
	}
	
	public static DongleStateBusy getInstance() {
		return dongleStateBusy;
	}

	@Override
	public DongleState makeBusy() {
		return this;
	}

	@Override
	public DongleState frees() {
		return DongleStateFree.getInstance();
	}

	@Override
	public boolean isFree() {
		return false;
	}

}
