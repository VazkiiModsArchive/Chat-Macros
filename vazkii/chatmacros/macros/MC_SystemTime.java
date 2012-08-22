package vazkii.chatmacros.macros;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MC_SystemTime extends MacroCode {

	@Override
	public String toString() {
		return new SimpleDateFormat("HH:mm").format(new Date());
	}

	@Override
	public String name() {
		return "systime";
	}

	@Override
	public String description() {
		return "Displays the System Time";
	}

}
