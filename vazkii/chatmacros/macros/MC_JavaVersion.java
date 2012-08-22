package vazkii.chatmacros.macros;

public class MC_JavaVersion extends MacroCode {

	@Override
	public String toString() {
		return System.getProperty("java.version");
	}

	@Override
	public String name() {
		return "java";
	}

	@Override
	public String description() {
		return "Displays the your version of Java";
	}

}
