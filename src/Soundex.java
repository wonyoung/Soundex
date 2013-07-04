
class Soundex {

	public String encode(String word) {
		String encoded = word.substring(0, 1);
		if (word.length() > 1) {
			encoded += "1";
		}
		return zeroPad(encoded);
	}

	private String zeroPad(String word) {
		int zerosNeeded = 4 - word.length();
		return word + new String(new char[zerosNeeded]).replace('\u0000', '0');
	}

}