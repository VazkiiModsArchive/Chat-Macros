package vazkii.chatmacros.macros;

import java.util.List;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import vazkii.codebase.client.ClientUtils;

public class MC_PlayerNames extends MacroCode {

	@Override
	public String toString() {
		World world = ClientUtils.getClientPlayer().worldObj;
		List<EntityPlayer> l = world.playerEntities;
		String playerList = "";

		for (EntityPlayer e : l)
			playerList = playerList.concat(e.username + ", ");
		if (playerList.endsWith(", ")) return playerList.substring(0, playerList.length() - 2);
		return playerList;
	}

	@Override
	public String name() {
		return "names";
	}

	@Override
	public String description() {
		return "Displays the names of all the players on the server";
	}

}
