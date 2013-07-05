
public class CharUtil {

	public static char lower(final char c) {
		return Character.toLowerCase(c);
	}

	public static boolean isVowel(final char lastLetter) {
		return "aeiouy".contains(""+lower(lastLetter));
	}

}
