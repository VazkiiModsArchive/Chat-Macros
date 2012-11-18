package vazkii.chatmacros.macros;

import vazkii.codebase.common.CommonUtils;

public class MC_TexturePack extends MacroCode {

	@Override
	public String toString() {
		return CommonUtils.getMc().texturePackList.getSelectedTexturePack().getTexturePackFileName().replaceAll(".zip", "");
	}

	@Override
	public String name() {
		return "tex";
	}

	@Override
	public String description() {
		return "Displays the name of the Texture Pack you're using";
	}

}
