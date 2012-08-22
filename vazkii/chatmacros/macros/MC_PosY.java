package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_PosY extends MacroCode {

	@Override
	public String toString() {
		return "" + (int) Math.round(ClientUtils.getClientPlayer().posY);
	}

	@Override
	public String name() {
		return "ypos";
	}

	@Override
	public String description() {
		return "Displays your Y coordinate";
	}

}
