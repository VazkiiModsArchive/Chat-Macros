package vazkii.chatmacros.macros;

import vazkii.codebase.client.ClientUtils;

import net.minecraft.src.ItemStack;

public class MC_Item extends MacroCode {

	@Override
	public String toString() {
		ItemStack stack = ClientUtils.getClientPlayer().getCurrentEquippedItem();

		return stack == null ? "Air" : stack.getItem().getItemDisplayName(stack);
	}

	@Override
	public String name() {
		return "item";
	}

	@Override
	public String description() {
		return "Displays the item you're wielding";
	}

}
