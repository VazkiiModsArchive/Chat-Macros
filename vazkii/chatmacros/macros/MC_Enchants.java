package vazkii.chatmacros.macros;

import net.minecraft.src.Enchantment;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import vazkii.codebase.client.ClientUtils;

public class MC_Enchants extends MacroCode {

	@Override
	public String toString() {
		ItemStack stack = ClientUtils.getClientPlayer().getCurrentEquippedItem();

		if (stack == null) return "null";

		if (stack.isItemEnchanted()) {
			NBTTagList nbt = stack.getEnchantmentTagList();
			String enchs = "";

			for (int i = 0; i < nbt.tagCount(); i++) {
				NBTTagCompound cp = (NBTTagCompound) nbt.tagAt(i);
				enchs = enchs.concat(Enchantment.enchantmentsList[cp.getShort("id")].getTranslatedName(cp.getShort("lvl")) + ", ");
			}
			if (enchs.endsWith(", ")) return enchs.substring(0, enchs.length() - 2);
			return enchs;
		} else return "null";
	}

	@Override
	public String name() {
		return "enchants";
	}

	@Override
	public String description() {
		return "Displays the Enchantments on the item you're wielding";
	}

}
