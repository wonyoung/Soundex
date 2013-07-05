import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


class Soundex {

	private static final int MAX_CODE_LENGTH = 4;

	public String encode(String word) {
		return zeroPad(upperFront(head(word)) + encodedDigits(tail(word)));
	}

	private String upperFront(final String string) {
		return string.substring(0,1).toUpperCase() + string.substring(1);
	}

	private String tail(String word) {
		return word.substring(1);
	}

	private String encodedDigits(String word) {
		String encoding = new String();
		for (char letter : word.toCharArray()) {
			if (isComplete(encoding))
				break;
			if (!encodedDigit(letter).equals(lastDigit(encoding))) {
				encoding += encodedDigit(letter);
			}
		}
		return encoding;
	}

	private String lastDigit(String encoding) {
		if (encoding.isEmpty())
			return "";
		return encoding.substring(encoding.length()-1, encoding.length());
	}

	private boolean isComplete(final String encoding) {
		return encoding.length() == MAX_CODE_LENGTH - 1;
	}

	public String encodedDigit(char letter) {
		@SuppressWarnings("serial")
		final Map<Character, String> encodings = Collections.unmodifiableMap(new HashMap<Character, String> () {{
			put('b', "1"); put('f', "1"); put('p', "1"); put('v', "1");
			put('c', "2"); put('g', "2"); put('j', "2"); put('k', "2"); put('q', "2");
						   put('s', "2"); put('x', "2"); put('z', "2");
			put('d', "3"); put('t', "3");
			put('l', "4");
			put('m', "5"); put('n', "5");
			put('r', "6");
		}});
		return encodings.containsKey(letter) ? encodings.get(letter):"";
	}

	private String head(String word) {
		return word.substring(0, 1);
	}

	private String zeroPad(String word) {
		int zerosNeeded = MAX_CODE_LENGTH - word.length();
		return word + new String(new char[zerosNeeded]).replace('\u0000', '0');
	}

}