package vazkii.chatmacros.macros;

import net.minecraft.src.ModLoader;

public class MC_ModCount extends MacroCode {

	@Override
	public String toString() {
		return "" + ModLoader.getLoadedMods().size();
	}

	@Override
	public String name() {
		return "mods";
	}

	@Override
	public String description() {
		return "Displays the amount of mods you have loaded";
	}

}
