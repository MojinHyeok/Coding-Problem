package 코테꿀문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOj_16639_괄호추가하기3 {

	static int[][] min, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String x = br.readLine();
		min = new int[n][n];
		max = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
			Arrays.fill(max[i], Integer.MIN_VALUE);
		}
		for (int i = 0; i < n; i += 2) {

			min[i][i] = x.charAt(i) - '0';
			max[i][i] = x.charAt(i) - '0';
		}
		for (int j = 2; j < n; j += 2) {
			for (int i = 0; i < n - j; i += 2) {
				for (int k = 2; k <= j; k += 2) {
					char op = x.charAt(i + k - 1);
					int[] num = new int[4];
					num[0] = calc(max[i][i + k - 2], max[i + k][i + j], op);
					num[1] = calc(min[i][i + k - 2], max[i + k][i + j], op);
					num[2] = calc(max[i][i + k - 2], min[i + k][i + j], op);
					num[3] = calc(min[i][i + k - 2], min[i + k][i + j], op);
					Arrays.sort(num);
					max[i][i + j] = Math.max(max[i][i + j], num[3]);
					min[i][i + j] = Math.min(min[i][i + j], num[0]);
				}
			}
		}
		System.out.println(max[0][n - 1]);
	}

	static int calc(int num1, int num2, char op) {
		int res = 0;
		if (op == '+') {
			res = num1 + num2;
		} else if (op == '-') {
			res = num1 - num2;
		} else if (op == '*') {
			res = num1 * num2;
		}
		return res;
	}

}
