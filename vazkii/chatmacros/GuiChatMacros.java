package vazkii.chatmacros;

import java.io.File;

import org.lwjgl.input.Keyboard;

import vazkii.codebase.common.EnumVazkiiMods;
import vazkii.codebase.common.IOUtils;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiChat;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;

public class GuiChatMacros extends GuiChat {

	GuiTextField macroContentsField;
	GuiTextField macroNameField;
	boolean addPaneEnabled;

	@Override
	protected void keyTyped(char par1, int par2) {
		File cacheFile = IOUtils.getCacheFile(EnumVazkiiMods.CHAT_MACROS);
		NBTTagCompound compound = IOUtils.getTagCompoundInFile(cacheFile);
		if (par2 == Keyboard.KEY_LMENU) {
			mod_ChatMacros.macrosEnabled = !mod_ChatMacros.macrosEnabled;
			compound.setBoolean("macrosEnabled", mod_ChatMacros.macrosEnabled);
			IOUtils.injectNBTToFile(compound, cacheFile);
			return;
		}
		if (par2 == Keyboard.KEY_RCONTROL) {
			mod_ChatMacros.closeOnFinish = !mod_ChatMacros.closeOnFinish;
			compound.setBoolean("closeOnFinish", mod_ChatMacros.closeOnFinish);
			IOUtils.injectNBTToFile(compound, cacheFile);
			return;
		}
		if (par2 == 28) {
			String var3 = inputField.getText().trim();

			if (var3.length() > 0 && !mc.handleClientCommand(var3)) {
				if (addPaneEnabled && (macroNameField.isFocused() || macroContentsField.isFocused())) return;

				if (mod_ChatMacros.macrosEnabled) {
					String[] msgs = MacroStringParser.parseMessage(var3);
					if (msgs != null && msgs.length > 0) for (String msg : msgs) {
						if (msg.equals(ChatMacrosReference.ADD_MESSAGE)) {
							openPane();
							inputField.setText("");
							return;
						}
						if (MathHelper.stringNullOrLengthZero(msg)) return;

						mc.thePlayer.sendChatMessage(msg);
					}
					else if (mod_ChatMacros.closeOnFinish) mc.displayGuiScreen((GuiScreen) null);
					else inputField.setText("");
				} else mc.thePlayer.sendChatMessage(var3);
			}
			if (mod_ChatMacros.closeOnFinish) mc.displayGuiScreen((GuiScreen) null);
			else inputField.setText("");
			return;
		}

		if (addPaneEnabled) if (inputField.isFocused()) {
			if (inputField.textboxKeyTyped(par1, par2)) return;
		} else if (macroContentsField.isFocused()) macroContentsField.textboxKeyTyped(par1, par2);
		else macroNameField.textboxKeyTyped(par1, par2);

		super.keyTyped(par1, par2);
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
		if (addPaneEnabled) {
			if (!controlList.isEmpty()) {
				GuiButton b = (GuiButton) controlList.get(0);
				b.enabled = MacroCompound.isMacroValid(macroNameField.getText(), macroContentsField.getText());
			}
			macroContentsField.updateCursorCounter();
			macroNameField.updateCursorCounter();
		}
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		if (addPaneEnabled) {
			macroContentsField.mouseClicked(par1, par2, par3);
			macroNameField.mouseClicked(par1, par2, par3);
		}
		super.mouseClicked(par1, par2, par3);
	}

	void openPane() {
		addPaneEnabled = true;
		macroContentsField = new GuiTextField(fontRenderer, width - 330, 5, 320, 16);
		macroContentsField.setMaxStringLength(256);
		macroNameField = new GuiTextField(fontRenderer, width - 416, 5, 65, 16);
		macroNameField.setMaxStringLength(16);
		controlList.add(new GuiButton(0, width - 100, 26, 18, 20, "+"));
		controlList.add(new GuiButton(1, width - 80, 26, 18, 20, "¿"));
		controlList.add(new GuiButton(2, width - 60, 26, 18, 20, "¶"));
		controlList.add(new GuiButton(3, width - 40, 26, 18, 20, "X"));
		controlList.add(new GuiButton(4, width - 80, 48, 54, 20, "Codes"));
		inputField.setCanLoseFocus(true);
	}

	void closePane() {
		addPaneEnabled = false;
		macroContentsField = null;
		macroNameField = null;
		inputField.setFocused(true);
		inputField.setCanLoseFocus(false);
		controlList.clear();
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch (par1GuiButton.id) {

			case 0: {
				if (MacroCompound.addMacroRemotely(macroNameField.getText(), macroContentsField.getText())) {
					macroContentsField.setText("");
					macroNameField.setText("");
					ChatMacrosConfig.readMacros(IOUtils.getConfigFile(EnumVazkiiMods.CHAT_MACROS));
				}
				break;
			}
			case 1: {
				macroContentsField.setText(macroContentsField.getText().concat("¿"));
				macroContentsField.setFocused(true);
				break;
			}
			case 2: {
				macroContentsField.setText(macroContentsField.getText().concat("¶"));
				macroContentsField.setFocused(true);
				break;
			}
			case 3: {
				closePane();
				break;
			}
			case 4: {
				mc.displayGuiScreen(new GuiCodeList(this, macroNameField.getText(), macroContentsField.getText()));
				break;
			}
		}
		super.actionPerformed(par1GuiButton);
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		drawRect(2, height - 37, fontRenderer.getStringWidth("Finish Mode: Close Chat Pane. (RCONTROL)") + 6, height - 16, Integer.MIN_VALUE);
		if (mod_ChatMacros.macrosEnabled) drawString(fontRenderer, "§9Chat Macros §aEnabled. §9(ALT)", 2, height - 36, 0xFFFFFF);
		else drawString(fontRenderer, "§9Chat Macros §cDisabled. §9(ALT)", 2, height - 36, 0xFFFFFF);
		if (mod_ChatMacros.closeOnFinish) drawString(fontRenderer, "§9Finish Mode: Close Chat Pane. (RCONTROL)", 2, height - 26, 0xFFFFFF);
		else drawString(fontRenderer, "§9Finish Mode: Clear Message. (RCONTROL)", 2, height - 26, 0xFFFFFF);
		if (addPaneEnabled) {
			macroContentsField.drawTextBox();
			macroNameField.drawTextBox();
			drawString(fontRenderer, "»", width - 344, 10, 0xFFFFFF);
			if (MacroCompound.macroMappings.containsKey(macroNameField.getText()) || macroNameField.getText().equalsIgnoreCase("macros") || macroNameField.getText().equalsIgnoreCase("help") || macroNameField.getText().equalsIgnoreCase("reload") || macroNameField.getText().equalsIgnoreCase("add")) drawString(fontRenderer, "That macro already exists.", width - 415, 25, 0xFF0000);
			else if (macroNameField.getText().isEmpty()) drawString(fontRenderer, "You must specify a macro name.", width - 415, 25, 0xFF0000);
			else if (macroContentsField.getText().isEmpty()) drawString(fontRenderer, "You must specify the macro's contents.", width - 415, 25, 0xFF0000);
		}
		super.drawScreen(par1, par2, par3);
	}
}
