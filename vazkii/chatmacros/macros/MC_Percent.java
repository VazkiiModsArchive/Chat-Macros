package vazkii.chatmacros.macros;

import java.util.Random;

public class MC_Percent extends MacroCode {

	@Override
	public String toString() {
		return "" + (new Random().nextInt(100) + 1);
	}

	@Override
	public String name() {
		return "perc";
	}

	@Override
	public String description() {
		return "Displays a random number between 1 and 100";
	}

}
