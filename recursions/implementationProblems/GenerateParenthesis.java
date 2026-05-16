package recursions.implementationProblems;

import java.util.ArrayList;
import java.util.List;


public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        parenthesisbacktrack(n, 0, 0, "", ans);
        return ans;
    }

    private void parenthesisbacktrack(int n, int open, int close, String current, List<String> ans) {

        // Base Case
        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        // TAKE OPEN BRACKET
        if (open < n) {
            parenthesisbacktrack(n, open + 1, close, current + "(", ans);
        }

        // TAKE CLOSE BRACKET
        if (close < open) {
            parenthesisbacktrack(n, open, close + 1, current + ")", ans);
        }
    }
}
