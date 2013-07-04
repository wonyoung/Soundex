import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

class Soundex {

	public String encode(String word) {
		return "A";
	}

}

public class SoundexTest {

	@Test
	public void retainsSoleLetterOfOneLetterWord() {
		Soundex soundex = new Soundex();
		
		String encoded = soundex.encode("A");
		
		assertThat(encoded, equalTo("A"));
	}

}
