
class Soundex {

	public String encode(String word) {
		return zeroPad(word);
	}

	private String zeroPad(String word) {
		return word + "000";
	}

}