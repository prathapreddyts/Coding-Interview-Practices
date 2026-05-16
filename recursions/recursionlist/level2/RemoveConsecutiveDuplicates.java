package recursions.recursionlist.level2;

public class RemoveConsecutiveDuplicates {
    public String removeDuplicates(String usrString) {

        if (usrString == null) {
            return usrString;
        }

        return removeDuplicatesHelper(new StringBuilder(), usrString, 0);
    }

    private String removeDuplicatesHelper(StringBuilder result, String usrString, int index) {

        // Base case: return fully reduced string after processing all chars
        if (index == usrString.length()) {
            return result.toString();
        }

        char currentChar = usrString.charAt(index);
        // If top of "stack" matches current char, remove pair
        if (!result.isEmpty() && result.charAt(result.length() - 1) == currentChar) {
            result.deleteCharAt(result.length() - 1);
        } else {
            result.append(currentChar);
        }
        return removeDuplicatesHelper(result, usrString, index + 1);
    }
}
