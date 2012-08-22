package vazkii.chatmacros.macros;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MC_SystemDate extends MacroCode {

	@Override
	public String toString() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	@Override
	public String name() {
		return "sysdate";
	}

	@Override
	public String description() {
		return "Displays the System Date";
	}

}
