package com.sifast.ussd.business;

public class DongleStateFree implements DongleState {
	
	private static DongleStateFree dongleStateFree = new DongleStateFree();
	
	private DongleStateFree() {
		
	}
	
	public static DongleStateFree getInstance() {
		return dongleStateFree;
	}

	@Override
	public DongleState makeBusy() {
		return DongleStateBusy.getInstance();
	}

	@Override
	public DongleState frees() {
		return this;
	}

	@Override
	public boolean isFree() {
		return true;
	}

}
