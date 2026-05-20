package stacksandqueues.stacks.basics;

/**
 * BACKSPACE STRING COMPARE — LeetCode #844 | FAANG Frequency: ⭐⭐⭐⭐
 *
 * Given two strings s and t, return true if they are equal
 * when both are typed into empty text editors. '#' means a backspace.
 *
 * Example 1: s = "ab#c",  t = "ad#c"  → true  (both become "ac")
 * Example 2: s = "ab##",  t = "c#d#"  → true  (both become "")
 * Example 3: s = "a#c",   t = "b"     → false
 *
 * Approach 1: Stack — O(n) time, O(n) space
 * Approach 2: Two pointer from end — O(n) time, O(1) space  ← preferred at FAANG
 *
 * Constraints: 1 <= s.length, t.length <= 200
 */
public class BackspaceStringCompare {

    /** Stack approach: O(n) time, O(n) space */
    public boolean backspaceCompareStack(String s, String t) {
        // TODO: implement using stack/StringBuilder
        return false;
    }

    /** Two-pointer approach: O(n) time, O(1) space — optimal */
    public boolean backspaceCompare(String s, String t) {
        // TODO: implement with two pointers from the end
        // Skip characters based on backspace count
        return false;
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP: Remove All Adjacent Duplicates — LeetCode #1047
    // -----------------------------------------------------------------------

    /**
     * Remove all adjacent duplicate pairs repeatedly until no more can be removed.
     * Example: s = "abbaca" → "ca"
     * Example: s = "azxxzy" → "ay"
     *
     * Pattern: Stack — if top == current char, pop; else push
     * Time: O(n) | Space: O(n)
     */
    public String removeDuplicates(String s) {
        // TODO: implement
        return "";
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 2: Remove All Adjacent Duplicates in String II — LeetCode #1209
    // Remove k adjacent duplicates
    // -----------------------------------------------------------------------

    /**
     * Remove k adjacent same characters repeatedly.
     * Example: s = "deeedbbcccbdaa", k = 3 → "aa"
     *          Remove "eee" → "ddbbbcccbdaa" → remove "bbb" → ... → "aa"
     *
     * Pattern: Stack of (char, count) pairs
     * Time: O(n) | Space: O(n)
     */
    public String removeDuplicatesK(String s, int k) {
        // TODO: implement with stack of [char, count]
        return "";
    }

    // -----------------------------------------------------------------------
    // FOLLOW-UP 3: Make String Great — LeetCode #1544
    // Remove adjacent pairs where one is lowercase and other is uppercase of same letter
    // -----------------------------------------------------------------------

    /**
     * A string is "good" if there are no two adjacent characters s[i] and s[i+1]
     * where they are the same letter but different case.
     * Example: s = "leEeetcode" → "leetcode"
     * Example: s = "abBAcC"     → ""
     *
     * Pattern: Stack — pop if top is same letter different case
     */
    public String makeGood(String s) {
        // TODO: implement
        return "";
    }

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();
        System.out.println(b.backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(b.removeDuplicates("abbaca"));        // ca
        System.out.println(b.removeDuplicatesK("deeedbbcccbdaa", 3)); // aa
        System.out.println(b.makeGood("abBAcC"));                // ""
    }
}

