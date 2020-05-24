package de.codingair.codingapi.server;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

public class Color {
	
	public static String dyeColorToChatColor(DyeColor color){
		switch(color){
			case BLACK:
				return ChatColor.COLOR_CHAR + "0";
			case BLUE:
				return ChatColor.COLOR_CHAR + "1";
			case GREEN:
				return ChatColor.COLOR_CHAR + "2";
			case CYAN:
				return ChatColor.COLOR_CHAR + "3";
			case MAGENTA:
				return ChatColor.COLOR_CHAR + "4";
			case PURPLE:
				return ChatColor.COLOR_CHAR + "5";
			case ORANGE:
				return ChatColor.COLOR_CHAR + "6";
			case BROWN:
				return ChatColor.COLOR_CHAR + "6";
			case SILVER:
				return ChatColor.COLOR_CHAR + "7";
			case GRAY:
				return ChatColor.COLOR_CHAR + "8";
			case LIME:
				return ChatColor.COLOR_CHAR + "a";
			case LIGHT_BLUE:
				return ChatColor.COLOR_CHAR + "b";
			case RED:
				return ChatColor.COLOR_CHAR + "c";
			case PINK:
				return ChatColor.COLOR_CHAR + "d";
			case YELLOW:
				return ChatColor.COLOR_CHAR + "e";
			case WHITE:
				return ChatColor.COLOR_CHAR + "f";
			default:
				return ChatColor.COLOR_CHAR + "f";
		}
	}

	public static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
		char[] b = textToTranslate.toCharArray();

		for(int i = 0; i < b.length - 1; ++i) {
			if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
				b[i] = 167;
				b[i + 1] = Character.toLowerCase(b[i + 1]);
			}
		}

		return new String(b);
	}

	public static String removeColor(String text) {
		if(text == null) return null;
		text = translateAlternateColorCodes('&', text);

		StringBuilder builder = new StringBuilder();

		boolean color = false;
		for(char ch : text.toCharArray()) {
			if(ch == ChatColor.COLOR_CHAR) color = true;
			else if(color) color = false;
			else builder.append(ch);
		}

		return builder.toString();
	}
}
