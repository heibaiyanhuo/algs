package leetcode.problems;


public class A468_Validate_IP_Address {

    private String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) return "Neither";
        if (isValidIPv4(IP)) return "IPv4";
        if (isValidIPv6(IP)) return "IPv6";
        return "Neither";
    }

    private boolean isValidIPv4(String s) {
        if (s.charAt(s.length() - 1) == '.') return false;
        String[] segments = s.split("\\.");
        if (segments.length != 4) return false;
        for (String segment: segments) {
            if (!isValidIPv4Segment(segment)) return false;
        }
        return true;
    }

    private boolean isValidIPv4Segment(String segment) {
        if (segment.length() < 1 || segment.length() > 3) return false;
        if (segment.length() > 1 && segment.charAt(0) == '0') return false;
        for (int i = 0; i < segment.length(); i++) {
            if (!Character.isDigit(segment.charAt(i))) return false;
        }
        int val = Integer.parseInt(segment);
        return (0 <= val) && (val <= 255);
    }

    private boolean isValidIPv6(String s) {
        if (s.charAt(s.length() - 1) == ':') return false;
        String[] segments = s.split(":");
        if (segments.length != 8) return false;
        for (String segment: segments) {
            if (!isValidIPv6Segment(segment)) return false;
        }
        return true;
    }

    private boolean isValidIPv6Segment(String segment) {
        return segment.matches("^[a-fA-F0-9]{1,4}$");
    }

    public boolean isValidIPv6Segment2(String segment) {
        if (segment.length() < 1 || segment.length() > 4) return false;
        for (int i = 0; i < segment.length(); i++) {
            char c = segment.charAt(i);
            boolean isDigit = (c >= '0' && c <= '9');
            boolean isUppercaseAF = (c >= 'A' && c <= 'F');
            boolean isLowerCaseAF = (c >= 'a' && c <= 'f');
            if(!(isDigit || isUppercaseAF || isLowerCaseAF)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        A468_Validate_IP_Address solution = new A468_Validate_IP_Address();
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String[] arr = IP.split("\\.");
        System.out.println(solution.validIPAddress(IP));
    }

}
