
class Soundex {

	private static final int MAX_CODE_LENGTH = 4;

	public String encode(String word) {
		return zeroPad(head(word) + encodedDigits(word));
	}

	private String encodedDigits(String word) {
		if (word.length() > 1)
			return encodedDigit(word.charAt(1));
		return "";
	}

	private String encodedDigit(char letter) {
		if (letter == 'c')
			return "2";
		return "1";
	}

	private String head(String word) {
		return word.substring(0, 1);
	}

	private String zeroPad(String word) {
		int zerosNeeded = MAX_CODE_LENGTH - word.length();
		return word + new String(new char[zerosNeeded]).replace('\u0000', '0');
	}

}