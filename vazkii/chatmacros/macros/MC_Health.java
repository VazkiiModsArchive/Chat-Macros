package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Health extends MacroCode {

	@Override
	public String toString() {
		return "" + ClientUtils.getClientPlayer().getHealth();
	}

	@Override
	public String name() {
		return "hp";
	}

	@Override
	public String description() {
		return "Displays your health";
	}

}
