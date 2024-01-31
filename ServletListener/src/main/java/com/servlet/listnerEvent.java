package com.servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class listnerEvent implements ServletRequestListener{
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request initialize"+System.currentTimeMillis());
		
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request destroyed at "+System.currentTimeMillis());
		
	}
}
