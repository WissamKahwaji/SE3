package informationsecuirty;

public class AutokeyDec {

    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {

        System.out.println(autokeyDec("CSLWJ", "K"));
    }

    public static String autokeyDec(String cipherText, String key) {
        String plainText = "";
        String currentKey = key;
        for (int i = 0; i < cipherText.length(); i++) {

            int c = alpha.indexOf(cipherText.charAt(i));
            int k = alpha.indexOf(currentKey.charAt(i));
            int resAsNum = (c - k) % 26;
            resAsNum = (resAsNum < 0) ? resAsNum + 26 : resAsNum;
            char currentDec = alpha.charAt(resAsNum);
            plainText += currentDec;
            currentKey += alpha.charAt(resAsNum);

        }

        return plainText;
    }

}
