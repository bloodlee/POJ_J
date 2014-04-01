package org.yli.general.algo;

public class DynamicProg1 {
  final static int[] PRICE_TABLE = new int[] {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  final static int N = PRICE_TABLE.length;

  public static void main(String[] args) {

    System.out.println("N is " + N);

    long startTime = System.nanoTime();

    for (int j = 0; j < 10; ++j) {
      for (int i = 1; i < 15; ++i) {
        int max = maxCut(PRICE_TABLE, i);
        System.out.println("max of " + i + " is " + max);
      }
    }

    System.out.println("duration is " + (System.nanoTime() - startTime) / 1000000000.0 + "s");
  }

  private static int maxCut(int[] p, int n) {
    if (n == 0) {
      return 0;
    }

    int q = Integer.MIN_VALUE;

    for (int i = 1; i <= Math.min(N, n); ++i) {
      q = Math.max(q, p[i - 1] + maxCut(p, n - i));
    }

    return q;
  }

}
