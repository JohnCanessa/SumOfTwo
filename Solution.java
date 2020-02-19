import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 
 */
public class Solution {

  /**
   * Determine wheater there is a pair of numbers, where one number is taken from
   * a and the other from b, that can be added together to get a sum of v. Return
   * true if such a pair exists, otherwise return false.
   * 
   * Brure force approach. O(n^2).
   */
  static boolean sumOfTwo(int[] a, int[] b, int v) {

    // **** traverse both arrays (O(n^2)) ****
    for (int i = 0; i < a.length; i++) {

      // **** desired value in array b ****
      int x = v - a[i];

      // **** look for it in array b ****
      for (int j = 0; j < b.length; j++) {
        if (b[j] == x) {
          return true;
        }
      }
    }

    // **** value not found ****
    return false;
  }

  /**
   * Determine wheater there is a pair of numbers, where one number is taken from
   * a and the other from b, that can be added together to get a sum of v. Return
   * true if such a pair exists, otherwise return false.
   * 
   * O(n) approach.
   */
  static boolean sumOfTwo1(int[] a, int[] b, int v) {

    // **** values of array b ****
    HashSet<Integer> hs = new HashSet<Integer>();

    // **** add the values of array b into the hash set (O(n))****
    for (int i = 0; i < b.length; i++) {
      hs.add(b[i]);
    }

    // *** traverse array a looking for a value in the hash set (O(n)) ****
    for (int i = 0; i < a.length; i++) {

      // **** desired value ****
      int x = v - a[i];

      // **** look for it in the hash set ****
      if (hs.contains(x)) {
        return true;
      }
    }

    // **** value not found ****
    return false;
  }

  /**
   * Test scaffolding.
   */
  public static void main(String[] args) {

    // **** open scanner ****
    Scanner sc = new Scanner(System.in);

    // **** read the contents for array a ****
    String s = sc.nextLine();
    String[] ss = s.split(" ");
    int[] a = new int[ss.length];
    for (int i = 0; i < a.length; i++) {
      a[i] = Integer.parseInt(ss[i]);
    }

    // ???? ????
    System.out.println("main <<< a: " + Arrays.toString(a));

    // **** read the contents for array b ****
    s = sc.nextLine();
    ss = s.split(" ");
    int[] b = new int[ss.length];
    for (int i = 0; i < b.length; i++) {
      b[i] = Integer.parseInt(ss[i]);
    }

    // ???? ????
    System.out.println("main <<< b: " + Arrays.toString(b));

    // **** read the value ****
    int v = sc.nextInt();

    // ???? ????
    System.out.println("main <<< v: " + v);

    // **** ****
    System.out.println("main <<< " + sumOfTwo(a, b, v));
    System.out.println("main <<< " + sumOfTwo1(a, b, v));

    // **** close scanner ****
    sc.close();
  }
}