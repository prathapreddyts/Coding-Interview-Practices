package stacksandqueues.stacks.basics;

import java.util.Stack;

/**
 * VALID PARENTHESES — LeetCode #20 | FAANG Frequency: ⭐⭐⭐⭐⭐
 *
 * Given a string s containing just '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * Rules:
 *  - Open brackets must be closed by the same type.
 *  - Open brackets must be closed in the correct order.
 *  - Every close bracket has a corresponding open bracket.
 *
 * Example 1: s = "()"       → true
 * Example 2: s = "()[]{}"   → true
 * Example 3: s = "(]"       → false
 * Example 4: s = "([)]"     → false
 * Example 5: s = "{[]}"     → true
 *
 * Constraints: 1 <= s.length <= 10^4
 *
 * Pattern: Stack — push open, pop on close and match
 * Time: O(n) | Space: O(n)
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // TODO: implement
        return false;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 1: Minimum number of bracket reversals to make valid
    // LeetCode #921 - Minimum Add to Make Parentheses Valid
    // -----------------------------------------------------------------------

    /**
     * Return the minimum number of '(' or ')' you must add to make valid.
     * Example: s = "())"  → 1
     * Example: s = "((("  → 3
     */
    public int minAddToMakeValid(String s) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: LeetCode #1249 - Minimum Remove to Make String Valid
    // -----------------------------------------------------------------------

    /**
     * Remove the minimum number of parentheses so that the resulting string is valid.
     * Example: s = "lee(t(c)o)de)"  → "lee(t(c)o)de"
     * Example: s = "a)b(c)d"        → "ab(c)d"
     */
    public String minRemoveToMakeValid(String s) {
        // TODO: implement
        return "";
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 3: LeetCode #32 - Longest Valid Parentheses (Hard)
    // -----------------------------------------------------------------------

    /**
     * Find the length of the longest valid (well-formed) parentheses substring.
     * Example: s = "(()"    → 2
     * Example: s = ")()())" → 4
     *
     * Time: O(n) | Space: O(n)
     */
    public int longestValidParentheses(String s) {
        // TODO: implement
        return 0;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 4: LeetCode #678 - Valid Parenthesis String (with '*')
    // -----------------------------------------------------------------------

    /**
     * '*' can be '(' or ')' or empty. Check if string is valid.
     * Example: s = "()"   → true
     * Example: s = "(*)"  → true
     * Example: s = "(*))" → true
     *
     * Greedy Approach: track lo and hi possible open counts
     */
    public boolean checkValidString(String s) {
        // TODO: implement
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()[]{}"));           // true
        System.out.println(vp.isValid("([)]"));             // false
        System.out.println(vp.minAddToMakeValid("())"));    // 1
        System.out.println(vp.longestValidParentheses(")()())")); // 4
        System.out.println(vp.checkValidString("(*))"));    // true
    }
}

