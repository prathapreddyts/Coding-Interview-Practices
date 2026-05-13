package recursions.basicproblems;

import java.util.ArrayList;

public class ReverseString {
    public ArrayList<Character> reverseString(ArrayList<Character> usrString) {
        reverseStringHelper(usrString, 0, usrString.size() - 1);
        return usrString;
    }

    public void reverseStringHelper(ArrayList<Character> usrString, int start, int end) {
        if (start >= end) {
            return;
        }
        Character tempChar = usrString.get(start);
        usrString.set(start, usrString.get(end));
        usrString.set(end, tempChar);
        reverseStringHelper(usrString, start+1, end - 1);
    }
}
