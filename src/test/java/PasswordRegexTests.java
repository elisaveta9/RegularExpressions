import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordRegexTests {
    @Test
    public void nullStr() { assertFalse(Regex.IsStrongPassword("")); }

    @Test
    public void onlyLowerLetters() { assertFalse(Regex.IsStrongPassword("qwertynull")); }

    @Test
    public void onlyUpperLetters() { assertFalse(Regex.IsStrongPassword("QWERTYNULL")); }

    @Test
    public void onlyNumbers() { assertFalse(Regex.IsStrongPassword("1234567890")); }

    @Test
    public void onlySymbols() { assertFalse(Regex.IsStrongPassword("!@$%^&*()))")); }

    @Test
    public void lowerLettersAndNumbers() { assertFalse(Regex.IsStrongPassword("qwerty1234")); }

    @Test
    public void upperLettersAndNumbers() { assertFalse(Regex.IsStrongPassword("QWERTY1234")); }

    @Test
    public void lowerLettersNumbersSymbols() { assertFalse(Regex.IsStrongPassword("qwerty12!")); }

    @Test
    public void upperLettersNumbersSymbols() { assertFalse(Regex.IsStrongPassword("QWERTY123#")); }

    @Test
    public void lettersAndNumbers() { assertFalse(Regex.IsStrongPassword("QwErTy1234")); }

    @Test
    public void lessLength() { assertFalse(Regex.IsStrongPassword("P@ss23!")); }

    @Test
    public void strongPassword() { assertTrue(Regex.IsStrongPassword("P@ss23!W^5")); }
}
