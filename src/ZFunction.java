public class ZFunction {
	public static int[] solve(String string) {
		int[] z = new int[string.length()];
		for(int i = 1, l = 0, r = 0; i < string.length(); ++i) {
			if(i <= r)
				z[i] = Math.min(r - i + 1, z[i - l]);
			while(i + z[i] < string.length() && string.charAt(z[i]) == string.charAt(i + z[i]))
				z[i]++;
			if(i + z[i] - 1 > r) {
				l = i;
				r = i + z[i] - 1;
			}
		}
		return z;
	}
}
