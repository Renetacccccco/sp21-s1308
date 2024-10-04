package tester;

import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.algs4.StdRandom;

public class TestArrayDequeEC {

   @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionDeque = new ArrayDequeSolution<>();
        StringBuilder operations = new StringBuilder(); // To keep track of operations.

        for (int i = 0; i < 1000; i++) {
            int operation = StdRandom.uniform(4);
            Integer expected = null;
            Integer actual = null;

            if (operation == 0 && !solutionDeque.isEmpty()) { // removeFirst
                operations.append("removeFirst()\n");
                expected = solutionDeque.removeFirst();
                actual = studentDeque.removeFirst();
                assertEquals(operations.toString(), expected, actual);
            } else if (operation == 1 && !solutionDeque.isEmpty()) { // removeLast
                operations.append("removeLast()\n");
                expected = solutionDeque.removeLast();
                actual = studentDeque.removeLast();
                assertEquals(operations.toString(), expected, actual);
            } else if (operation == 2) { // addFirst
                int randVal = StdRandom.uniform(0, 100);
                operations.append("addFirst(").append(randVal).append(")\n");
                studentDeque.addFirst(randVal);
                solutionDeque.addFirst(randVal);
            } else if (operation == 3) { // addLast
                int randVal = StdRandom.uniform(0, 100);
                operations.append("addLast(").append(randVal).append(")\n");
                studentDeque.addLast(randVal);
                solutionDeque.addLast(randVal);
            }
        }
    }
}
