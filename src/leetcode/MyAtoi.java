package leetcode;

public class MyAtoi {
	public int solution(String str) {
		if (str.isBlank()) {
			return 0;
		}
		str = str.trim();
		if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') {
			return 0;
		}
		boolean isNeg = str.charAt(0) == '-' ? true : false;
		long ans = 0;
		int i = Character.isDigit(str.charAt(0)) ? 0 : 1;
		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			ans = ans * 10 + (str.charAt(i++)-'0');
			if (!isNeg && ans > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (isNeg && ans > Integer.MAX_VALUE + 1L) {
				return Integer.MIN_VALUE;
			}
		}
		return isNeg ? -(int)ans : (int)ans;
	}
}
