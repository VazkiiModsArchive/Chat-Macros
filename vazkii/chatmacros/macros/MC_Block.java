package vazkii.chatmacros.macros;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import vazkii.codebase.client.ClientUtils;

public class MC_Block extends MacroCode {

	@Override
	public String toString() {
		EntityPlayer player = ClientUtils.getClientPlayer();
		World world = player.worldObj;
		ItemStack stack = new ItemStack(world.getBlockId((int) Math.round(player.posX), (int) Math.floor(player.posY - 2), (int) Math.round(player.posZ)), 1, world.getBlockMetadata((int) Math.round(player.posX), (int) Math.floor(player.posY - 2), (int) Math.round(player.posZ)));

		return stack == null || stack.itemID == 0 ? "Air" : stack.getItem().getItemDisplayName(stack);
	}

	@Override
	public String name() {
		return "block";
	}

	@Override
	public String description() {
		return "Displays the block you are standing on";
	}

}
