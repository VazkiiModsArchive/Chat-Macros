package vazkii.chatmacros.macros;

import net.minecraft.src.ItemStack;
import vazkii.codebase.client.ClientUtils;

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
