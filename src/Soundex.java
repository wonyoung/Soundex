import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


class Soundex {

	private static final int MAX_CODE_LENGTH = 4;
	private static final String NotADigit = "*";

	public String encode(String word) {
		return StringUtil.zeroPad(StringUtil.upperFront(StringUtil.head(word)) + StringUtil.tail(encodedDigits(word)), MAX_CODE_LENGTH);
	}

	private String encodedDigits(final String word) {
		String encoding = new String();
		encoding = encodeHead(encoding, word);
		encoding = encodeTail(encoding, word);
		return encoding;
	}
	
	private String encodeHead(String encoding, final String word) {
		encoding += encodedDigit(word.charAt(0));
		return encoding;
	}

	private String encodeTail(String encoding, final String word) {
		for (int i = 1; i < word.length(); i++) {
			if (!isComplete(encoding)) {
				char letter = word.charAt(i);
				char lastLetter = word.charAt(i-1);
				encoding = encodeLetter(encoding, letter, lastLetter);
			}
		}
		return encoding;
	}

	private String encodeLetter(String encoding, final char letter, final char lastLetter) {
		String digit = encodedDigit(letter);
		if (!digit.equals(NotADigit) && (!digit.equals(lastDigit(encoding)) || CharUtil.isVowel(lastLetter))) {
			encoding += digit;
		}
		return encoding;
	}

	private String lastDigit(String encoding) {
		if (encoding.isEmpty())
			return NotADigit;
		return encoding.substring(encoding.length()-1, encoding.length());
	}

	private boolean isComplete(final String encoding) {
		return encoding.length() == MAX_CODE_LENGTH;
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
		char lowerLetter = CharUtil.lower(letter);
		return encodings.containsKey(lowerLetter) ? encodings.get(lowerLetter):NotADigit;
	}

}