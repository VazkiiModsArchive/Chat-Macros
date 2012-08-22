package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Level extends MacroCode {

	@Override
	public String toString() {
		return "" + ClientUtils.getClientPlayer().experienceLevel;
	}

	@Override
	public String name() {
		return "lvl";
	}

	@Override
	public String description() {
		return "Displays your level";
	}

}
