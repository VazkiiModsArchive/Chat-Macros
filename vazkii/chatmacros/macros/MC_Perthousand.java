package vazkii.chatmacros.macros;

import java.util.Random;

public class MC_Perthousand extends MacroCode {

	@Override
	public String toString() {
		return "" + (new Random().nextInt(1000) + 1);
	}

	@Override
	public String name() {
		return "pert";
	}

	@Override
	public String description() {
		return "Displays a random number between 1 and 1000";
	}

}
