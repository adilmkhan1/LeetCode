package June2020_Challenge;

public class ValidateIPAddress {

	public static String validIPAddress(String IP) {
		int count = 0;

		if (IP.indexOf(':') == -1) // IPv4
		{
			for (String p : IP.split("\\.")) {
				count++;

				if (count > 4 || p.isEmpty() || (p.charAt(0) == '0' && p.length() > 1) || p.length() > 3)
					return "Neither";

				for (char c : p.toCharArray()) {
					if (c < '0' || c > '9')
						return "Neither";
					if (!Character.isDigit(c))
						return "Neither";
				}

				int val = Integer.parseInt(p);

				if (val < 0 || val > 255)
					return "Neither";

			}

			return count == 4 && IP.charAt(IP.length() - 1) != '.' ? "IPv4" : "Neither";

		} else // Ipv6
		{
			for (String p : IP.split(":")) {
				count++;

				if (count > 8 || p.isEmpty() || p.length() > 4)
					return "Neither";

				for (char c : p.toCharArray()) {
					if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F'))
						return "Neither";
				}

			}

			return count == 8 && IP.charAt(IP.length() - 1) != ':' ? "IPv6" : "Neither";
		}

	}

	public static void main(String[] args) {

		String IP = "1e1.4.5.6"; // Neither

		String IP_1 = "2001:0db8:85a3:0:0:8A2E:0370:7334"; // IPv6

		String IP_2 = "256.256.256.256"; // Neither

		String IP_3 = "172.16.254.1"; // IPv4

		System.out.println(validIPAddress(IP));

	}

}
