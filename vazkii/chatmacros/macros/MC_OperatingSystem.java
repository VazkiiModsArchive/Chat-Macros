package vazkii.chatmacros.macros;

public class MC_OperatingSystem extends MacroCode {

	@Override
	public String toString() {
		return System.getProperty("os.name");
	}

	@Override
	public String name() {
		return "os";
	}

	@Override
	public String description() {
		return "Displays your Operating System";
	}

}
