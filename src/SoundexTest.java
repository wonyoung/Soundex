import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Soundex {

	public String encode(String word) {
		return zeroPad(word);
	}

	private String zeroPad(String word) {
		return word + "000";
	}

}

public class SoundexTest {
	
	private Soundex soundex = new Soundex();

	@Test
	public void retainsSoleLetterOfOneLetterWord() {
		String encoded = soundex.encode("A");
		
		assertThat(encoded, equalTo("A000"));
	}

	@Test
	public void padsWithZerosToEnsureThreeDigits() {
		String encoded = soundex.encode("I");
		
		assertThat(encoded, equalTo("I000"));
	}

}
