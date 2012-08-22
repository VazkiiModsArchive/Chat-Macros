package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_PosX extends MacroCode {

	@Override
	public String toString() {
		return "" + (int) Math.round(ClientUtils.getClientPlayer().posX);
	}

	@Override
	public String name() {
		return "xpos";
	}

	@Override
	public String description() {
		return "Displays your X coordinate";
	}

}
