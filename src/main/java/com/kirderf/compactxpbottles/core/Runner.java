package com.kirderf.compactxpbottles.core;

import com.kirderf.compactxpbottles.dispenser.CustomDispenseBehavior;

public class Runner implements Runnable{

	@Override
	public void run() {
		CustomDispenseBehavior.init();
		
	}
	
}
