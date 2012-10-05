package vazkii.chatmacros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import vazkii.chatmacros.macros.MacroCode;

public class ChatMacrosConfig {

	static char macroCharStart = '{';
	static char macroCharEnd = '}';

	public static void writeInitialFile(File f) {
		try {
			if (new FileInputStream(f).read() != -1) return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			writer.write("### Chat Macros Mod.\r");
			writer.write("### http://bit.ly/vzMods\r");
			writer.write("#\r");
			writer.write("# This is the Chat Macros config file, below you'll see configurations and\r");
			writer.write("# an example macro you can take reference to.\r");
			writer.write("#\r");
			writer.write("# This is the character to begin macros with:\r");
			writer.write("	macroCharStart	»	{\r");
			writer.write("# This is the character to finish macros with:\r");
			writer.write("	macroCharEnd	»	}\r");
			writer.write("# Here is an example macro to help you get started, you can copy it and make more:\r");
			writer.write("# Note that the character '»' is splitting the macro name from the macro itself.\r");
			writer.write("	modpage	»	http://bit.ly/vzMods\r");
			writer.write("# Or you could add in a code to add variables to the macros:\r");
			writer.write("# name	»	¿name\r");
			writer.write("# This would type in your username to the chat, but there are more variable codes, here's a list of all of them:\r");
			writer.write("#\r");
			for (MacroCode code : MacroCode.macroCodeMappings.values())
				writer.write(String.format("# 	¿%s : %s\r", code.name(), code.description()));
			writer.write("#\r");
			writer.write("# IMPORTANT: After a code you must have a space, or it won't get parsed.\r");
			writer.write("# \r");
			writer.write("# Typing ¶ in the macro will split the message in various messages at that point, keep that in mind.\r");
			writer.write("# when making long macros.\r");
			writer.write("#\r");
			writer.write("# To use a macro just type in the macro start character, the name of the macro and the macro end character.\r");
			writer.write("# In the chat menu, you can press ALT to toggle macros, and you can press RCONTROL to toggle the way the chat\r");
			writer.write("# window reacts to you pressing ENTER, be that closing the GUI or just clearing the message.\r");
			writer.write("#\r");
			writer.write("# There's also four prebuilt macros, one named 'macros' that will display the macros you have, one named\r");
			writer.write("# 'reload', that will reload your macros so you don't have to close your minecraft everytime you change this file,\r");
			writer.write("# one named 'add' that will open a interface to add macros in-game, and one called 'help', that will give you,\r");
			writer.write("# information about a macro.\r");
			writer.write("#\r");
			writer.write("# Example, with the default settings:\r");
			writer.write("# Typing in {modpage} would display on the chat as http://bit.ly/s6rL8h.\r");
			writer.write("#\r");
			writer.write("# TIP: The TAB character gets nulled in the file parsing, so you can use if for convenience.\r");
			writer.write("#\r");
			writer.write("# TIP 2: All lines starting with '#' don't get parsed so you can use them as guidelines.\r");
			writer.write("#\r");
			writer.write("# Place your macros here:\r");
			writer.write("# Codes for Copy Pasting: » ¿ ¶\r");
			writer.write("	");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readMacros(File f) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(f));
			Set<String> macroSet = new LinkedHashSet<String>();
			String line = null;

			while ((line = reader.readLine()) != null)
				if (!line.startsWith("#") && !line.isEmpty()) macroSet.add(line);

			MacroCompound.macroMappings.clear();

			for (String macro : macroSet) {
				String[] tokens = macro.split("»");
				if (tokens.length == 2) {
					tokens[0] = tokens[0].replaceAll("	", "");
					tokens[1] = tokens[1].replaceAll("	", "");
					if (tokens[0].equalsIgnoreCase("macros") || tokens[0].equalsIgnoreCase("reload") || tokens[0].equalsIgnoreCase("help") || tokens[0].equalsIgnoreCase("add")) continue;

					if (tokens[0].equalsIgnoreCase("macrocharstart")) {
						ChatMacrosConfig.macroCharStart = tokens[1].charAt(0);
						continue;
					}
					if (tokens[0].equalsIgnoreCase("macrocharend")) {
						ChatMacrosConfig.macroCharEnd = tokens[1].charAt(0);
						continue;
					}
					MacroCompound.macroMappings.put(tokens[0], tokens[1]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
