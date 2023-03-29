import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IpV4RegexTests {
    @Test
    public void emptyStr(){
        assertFalse(Regex.IsIpV4Address(""));
    }

    @Test
    public void pointBegin(){
        assertFalse(Regex.IsIpV4Address(".125.0.15.255"));
    }

    @Test
    public void pointEnd(){
        assertFalse(Regex.IsIpV4Address("125.0.15.255."));
    }

    @Test
    public void ipWithLetterStr(){
        assertFalse(Regex.IsIpV4Address("12g.0.15.255"));
    }

    @Test
    public void ipWithSymbolStr(){
        assertFalse(Regex.IsIpV4Address("125.*0.15.255"));
    }

    @Test
    public void wrongSeparator() { assertFalse(Regex.IsIpV4Address("125-0-15-255")); }

    @Test
    public void outOfRange1(){
        assertFalse(Regex.IsIpV4Address("358.0.15.255"));
    }

    @Test
    public void outOfRange2(){
        assertFalse(Regex.IsIpV4Address("125.257.15.255"));
    }

    @Test
    public void outOfRange3(){
        assertFalse(Regex.IsIpV4Address("125.0.1527.255"));
    }

    @Test
    public void outOfRange4(){
        assertFalse(Regex.IsIpV4Address("125.0.15.300"));
    }

    @Test
    public void nullBegin(){
        assertFalse(Regex.IsIpV4Address("025.0.15.255"));
    }

    @Test
    public void moreParts(){
        assertFalse(Regex.IsIpV4Address("12.5.0.15.25.5"));
    }

    @Test
    public void lessParts() { assertFalse(Regex.IsIpV4Address("125.0")); }

    @Test
    public void correctStr1(){ assertTrue(Regex.IsIpV4Address("125.0.15.255")); }

    @Test
    public void correctStr2() { assertTrue(Regex.IsIpV4Address("12.50.152.55")); }

    @Test
    public void maxRangeValue(){ assertTrue(Regex.IsIpV4Address("255.255.255.255")); }
}
