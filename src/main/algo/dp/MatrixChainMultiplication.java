package main.algo.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {

	public static int memoizedMatrixChain(int[] p) {
		int n = p.length/2+1;
		int[][] m = new int[n][n];
		for(int i = 1; i < n; i++) {
			for(int j = i; j < n; j++) {
				m[i][j] = Integer.MAX_VALUE;
			}
		}
		return lookupChain(m, p, 1, n - 1);
	}

	public static int lookupChain(int[][] m, int[] p, int i, int j) {
		if(m[i][j] < Integer.MAX_VALUE)
			return m[i][j];
		if(i == j) 
			m[i][j] = 0;
		else {
			for(int k = i; k <= j-1; k++) {
				int q = lookupChain(m, p, i, k) + lookupChain(m, p, k + 1, j) + (p[i-1]*p[k]*p[j]);
				if(q < m[i][j]) {
					m[i][j] = q;
				}
			}
		}
		return m[i][j];
	}

	public static ResultObject matrixChainOrder(int[] p) {
		int n = p.length/2 + 2;
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		for(int i = 0; i < n; i++) {
			m[i][i] = 0;
		}
		for(int l = 2; l <= n; l++) { //l is the chain length
			for(int i = 1; i <= n-l-1; i++) {
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i; k <= j-1; k++) {
					int q = m[i][k] + m[k+1][j] + (p[i-1]*p[k]*p[j]);
					//printDebug(i, j, k, m, p, q);
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		return new ResultObject(m, s);
	}

	public static void printOptimalParens(int[] p, int[][] s, int i, int j) {
		if(i == j) 
			System.out.print("A"+i);
		else {
			System.out.print("(");
			printOptimalParens(p, s, i, s[i][j]);
			printOptimalParens(p, s, s[i][j] + 1, j);
			System.out.print(")");
		}
	}

	public static void printDebug(int i, int j, int k, int[][] m, int[] p, int q) {
		System.out.println("m["+i+"]["+j+"]=m["+i+"]["+k+"]+m["+k+"+1]["+j+"]+p["+i+"-1]p["+k+"]p["+j+"]");
		System.out.println(q+" = "+m[i][k]+" + "+m[k+1][j]+" + "+"("+p[i-1]+"*"+p[k]+"*"+p[j]+"="+(p[i-1]*p[k]*p[j])+")");
	}

	static class ResultObject {
		int[][] m;
		int[][] s;
		ResultObject (int[][] m, int[][] s) {
			this.m = m;
			this.s = s;
		}
	}

	//genericized algorithm for matrix multiplication
	private static int[][] matrixMultiply(int[][] a, int[][] b) {
		if(a[0].length != b.length) {
			throw new RuntimeException("incompatible dimensions");
		} else {
			int[][] c = new int[a.length][b[0].length];
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < b[0].length; j++) {
					c[i][j] = 0;
					for(int k = 0; k < a[0].length; k++) {System.out.println(i+" "+j+" "+k);
						c[i][j] += (a[i][k] * b[k][j]);
					}
				}
			}
			return c;
		}
	}

	//Strassen's algorithm
	private static int[][] squareMatrixMultiply(int[][] a, int[][] b) {
		int n = a[0].length;
		int[][] c = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				c[i][j] = 0;
				for(int k = 0; k < n; k++) {
					c[i][j] += (a[i][k] * b[k][j]);
				}
			}
		}
		return c;
	}

	public static void runMemoizedMatrixChainTest() {
		int[] a = {30,35,15,5,10,20,25,20,15,35,10,5};
		System.out.println(memoizedMatrixChain(a));
	}

	public static void runMatrixChainOrderTest() {
		int[] a = {30,35,15,5,10,20,25,20,15,35,10,5};
		ResultObject ro = matrixChainOrder(a);
		print(ro.m);
		print(ro.s);
		System.out.println("\nFor arrays of size:");
		for(int k = 0; k < a.length/2; k++) System.out.println("A"+(k+1)+" = "+a[k*2]+"x"+a[k*2+1]);
		System.out.println("The optimal parenthesization is");
		printOptimalParens(a, ro.s, 1, ro.s.length - 2);
	}

	public static void runRectangleMatrixTest() {
		int[][] c = {{1,2},{3,4},{5,6}};
		int[][] d = {{1,2,3},{4,5,6}};
		int[][] s = matrixMultiply(c, d);
		System.out.println(Arrays.deepToString(s));
	}

	public static void runSquareMatrixTest() {
		int[][] a = {{1, 2},{3, 4}};
		int[][] b = {{5, 6},{7, 8}};
		int[][] r = squareMatrixMultiply(a, b);
		System.out.println(Arrays.deepToString(r));
	}

	public static void main(String[] args) {
		runMemoizedMatrixChainTest();
//		runMatrixChainOrderTest();
//		runSquareMatrixTest();
//		runRectangleMatrixTest();
	
	}

	public static void print(int[][] ia) {
		for(int[] a : ia) {
			System.out.println(Arrays.toString(a));
		}
	}
}