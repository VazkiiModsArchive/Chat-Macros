package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Players extends MacroCode {

	@Override
	public String toString() {
		return "" + ClientUtils.getClientPlayer().worldObj.playerEntities.size();
	}

	@Override
	public String name() {
		return "players";
	}

	@Override
	public String description() {
		return "Displays the amount of players on the server";
	}

}
