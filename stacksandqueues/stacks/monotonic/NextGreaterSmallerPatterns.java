package stacksandqueues.stacks.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterSmallerPatterns {

    //Right to left
    public int[] nextLargerElementValue(int[] arr) {
        int nge[] = new int[arr.length];
        Stack<Integer> monotonicStack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!monotonicStack.isEmpty() && monotonicStack.peek() < arr[i]) {
                monotonicStack.pop();
            }
            if (monotonicStack.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = monotonicStack.peek();
            }
            monotonicStack.push(arr[i]);
        }
        return nge;
    }

    //left to rigth
    public int[] nextLargerElementIndex(int[] arr) {
        int len = arr.length;
        int nge[] = new int[arr.length];
        Arrays.fill(nge, -1);
        Stack<Integer> monotonicStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!monotonicStack.isEmpty() && arr[monotonicStack.peek()] < arr[i]) {
                nge[monotonicStack.pop()] = arr[i];
            }
            monotonicStack.push(i);
        }
        return nge;
    }

    public int[] nextSmallerElementValue(int[] arr) {
        int len = arr.length;
        Stack<Integer> monotonicStack = new Stack<>();
        int[] nse = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!monotonicStack.isEmpty() && arr[i] < monotonicStack.peek()) {
                monotonicStack.pop();
            }
            if (monotonicStack.isEmpty()) {
                nse[i] = -1;
            } else {
                nse[i] = monotonicStack.peek();
            }
            monotonicStack.push(arr[i]);
        }
        return nse;
    }

    public int[] nextSmallerElementIndex(int[] arr) {
        int len = arr.length;
        Stack<Integer> monotonicStack = new Stack<>();
        int[] nse = new int[len];
        Arrays.fill(nse, -1);
        for (int i = 0; i < len; i++) {
            while (!monotonicStack.isEmpty() && arr[i] < arr[monotonicStack.peek()]) {
                nse[monotonicStack.pop()] = arr[i];
            }
            monotonicStack.push(i);
        }
        return nse;
    }

}
