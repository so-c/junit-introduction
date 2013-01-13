package chapter18.practice1;

public class StringUtils {
	private StringUtils() {
		super();
	}
	
	public static String toSnakeCase(String string) {
		if (string == null) {
			throw new NullPointerException("string == null");
		}
		String convertedString = string.replaceAll("([a-z])([A-Z])", "$1_$2");
		convertedString = convertedString.toLowerCase();
		return convertedString;
	}
}
