package vazkii.chatmacros.macros;

import java.util.Random;

public class MC_DiceRoll extends MacroCode {

	@Override
	public String toString() {
		return "" + (new Random().nextInt(6) + 1);
	}

	@Override
	public String name() {
		return "dice";
	}

	@Override
	public String description() {
		return "Displays a random number between 1 and 6";
	}

}
