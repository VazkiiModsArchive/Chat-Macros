package vazkii.chatmacros.macros;

import java.util.Calendar;

public class MC_Timezone extends MacroCode {

	@Override
	public String toString() {
		return Calendar.getInstance().getTimeZone().getDisplayName();
	}

	@Override
	public String name() {
		return "timezone";
	}

	@Override
	public String description() {
		return "Displays your Timezone";
	}

}
