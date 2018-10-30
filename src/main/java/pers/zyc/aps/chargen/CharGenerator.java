package pers.zyc.aps.chargen;

/**
 * @author zhangyancheng
 */
public class CharGenerator {

	private final int length;
	private int start = 32;

	public CharGenerator(int length) {
		this.length = length;
	}

	public String next() {
		char[] chars = new char[length];
		for (int i = 0; i < length; i++) {
			chars[i] = (char) (start + i);
		}
		if (++start > 126) {
			start = 32;
		}
		return new String(chars);
	}
}
