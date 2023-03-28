import java.util.regex.Pattern;

public class Regex {

    public static boolean IpV4Address(String str){
        String ipV4AddressPattern = "^((\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}" +
                "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])$";
        return Pattern.matches(ipV4AddressPattern, str);
    }

    public static boolean GUID(String str){
        String GuidPattern =
                "^\\{?(?:[\\da-fA-F]{8}-(?:[\\da-fA-F]{4}-){3}[\\da-fA-F]{12})\\}?$|^\\(?(?:[\\da-fA-F]{8}-(?:[\\da-fA-F]{4}-){3}[\\da-fA-F]{12})\\)?";
        return Pattern.matches(GuidPattern, str);
    }

    public static boolean URL(String str){
        String UrlRegex = "^https?:\\/\\/(www\\.)?[-a-zA-Z\\d@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z\\d()@:%_\\+.~#?&//=]*)";
        return Pattern.matches(UrlRegex,str);
    }

    public static boolean StrongPassword(String str){
        String passPattern =
                "(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\\d)(?=.*?[-~!@#%&_=;:'\"<>,/\\.\\^\\$\\*\\+\\?\\{\\}\\[\\]\\\\|\\(\\)])" +
                        "[\\w-~!@#%&_=;:'\"<>,/\\.\\^\\$\\*\\+\\?\\{\\}\\[\\]\\\\|\\(\\)]{8,}";
        return Pattern.matches(passPattern, str);
    }
}
