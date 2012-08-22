package vazkii.chatmacros;

import vazkii.chatmacros.macros.MacroCode;
import vazkii.codebase.client.ClientUtils;
import vazkii.codebase.common.ColorCode;
import vazkii.codebase.common.EnumVazkiiMods;
import vazkii.codebase.common.IOUtils;

public class MacroStringParser {

	public static String[] parseMessage(String s) {
		String parsedString = replaceCodes(checkForMacros(s));

		return parsedString == null ? (String[]) null : parsedString.split("¶");
	}

	public static String checkForMacros(String s) {
		if (s.length() <= 2 || !s.startsWith("" + ChatMacrosConfig.macroCharStart) || !s.endsWith("" + ChatMacrosConfig.macroCharEnd)) return s;

		String macroName = s.substring(1, s.length() - 1);

		if (macroName.matches("macros")) {
			String allMacros = "Macro List: ";
			for (String macro : MacroCompound.macroMappings.keySet())
				allMacros = allMacros.concat(macro).concat(", ");
					allMacros = allMacros.concat("macros, reload, add, help(macroname).");

					ClientUtils.getClientPlayer().addChatMessage(allMacros);
					return null;
		}

		if (macroName.matches("reload")) {
			ChatMacrosConfig.readMacros(IOUtils.getConfigFile(EnumVazkiiMods.CHAT_MACROS));
			ClientUtils.getClientPlayer().addChatMessage(ColorCode.BRIGHT_GREEN + "Macros Reloaded!");
			return null;
		}

		if (macroName.matches("add")) return ChatMacrosReference.ADD_MESSAGE;

		if (macroName.matches("help")) {
			ClientUtils.getClientPlayer().addChatMessage(ColorCode.RED + "That's not how you use the help macro, try help'modpage'.");
			return null;
		}

		if (macroName.startsWith("help'") && macroName.endsWith("'")) {
			ClientUtils.getClientPlayer().addChatMessage(parseHelpMacro(macroName));
			return null;
		}

		if (!MacroCompound.macroMappings.containsKey(macroName)) {
			ClientUtils.getClientPlayer().addChatMessage(ColorCode.RED + "That Macro doesn't exist.");
			return "";
		}
		String macroResult = MacroCompound.macroMappings.get(macroName);
		return macroResult;
	}

	public static String replaceCodes(String string) {
		if (string == null) return null;

		String currentString = string;
		while (currentString.indexOf("¿") > 0) {
			int currentIndex = currentString.indexOf("¿");
			String stringBeforeCode = currentString.substring(0, currentIndex);
			int maxCodeIndex = getCodeSection(currentString, currentIndex);
			String codeToParse = currentString.substring(currentIndex + 1, maxCodeIndex);
			String stringAfterCode = currentString.substring(maxCodeIndex);
			currentString = stringBeforeCode + replaceCodeWithResult(codeToParse) + stringAfterCode;
		}
		return currentString;
	}

	public static int getCodeSection(String s, int startIndex) {
		s.substring(1, s.length());

		int indexLookingAt = startIndex;
		while (true) {
			if (indexLookingAt >= s.length() || s.charAt(indexLookingAt) == ' ') return indexLookingAt;
			++indexLookingAt;
		}
	}

	public static String replaceCodeWithResult(String code) {
		if (!MacroCode.macroCodeMappings.containsKey(code)) return code;

		return MacroCode.macroCodeMappings.get(code).toString();
	}

	public static String parseHelpMacro(String helpMacro) {
		String s = helpMacro;
		if (helpMacro == "help'help'") return "help'macroname' » Tells you what the macro in modname does. Prebuilt.";
		String macroToCheck = s.replaceAll("help", "").replaceAll("'", "");

		if (macroToCheck.equalsIgnoreCase("add")) return "add » Opens the Add Macro GUI so you can add macros in-game. Prebuilt.";
		if (macroToCheck.equalsIgnoreCase("reload")) return "reload » Reloads the list of macros. Prebuilt.";
		if (macroToCheck.equalsIgnoreCase("macros")) return "macros » Shows all the loaded macros. Prebuilt.";

		System.out.println(macroToCheck);

		if (!MacroCompound.macroMappings.containsKey(macroToCheck)) return ColorCode.RED + "That Macro doesn't exist, couldn't check for it.";

		return macroToCheck + " » " + MacroCompound.macroMappings.get(macroToCheck);
	}

}
