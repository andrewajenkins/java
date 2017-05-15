package algo.dp;

public class LongestCommonSubsequence {
	public static Pair lengthLCS(int[] x, int[] y) {
		int m = x.length;
		int n = y.length;
		String[][] b = new String[m][n];
		int[][] c = new int[m][n];
		for(int i = 1; i < m; i++) {
			c[i][0] = 0;
		}
		for(int j = 0; j < n; j++) {
			c[0][j] = 0;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(x[i] == y[j]) {
					c[i][j] = c[i-1][j-1] + 1;
					b[i][j] = "NW";
				} else if(c[i-1][j] >= c[i][j-1]) {
					c[i][j] = c[i-1][j];
					b[i][j] = "NN";
				} else {
					c[i][j] = c[i][j-1];
					b[i][j] = "WW";
				}
			}
		}
		return new Pair(b, c);
	}

	public static void printLCS(String[][] b, int[] x, int i, int j) {
		if(i == 0 || j == 0) {
			return;
		}
		if("NW".equals(b[i][j])) {
			printLCS(b, x, i-1, j-1);
			System.out.println(x[i]);
		} else if("NN".equals(b[i][j])) {
			printLCS(b, x, i-1, j);
		} else {
			printLCS(b, x, i, j-1);
		}
	}

	static class Pair {
		String[][] b;
		int[][] c;
		Pair(String[][] b, int[][] c) {
			this.b = b; 
			this.c = c;
		}
	}

	public static void main(String[] args) {
		int[] c1 = {1,2,2,3,3,4,2,3,1,3,4,3,2,3,2,3,3,1,1,3,2,2,3,3,2,2,3,1,1};
		int[] c2 = {3,4,2,3,4,4,2,3,3,1,1,4,3,2,2,3,4,4,3,2,4,2,4,3,4,1,1,1,1};
		Pair r = lengthLCS(c1, c2);
		printLCS(r.b, c1, c1.length-1, c2.length-1);
	}
}
