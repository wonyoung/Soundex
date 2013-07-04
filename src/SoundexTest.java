import static org.junit.Assert.*;

import org.junit.Test;

class Soundex {

}

public class SoundexTest {

	@Test
	public void retainsSoleLetterOfOneLetterWord() {
		Soundex soundex = new Soundex();
		
		String encoded = soundex.encode("A");
	}

}

