package org.nick.handlers;

/**
 * 
 * @author NICK
 * This class will be responsible to handle integers for the keywords code 
 */
public class KeyStorage {

	private int keyCode;
	private boolean pressed;
	private long systemsTimePressedMillis;
	private String letter;
	
	
	public int getKeyCode() {
		return keyCode;
	}


	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}


	public boolean isPressed() {
		return pressed;
	}


	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}


	public long getSystemsTimePressedMillis() {
		return systemsTimePressedMillis;
	}


	public void setSystemsTimePressedMillis(long systemsTimePressedMillis) {
		this.systemsTimePressedMillis = systemsTimePressedMillis;
	}


	public String getLetter() {
		return letter;
	}


	public void setLetter(String letter) {
		this.letter = letter;
	}


	public KeyStorage(int keyCode, boolean pressed, long systemsTimePressedMillis, String letter) {
		super();
		this.keyCode = keyCode;
		this.pressed = pressed;
		this.systemsTimePressedMillis = systemsTimePressedMillis;
		this.letter = letter;
	}


	@Override
	public String toString() {
		return "KeyStorage [keyCode=" + keyCode + ", pressed=" + pressed + ", systemsTimePressedMillis="
				+ systemsTimePressedMillis + "]";
	}
	
	
}
