package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_PosZ extends MacroCode {

	@Override
	public String toString() {
		return "" + (int) Math.round(ClientUtils.getClientPlayer().posZ);
	}

	@Override
	public String name() {
		return "zpos";
	}

	@Override
	public String description() {
		return "Displays your Z coordinate";
	}

}
