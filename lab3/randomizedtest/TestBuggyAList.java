package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  @Test
  /**Simple Comparison Test **/
    public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> correct_AList = new AListNoResizing<>();
      BuggyAList<Integer> buggy_AList = new BuggyAList<>();

      correct_AList.addLast(4);
      correct_AList.addLast(5);
      correct_AList.addLast(6);

      buggy_AList.addLast(4);
      buggy_AList.addLast(5);
      buggy_AList.addLast(6);

      assertEquals(buggy_AList.size(), correct_AList.size());

      assertEquals(buggy_AList.removeLast(), correct_AList.removeLast());
      assertEquals(buggy_AList.removeLast(), correct_AList.removeLast());
      assertEquals(buggy_AList.removeLast(), correct_AList.removeLast());

  }

  @Test
  public void randomizedTest() {
    AListNoResizing<Integer> L = new AListNoResizing<>();
    BuggyAList<Integer> buggy_AList = new BuggyAList<>();

    int N = 5000;
    for (int i = 0; i < N; i += 1) {
      int operationNumber = StdRandom.uniform(0, 4);
      if (operationNumber == 0) {
        // addLast
        int randVal = StdRandom.uniform(0, 100);
        L.addLast(randVal);
        buggy_AList.addLast(randVal);
        System.out.println("addLast(" + randVal + ")");
      } else if (operationNumber == 1) {
        // size
        int size1 = L.size();
        int size2 = buggy_AList.size();
        System.out.println("size1: " + size1);
        System.out.println("size2: " + size2);
      } else if (operationNumber == 2) {
        // getLast
        if (L.size() == 0) {
          continue;
        } else {
          int lastNumber = L.getLast();
          System.out.println("getLast(" + lastNumber + ")");
        }
        if (buggy_AList.size() == 0) {
          continue;
        } else {
          int lastNumber = buggy_AList.getLast();
          System.out.println("getLast(" + lastNumber + ")");
        }
      } else if (operationNumber == 3) {
        // removeLast
        if (L.size() == 0) {
          continue;
        } else {
          int removedLast = L.removeLast();
          System.out.println("removeLast(" + removedLast + ")");
        }
        if (buggy_AList.size() == 0) {
          continue;
        } else {
          int removedLast = buggy_AList.removeLast();
          System.out.println("removeLast(" + removedLast + ")");
        }
      }
    }
  }
}
