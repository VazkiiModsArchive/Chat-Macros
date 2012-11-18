package vazkii.chatmacros;

import java.util.Collection;

import vazkii.chatmacros.macros.MacroCode;
import vazkii.codebase.common.CommonUtils;
import vazkii.codebase.common.VazcoreReference;

import net.minecraft.src.FontRenderer;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.Tessellator;

public class GuiCodeListContainer extends GuiSlot {

	GuiCodeList parent;
	MacroCode[] foundCodes;

	public GuiCodeListContainer(GuiCodeList parent, int par2, int par3, int par4, int par5, int par6) {
		super(CommonUtils.getMc(), par2, par3, par4, par5, par6);
		this.parent = parent;
		Collection<MacroCode> codes = MacroCode.macroCodeMappings.values();
		foundCodes = codes.toArray(new MacroCode[codes.size()]);
	}

	@Override
	protected int getSize() {
		return MacroCode.macroCodeMappings.size();
	}

	@Override
	public int func_77210_c(int par1, int par2) {
		return super.func_77210_c(par1/* +ChatMacrosReference.CODE_GUI_OFFSET */, par2);
	}

	@Override
	protected int getContentHeight() {
		return (getSize() + 3) * VazcoreReference.CORNER_TEXT_ENTRY_SIZE * 3;
	}

	@Override
	protected boolean isSelected(int var1) {
		return false;
	}

	@Override
	protected void drawBackground() {
		parent.drawWorldBackground(0);
	}

	@Override
	protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5) {
		MacroCode code = foundCodes[var1];

		FontRenderer renderer = CommonUtils.getMc().fontRenderer;
		renderer.drawStringWithShadow("¿" + code.name(), var2 - ChatMacrosReference.CODE_GUI_OFFSET, var3, 0xFFFFFF);
		renderer.drawStringWithShadow(code.description(), var2 - ChatMacrosReference.CODE_GUI_OFFSET, var3 + VazcoreReference.CORNER_TEXT_ENTRY_SIZE, 4210752);
	}

	@Override
	protected void elementClicked(int var1, boolean var2) {
	}
}
