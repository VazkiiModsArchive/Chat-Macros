package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Framerate extends MacroCode {

	@Override
	public String toString() {
		return ClientUtils.getFPS();
	}

	@Override
	public String name() {
		return "fps";
	}

	@Override
	public String description() {
		return "Displays your framerate";
	}

}
