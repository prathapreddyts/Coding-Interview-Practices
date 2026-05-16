package recursions.recursionlist.level2;

public class Replace3_14WithPi {
    public String replacePi(String usrInput) {
        return replacePiHelper(0, usrInput);
    }

    private static String replacePiHelper(int index, String usrInput) {

        if (index >= usrInput.length()) {
            return "";
        }
        if (index + 1 < usrInput.length() && usrInput.charAt(index) == 'p' && usrInput.charAt(index + 1) == 'i') {
            return "3.14" + replacePiHelper(index + 2, usrInput);
        }
        return usrInput.charAt(index) + replacePiHelper(index + 1, usrInput);
    }
}
