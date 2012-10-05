package vazkii.chatmacros.macros;

import java.util.Collection;

import net.minecraft.src.PotionEffect;
import net.minecraft.src.StatCollector;
import vazkii.codebase.client.ClientUtils;

public class MC_Potions extends MacroCode {

	@Override
	public String toString() {
		Collection<PotionEffect> potionEffects = ClientUtils.getClientPlayer().getActivePotionEffects();
		String effects = "";

		if (potionEffects.size() == 0) return "null";

		for (PotionEffect p : potionEffects)
			effects = effects.concat(StatCollector.translateToLocal(p.getEffectName()) + " " + getPotionDuration(p) + ", ");

		if (effects.endsWith(", ")) return effects.substring(0, effects.length() - 2);
		return effects;
	}

	static String getPotionDuration(PotionEffect effect) {
		int var1 = effect.getDuration();
		int var2 = var1 / 20;
		int var3 = var2 / 60;
		var2 %= 60;
		return var2 < 10 ? var3 + ":0" + var2 : var3 + ":" + var2;
	}

	@Override
	public String name() {
		return "potions";
	}

	@Override
	public String description() {
		return "Displays the active potion effects on you and their times";
	}

}
