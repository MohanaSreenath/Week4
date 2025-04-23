public class ValidateIPAddress {
    public static boolean isValidIPAddress(String ip) {
        return ip.matches("\\b((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\b");
    }

    public static void main(String[] args) {
        System.out.println(isValidIPAddress("192.168.1.1"));
        System.out.println(isValidIPAddress("999.999.999.999"));
    }
}