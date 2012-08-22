package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Dimension extends MacroCode {

	@Override
	public String toString() {
		return "" + ClientUtils.getClientPlayer().dimension;
	}

	@Override
	public String name() {
		return "dim";
	}

	@Override
	public String description() {
		return "Displays your dimension";
	}

}
