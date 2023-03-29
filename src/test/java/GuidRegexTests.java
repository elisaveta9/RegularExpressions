import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GuidRegexTests {
    @Test
    public void nullStr(){
        assertFalse(Regex.IsGuid(""));
    }

    @Test
    public void russianLetters(){
        assertFalse(Regex.IsGuid("са761232-еd42-11се-bасd-00аа0057b223"));
    }

    @Test
    public void lettersOutOfRange(){
        assertFalse(Regex.IsGuid("Ra761232ed4211cetacd00aa0057b223"));
    }

    @Test
    public void lessLength1(){
        assertFalse(Regex.IsGuid("ca761232-ed42-11ce-bacd-00aa0057b2"));
    }

    @Test
    public void lessLength2(){
        assertFalse(Regex.IsGuid("{ca761232-11ce-bacd-00aa0057b223}"));
    }

    @Test
    public void moreLength1(){
        assertFalse(Regex.IsGuid("ca761232-ed42-11ce-bacd00-aa0057b223abc"));
    }

    @Test
    public void moreLength2(){
        assertFalse(Regex.IsGuid("{ca761232-ed42-ed42-11ce-bacd-00aa0057b223}"));
    }

    @Test
    public void differentBrackets1(){
        assertFalse(Regex.IsGuid("{ca761232-ed42-11ce-bacd-00aa0057b223)"));
    }

    @Test
    public void differentBrackets2(){
        assertFalse(Regex.IsGuid("(ca761232-ed42-11ce-bacd-00aa0057b223}"));
    }

    @Test
    public void wrongBrackets1(){
        assertFalse(Regex.IsGuid("[ca761232-ed42-11ce-bacd-00aa0057b223)"));
    }

    @Test
    public void wrongBrackets2(){
        assertFalse(Regex.IsGuid("{ca761232-ed42-11ce-bacd-00aa0057b223]"));
    }

    @Test
    public void wrongSeparator(){
        assertFalse(Regex.IsGuid("{ca761232|ed42|11ce|bacd|00aa0057b223}"));
    }

    @Test
    public void withoutSeparator(){
        assertFalse(Regex.IsGuid("{ca761232ed4211cebacd00aa0057b223}"));
    }

    @Test
    public void correctGuid(){
        assertTrue(Regex.IsGuid("{ca761232-ed42-11ce-bacd-00aa0057b223}"));
    }
}
