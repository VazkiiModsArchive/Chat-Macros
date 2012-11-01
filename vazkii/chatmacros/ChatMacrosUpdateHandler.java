package vazkii.chatmacros;

import java.awt.Dimension;

import org.lwjgl.opengl.GL11;

import updatemanager.client.GuiModList;
import vazkii.codebase.common.ColorCode;
import vazkii.codebase.common.CommonUtils;
import vazkii.codebase.common.FormattingCode;
import vazkii.codebase.common.VazkiiUpdateHandler;

import net.minecraft.src.FontRenderer;

import cpw.mods.fml.common.Mod;

public class ChatMacrosUpdateHandler extends VazkiiUpdateHandler {

	public ChatMacrosUpdateHandler(Mod m) {
		super(m);
	}

	@Override
	public String getModName() {
		return "Chat Macros";
	}

	@Override
	public String getUMVersion() {
		return ChatMacrosReference.VERSION;
	}

	@Override
	public String getUpdateURL() {
		return ChatMacrosReference.UPDATE_URL;
	}

	@Override
	public String getChangelogURL() {
		return ChatMacrosReference.CHANGELOG_URL;
	}

	@Override
	public Dimension renderIcon(int x, int y, GuiModList modList) {
		FontRenderer font = CommonUtils.getMc().fontRenderer;

		x /= 2;
		y /= 2;
		x -= 2;
		y += 4;

		GL11.glPushMatrix();
		GL11.glScalef(2.0F, 2.0F, 2.0F);
		String s = "" + ColorCode.GOLD + ChatMacrosConfig.macroCharStart + FormattingCode.RANDOM + "X" + FormattingCode.RESET + ColorCode.GOLD + ChatMacrosConfig.macroCharEnd;
		font.drawStringWithShadow(s, x, y, 0xFFFFFF);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();

		return new Dimension(font.getStringWidth(s), 32);
	}

}
