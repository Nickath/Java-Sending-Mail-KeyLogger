package org.nick.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.nick.handlers.ManageService;
import org.nick.keys.NativeKeyboard;



public class Main {
	
	// Get the logger for "org.jnativehook" and set the level to warning.
	//o papas o paxys efage paxia fakh
	private static Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());

	public static void main(String[] args) throws NativeHookException {

		logger.setLevel(Level.WARNING);
		ManageService service = new ManageService();
		
		try {
			GlobalScreen.registerNativeHook();	
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//jna setup
		
		GlobalScreen.addNativeKeyListener(service.getKeyboard());
		

	}

}
