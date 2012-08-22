package vazkii.chatmacros.macros;

import java.util.List;
import java.util.Random;

import net.minecraft.src.EntityPlayer;
import vazkii.codebase.client.ClientUtils;

public class MC_RandomPlayer extends MacroCode {

	@Override
	public String toString() {
		List list = ClientUtils.getClientPlayer().worldObj.playerEntities;
		int i = list.size();
		Random r = new Random();
		int index = r.nextInt(i);

		return "" + ((EntityPlayer) list.get(index)).username;
	}

	@Override
	public String name() {
		return "prand";
	}

	@Override
	public String description() {
		return "Displays the username of a random player on the server";
	}

}
