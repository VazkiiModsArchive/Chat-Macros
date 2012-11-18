package vazkii.chatmacros;

import java.io.File;

import updatemanager.common.ModConverter;
import vazkii.codebase.common.CommonUtils;
import vazkii.codebase.common.EnumVazkiiMods;
import vazkii.codebase.common.IOUtils;
import vazkii.codebase.common.mod_Vazcore;

import net.minecraft.src.NBTTagCompound;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;

@Mod(modid = "chatmacros_Vz", name = "Chat Macros", version = "by Vazkii. Version [2.0.2] for 1.4.4/5.")
public class mod_ChatMacros {

	public static boolean macrosEnabled = true;
	public static boolean closeOnFinish = false;

	@Init
	public void onInit(FMLInitializationEvent event) {
		if (!CommonUtils.getSide().isClient()) return;
		mod_Vazcore.loadedVzMods.add(EnumVazkiiMods.CHAT_MACROS.getAcronym());

		File configFile = IOUtils.getConfigFile(EnumVazkiiMods.CHAT_MACROS);
		File cacheFile = IOUtils.getCacheFile(EnumVazkiiMods.CHAT_MACROS);
		NBTTagCompound cmp = IOUtils.getTagCompoundInFile(cacheFile);

		macrosEnabled = cmp.hasKey("macrosEnabled") ? cmp.getBoolean("macrosEnabled") : true;
		closeOnFinish = cmp.hasKey("closeOnFinish") ? cmp.getBoolean("closeOnFinish") : false;

		ChatMacrosConfig.writeInitialFile(configFile);
		ChatMacrosConfig.readMacros(configFile);
		TickRegistry.registerTickHandler(new ChatMacrosTickHandler(), Side.CLIENT);
		new ChatMacrosUpdateHandler(ModConverter.getMod(getClass()));
	}
}
