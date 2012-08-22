package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Latency extends MacroCode {

	@Override
	public String toString() {
		return ClientUtils.getPing();
	}

	@Override
	public String name() {
		return "ping";
	}

	@Override
	public String description() {
		return "Displays your ping with the server";
	}

}
