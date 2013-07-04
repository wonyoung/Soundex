
class Soundex {

	public String encode(String word) {
		return zeroPad(head(word) + encodedDigits(word));
	}

	private String encodedDigits(String word) {
		if (word.length() > 1)
			return "1";
		return "";
	}

	private String head(String word) {
		return word.substring(0, 1);
	}

	private String zeroPad(String word) {
		int zerosNeeded = 4 - word.length();
		return word + new String(new char[zerosNeeded]).replace('\u0000', '0');
	}

}