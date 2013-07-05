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
		assertThat(soundex.encode("Ax"), equalTo("A200"));
	}
	
	@Test
	public void ignoresNonAlphabetics() {
		assertThat(soundex.encode("A#"), equalTo("A000"));
	}
	
	@Test
	public void replacesMultipleConsonantsWithDigits() {
		assertThat(soundex.encode("Acdl"), equalTo("A234"));
	}

	@Test
	public void limitsLengthToFourCharacters() {
		assertThat(soundex.encode("Dcdlb").length(), equalTo(4));
	}
	
}
