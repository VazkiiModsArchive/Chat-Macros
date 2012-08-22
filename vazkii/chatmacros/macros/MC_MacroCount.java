package vazkii.chatmacros.macros;

import vazkii.chatmacros.MacroCompound;

public class MC_MacroCount extends MacroCode {

	@Override
	public String toString() {
		return "" + MacroCompound.macroMappings.size();
	}

	@Override
	public String name() {
		return "count";
	}

	@Override
	public String description() {
		return "Displays the amount of macros you have";
	}

}
