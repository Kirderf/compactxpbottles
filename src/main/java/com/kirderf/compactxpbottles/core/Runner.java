package com.kirderf.compactxpbottles.core;

import com.kirderf.compactxpbottles.dispenser.CustumDispenseBehavior;

public class Runner implements Runnable{

	@Override
	public void run() {
		CustumDispenseBehavior.init();
		
	}
	
}
