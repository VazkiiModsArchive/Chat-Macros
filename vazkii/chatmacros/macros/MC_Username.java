package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Username extends MacroCode {

	@Override
	public String toString() {
		return ClientUtils.getClientPlayer().username;
	}

	@Override
	public String name() {
		return "name";
	}

	@Override
	public String description() {
		return "Displays your username";
	}

}
