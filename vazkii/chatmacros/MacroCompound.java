package vazkii.chatmacros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import vazkii.codebase.common.EnumVazkiiMods;
import vazkii.codebase.common.IOUtils;

public class MacroCompound {

	public static HashMap<String, String> macroMappings = new HashMap();

	public static boolean isMacroValid(String name, String contents) {
		return !(name.equalsIgnoreCase("macros") || name.equalsIgnoreCase("reload") || name.equalsIgnoreCase("help") || name.equalsIgnoreCase("add")) && !macroMappings.containsKey(name) && !name.isEmpty() && !contents.isEmpty();
	}

	public static boolean addMacroRemotely(String name, String contents) {
		if (macroMappings.containsKey(name) || name.isEmpty() || contents.isEmpty()) return false;

		try {
			File configFile = IOUtils.getConfigFile(EnumVazkiiMods.CHAT_MACROS);
			BufferedWriter writer = new BufferedWriter(new FileWriter(configFile, true));
			writer.write("\r	" + name + "	»	" + contents);
			writer.close();
			ChatMacrosConfig.readMacros(configFile);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
