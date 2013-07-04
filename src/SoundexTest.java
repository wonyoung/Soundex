import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SoundexTest {

	private Soundex soundex = new Soundex();

	@Test
	public void retainsSoleLetterOfOneLetterWord() {
		assertThat(soundex.encode("A"), equalTo("A000"));
	}

	@Test
	public void padsWithZerosToEnsureThreeDigits() {
		assertThat(soundex.encode("I"), equalTo("I000"));
	}

	@Test
	public void replacesConsonantsWithAppropriateDigits() {
		assertThat(soundex.encode("Ab"), equalTo("A100"));
		assertThat(soundex.encode("Ac"), equalTo("A200"));
		assertThat(soundex.encode("Ad"), equalTo("A300"));
	}

}
