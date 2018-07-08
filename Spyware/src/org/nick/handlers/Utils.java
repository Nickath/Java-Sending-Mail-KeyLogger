package org.nick.handlers;

import java.awt.event.KeyEvent;
import java.util.List;

public final class Utils {

	private Utils() {
		
	}
	
	public static String rawPrint(List<KeyStorage> storage) {
		if(storage.isEmpty()) {
			return "Nothing has been pressed";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<br> Raw Stroke Data: <br>");
		for(KeyStorage keyStorage : storage) {
			sb.append(keyStorage.toString() + System.lineSeparator());
		}
		return sb.toString();
		
	}
	
	/**
	 * 
	 * @param storage, the list of keys hitted
	 * @return the keys were hitted in a pretty format
	 */
	public static String prettyPrint(List<KeyStorage> storage) {
		if(storage.isEmpty()) {
			return "Nothing has been pressed";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<br> Pretty Stroke Data: <br>");
		boolean caps[] = new boolean[256];//256 number can hold all the possible key values
		for(KeyStorage keystorage : storage) {
			caps[keystorage.getKeyCode()] = keystorage.isPressed();
			String key = processKey(keystorage.getKeyCode(), caps[KeyEvent.VK_SHIFT]);
			if(keystorage.getLetter().length() > 1) { //if the key is a standar keywoard (f.e space)
				sb.append(" {" +keystorage.getLetter()+ "} ");
				continue;
			}
			if(keystorage.isPressed()) {
				if(caps[KeyEvent.VK_SHIFT]) {
					sb.append(keystorage.getLetter().toUpperCase());
				}
				else {
					sb.append(keystorage.getLetter().toLowerCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * takes the keystorage key code and checks if shift button was pressed to convert it appropriately
	 * @return the keystroke in appropriate format
	 */
	private static String processKey(int keyCode, boolean shifted) {
		String key = KeyEvent.getKeyText(keyCode);
		if(key.length() != 1) {
			key = "{" + KeyEvent.getKeyText(keyCode) + "}";
		}
		
		if(keyCode == KeyEvent.VK_SHIFT) {
			key = "";
		}
		if(keyCode == KeyEvent.VK_SPACE) {
			key = " ";
		}
		if(keyCode == KeyEvent.VK_1 && shifted) {
			key = "!";
		}
		if(keyCode == KeyEvent.VK_2 && shifted) {
			key = "@";
		}
		if(keyCode == KeyEvent.VK_3 && shifted) {
			key = "£";
		}
		if(keyCode == KeyEvent.VK_4 && shifted) {
			key = "$";
		}
		if(keyCode == KeyEvent.VK_5 && shifted) {
			key = "%";
		}
		if(keyCode == KeyEvent.VK_6 && shifted) {
			key = "^";
		}
		if(keyCode == KeyEvent.VK_7 && shifted) {
			key = "&";
		}
		if(keyCode == KeyEvent.VK_8 && shifted) {
			key = "*";
		}
		if(keyCode == KeyEvent.VK_9 && shifted) {
			key = "(";
		}
		if(keyCode == KeyEvent.VK_0 && shifted) {
			key = ")";
		}
		if(keyCode == KeyEvent.VK_PERIOD && shifted) {
			key = "<";
		}
		if(keyCode == KeyEvent.VK_PERIOD && !shifted) {
			key = ".";
		}
		if(keyCode == KeyEvent.VK_COMMA && shifted) {
			key = ">";
		}
		if(keyCode == KeyEvent.VK_COMMA && !shifted) {
			key = ",";
		}
		if(keyCode == KeyEvent.VK_QUOTE && shifted) {
			key = "'";
		}
		if(keyCode == KeyEvent.VK_QUOTE && !shifted) {
			key = "\"";
		}
		if(keyCode == KeyEvent.VK_SEMICOLON && shifted) {
			key = ":";
		}
		
		

		return key;
	}
	
}
