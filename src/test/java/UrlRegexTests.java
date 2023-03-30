import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UrlRegexTests {
    @Test
    public void nullStr() { assertFalse(Regex.IsUrl("")); }

    @Test
    public void invalidReverseSolidus() { assertFalse(Regex.IsUrl("https://example.org\\path\\to\\file")); }

    @Test
    public void wrongSymbols() { assertFalse(Regex.IsUrl("https://example.org/>")); }

    @Test
    public void specialSchemeMissingFollowingSolidus() { assertFalse(Regex.IsUrl("https:example.org")); }

    @Test
    public void portOutOfRange() { assertFalse(Regex.IsUrl("https://example.org:70000")); }

    @Test
    public void withoutHttps() { assertFalse(Regex.IsUrl("example.org")); }

    @Test
    public void withoutTopLevelDomain() { assertFalse(Regex.IsUrl("https://#fragment")); }
    
    @Test
    public void nullDomainName() { assertFalse(Regex.IsUrl("https://example..org")); }

    @Test
    public void correctUrl1() { assertTrue(Regex.IsUrl("https://example.org/")); }

    @Test
    public void correctUrl2() { assertTrue(Regex.IsUrl("http://www.договор.ру")); }

    @Test
    public void correctUrl3() { assertTrue(Regex.IsUrl("https://url.spec.whatwg.org/")); }

    @Test
    public void correctUrl4() { assertTrue(Regex.IsUrl("https://example.org/d/d/d/")); }
}
