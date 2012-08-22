package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

public class MC_Armor extends MacroCode {

	@Override
	public String toString() {
		return "" + ClientUtils.getClientPlayer().getTotalArmorValue();
	}

	@Override
	public String name() {
		return "armor";
	}

	@Override
	public String description() {
		return "Displays your armor level";
	}

}
