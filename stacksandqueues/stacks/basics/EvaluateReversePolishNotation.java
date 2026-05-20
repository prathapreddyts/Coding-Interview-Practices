package stacksandqueues.stacks.basics;

import java.util.Stack;

/**
 * EVALUATE REVERSE POLISH NOTATION — LeetCode #150 | FAANG Frequency: ⭐⭐⭐⭐⭐
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators: +, -, *, /  (division truncates toward zero)
 *
 * Example 1: tokens = ["2","1","+","3","*"]   → 9   ((2+1)*3)
 * Example 2: tokens = ["4","13","5","/","+"]  → 6   (4+(13/5))
 * Example 3: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"] → 22
 *
 * Constraints: 1 <= tokens.length <= 10^4
 *
 * Pattern: Push numbers; on operator, pop two, compute, push result
 * Time: O(n) | Space: O(n)
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Basic Calculator I — LeetCode #224 (Hard)
    // Expression with +, -, (, ) and spaces. No *, /
    // -----------------------------------------------------------------------

    /**
     * Evaluate expression string with +, -, (, ) and non-negative integers.
     * Example: s = "(1+(4+5+2)-3)+(6+8)" → 23
     *
     * Pattern: Stack for signs. On '(' push current result + sign; on ')' pop.
     */
    public int calculateI(String s) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Basic Calculator II — LeetCode #227 (Medium)
    // Expression with +, -, *, / (no parentheses)
    // -----------------------------------------------------------------------

    /*
     * Evaluate expression with +, -, *, / (integer division, no parentheses).
     * Example: s = " 3+5 / 2 " → 5
     * Example: s = "3+2*2"     → 7
     *
     * Pattern: Handle precedence with stack — push for +/-, compute for
     */
    public int calculateII(String s) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 3: Basic Calculator III — LeetCode #772 (Hard)
    // Expression with +, -, *, / AND parentheses
    // -----------------------------------------------------------------------

    /**
     * Evaluate expression with all four operators + nested parentheses.
     * Example: s = "2*(5+5*2)/3+(6/2+8)" → 21
     *
     * Pattern: Recursive descent parser or stack + nested call
     */
    public int calculateIII(String s) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 4: Decode String — LeetCode #394 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Decode encoded string where k[encoded_string] means repeat k times.
     * Example: s = "3[a]2[bc]"   → "aaabcbc"
     * Example: s = "2[abc]3[cd]ef" → "abcabccdcdcdef"
     * Example: s = "3[a2[c]]"    → "accaccacc"
     *
     * Pattern: Two stacks — one for counts, one for strings
     * Time: O(n * maxK) | Space: O(n)
     */
    public String decodeString(String s) {
        // TODO: implement
        return "";
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 5: Simplify Path — LeetCode #71 (Medium)
    // -----------------------------------------------------------------------

    /**
     * Simplify Unix absolute path: handle ".", "..", multiple slashes.
     * Example: "/home/"          → "/home"
     * Example: "/../"            → "/"
     * Example: "/home//foo/"     → "/home/foo"
     * Example: "/a/./b/../../c/" → "/c"
     *
     * Pattern: Split by '/', use stack — push directories, pop on ".."
     */
    public String simplifyPath(String path) {
        // TODO: implement
        return "";
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        System.out.println(e.evalRPN(new String[]{"2","1","+","3","*"}));   // 9
        System.out.println(e.calculateII("3+2*2"));                          // 7
        System.out.println(e.decodeString("3[a2[c]]"));                      // accaccacc
        System.out.println(e.simplifyPath("/a/./b/../../c/"));               // /c
    }
}

