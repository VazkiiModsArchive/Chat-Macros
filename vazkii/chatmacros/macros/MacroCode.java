package vazkii.chatmacros.macros;

import java.util.HashMap;

public abstract class MacroCode {

	public static HashMap<String, MacroCode> macroCodeMappings = new HashMap();

	public static void registerMacroCode(MacroCode code) {
		macroCodeMappings.put(code.name(), code);
	}

	@Override
	public abstract String toString();

	public abstract String name();

	public abstract String description();

	static {
		registerMacroCode(new MC_Armor());
		registerMacroCode(new MC_Block());
		registerMacroCode(new MC_DiceRoll());
		registerMacroCode(new MC_Dimension());
		registerMacroCode(new MC_Enchants());
		registerMacroCode(new MC_Food());
		registerMacroCode(new MC_Framerate());
		registerMacroCode(new MC_Health());
		registerMacroCode(new MC_Item());
		registerMacroCode(new MC_JavaVersion());
		registerMacroCode(new MC_Latency());
		registerMacroCode(new MC_Level());
		registerMacroCode(new MC_MacroCount());
		registerMacroCode(new MC_ModCount());
		registerMacroCode(new MC_OperatingSystem());
		registerMacroCode(new MC_Percent());
		registerMacroCode(new MC_Perthousand());
		registerMacroCode(new MC_PlayerNames());
		registerMacroCode(new MC_Players());
		registerMacroCode(new MC_PosX());
		registerMacroCode(new MC_PosY());
		registerMacroCode(new MC_PosZ());
		registerMacroCode(new MC_Potions());
		registerMacroCode(new MC_RandomPlayer());
		registerMacroCode(new MC_Score());
		registerMacroCode(new MC_SystemDate());
		registerMacroCode(new MC_SystemTime());
		registerMacroCode(new MC_TexturePack());
		registerMacroCode(new MC_Timezone());
		registerMacroCode(new MC_Username());
	}

}
