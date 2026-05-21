package stacksandqueues.stacks.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterSmallerElements {
    public int[] previousGreaterElements(int[] arr) {
        int len = arr.length;
        Stack<Integer> monotonicStack = new Stack<>();
        int[] pge = new int[len];
        for (int i = 0; i < len; i++) {
            while (!monotonicStack.isEmpty() && monotonicStack.peek() < arr[i]) {
                monotonicStack.pop();
            }
            if (monotonicStack.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = monotonicStack.peek();
            }
            monotonicStack.push(arr[i]);
        }
        return pge;

    }

    public int[] previousGreaterElementIndex(int[] arr) {
        int len = arr.length;
        Stack<Integer> monotonicStack = new Stack<>();
        int[] pge = new int[len];
        Arrays.fill(pge, -1);
        for (int i = len - 1; i >= 0; i++) {
            while (!monotonicStack.isEmpty() && arr[i] > arr[monotonicStack.peek()]) {
                pge[monotonicStack.pop()] = arr[i];
            }
            monotonicStack.push(i);
        }
        return pge;
    }

    public int[] previousSmallerElementValue(int[] arr) {
        int len = arr.length;
        Stack<Integer> monotonicStack = new Stack<>();
        int[] pse = new int[len];
        for (int i = 0; i < len; i++) {
            while (!monotonicStack.isEmpty() && arr[i] < monotonicStack.peek()) {
                monotonicStack.pop();
            }
            if (monotonicStack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = monotonicStack.peek();
            }
            monotonicStack.push(arr[i]);
        }
        return pse;
    }

    public int[] previousSmallerElementIndex(int[] arr) {
        int len = arr.length;
        Stack<Integer> monotonicStack = new Stack<>();
        int[] pse = new int[len];
        Arrays.fill(pse, -1);
        for (int i = len - 1; i >= 0; i--) {
            while (!monotonicStack.isEmpty() &&
                    arr[i] < arr[monotonicStack.peek()]) {
                pse[monotonicStack.pop()] = arr[i];
            }
            monotonicStack.push(i);
        }
        return pse;
    }
}
