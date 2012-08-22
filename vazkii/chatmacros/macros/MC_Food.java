package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Food extends MacroCode {

	@Override
	public String toString() {
		return "" + ClientUtils.getClientPlayer().getFoodStats().getFoodLevel();
	}

	@Override
	public String name() {
		return "food";
	}

	@Override
	public String description() {
		return "Displays your food level";
	}

}
