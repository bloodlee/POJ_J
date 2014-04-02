package org.yli.general.algo;

public class DynamicProg1 {
  final static int[] PRICE_TABLE = new int[] {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
  final static int N = PRICE_TABLE.length;

  public static void main(String[] args) {

    System.out.println("N is " + N);

    long startTime = System.nanoTime();

    for (int j = 0; j < 1; ++j) {
      // for (int i = 1; i < 15; ++i) {
//        int max = maxCut(PRICE_TABLE, 30);
//        System.out.println("max of is " + max);

      int max2 = maxCut2(PRICE_TABLE, 10);
      System.out.println("max of is " + max2);

      int max3 = maxCut2(PRICE_TABLE, 10);
      System.out.println("max of is " + max3);
      //}
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

  private static int maxCut2(int[] p, int n) {
    int[] p_r = new int[n];

    for (int i = 0; i < n; ++i) {
      p_r[i] = Integer.MIN_VALUE;
    }

    return doMaxCut2(p, p_r, n);
  }

  private static int maxCut3(int[] p, int n) {
    int[] p_r = new int[n];

    for (int i = 0; i < n; ++i) {
      p_r[i] = Integer.MIN_VALUE;
    }

    for (int i = 1; i <= n; ++i) {

      int q = Integer.MIN_VALUE;

      for (int j = 1; j < i; ++j) {

        int left = j;
        int right = i - j;

        int left_value = p_r[left - 1] > 0 ? p_r[left - 1] : p[left];
        int right_value = p_r[right - 1] > 0 ? p_r[right - 1] : p[right];

        q = Math.max(q, left_value + right_value);
      }

      p_r[i - 1] = q;
    }

    return p_r[n - 1];
  }

  private static int doMaxCut2(int[] p, int[] p_r, int n) {

    if (n == 0) {
      return 0;
    }

    if (p_r[n - 1] > 0) {
      return p_r[n - 1];
    }

    int q = Integer.MIN_VALUE;

    for (int i = 1; i <= Math.min(N, n); ++i) {
      q = Math.max(q, p[i - 1] + doMaxCut2(p, p_r, n - i));
    }

    p_r[n - 1] = q;

    return q;
  }
}
