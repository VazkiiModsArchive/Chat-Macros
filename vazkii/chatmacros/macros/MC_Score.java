package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Score extends MacroCode {

	@Override
	public String toString() {
		return "" + ClientUtils.getClientPlayer().score;
	}

	@Override
	public String name() {
		return "score";
	}

	@Override
	public String description() {
		return "Displays your score (The one that gets shown when you die)";
	}

}
