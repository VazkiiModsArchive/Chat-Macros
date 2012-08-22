package vazkii.chatmacros;

import net.minecraft.src.GuiScreen;

public class GuiCodeList extends GuiScreen {

	private GuiCodeListContainer container;

	GuiChatMacros parent;
	protected String name;
	protected String contents;

	public GuiCodeList(GuiChatMacros parent, String name, String contents) {
		super();
		this.parent = parent;
		this.name = name;
		this.contents = contents;
	}

	@Override
	public void initGui() {
		container = new GuiCodeListContainer(this, width, height, 32, height - 32, 36);
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		container.drawScreen(par1, par2, par3);
		drawCenteredString(fontRenderer, "Chat Macros Codes", width / 2, 16, 16777215);
		super.drawScreen(par1, par2, par3);
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		if (par2 == 1) {
			mc.displayGuiScreen(parent);
			parent.closePane();
			parent.openPane();
			parent.macroNameField.setText(name);
			parent.macroContentsField.setText(contents);
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
}
