
public class StringUtil {

	public static String head(final String word) {
		return word.substring(0, 1);
	}

	public static String tail(final String word) {
		return word.substring(1);
	}
	
	public static String upperFront(final String string) {
		return string.substring(0,1).toUpperCase() + string.substring(1);
	}
	
	public static String zeroPad(final String word, int length) {
		int zerosNeeded = length - word.length();
		return word + new String(new char[zerosNeeded]).replace('\u0000', '0');
	}

}
