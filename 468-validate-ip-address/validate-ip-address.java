class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.isEmpty()) return "Neither";

        if (queryIP.contains(".")) {
            return isValidIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.contains(":")) {
            return isValidIPv6(queryIP) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }

    private boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) return false;
            if (part.charAt(0) == '0' && part.length() > 1) return false;
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        }

        return true;
    }

    private boolean isValidIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) return false;
            for (char c : part.toCharArray()) {
                if (!isHexDigit(c)) return false;
            }
        }

        return true;
    }

    private boolean isHexDigit(char c) {
        return Character.isDigit(c) ||
               (c >= 'a' && c <= 'f') ||
               (c >= 'A' && c <= 'F');
    }
}
