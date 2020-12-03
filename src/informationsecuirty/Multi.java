package informationsecuirty;

public class Multi {

    char[] character;

    public Multi() {
        character = new char[26];
        int ii = 97;
        for (int i = 0; i < 26; i++) {

            character[i] = (char) ii;
            ii++;
        }
    }

    public int getOrder(char x) {
        for (int i = 0; i < 26; i++) {
            if ((int) x == (int) character[i]) {
                return i;
            }
        }
        return 0;
    }

    public char getChar(int x) {
        for (int i = 0; i < 26; i++) {
            if ((int) x == i) {
                return character[i];
            }
        }
        return 0;

    }

    public String multiplicativeEnc(String orginalText, int key) {
        String cipherText = "";
        String t = orginalText.toLowerCase();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int m = getOrder(c);
            int resAsNum = (m * key) % 26;
            char currentEncryption = getChar(resAsNum);

            cipherText += currentEncryption;
        }

        return cipherText;
    }

    public int EA(int r1, int r2) {
        int t1 = 0, t2 = 1;
        int r, q, t;
        while (r2 > 0) {
            q = r1 / r2;
            r = r1 - (q * r2);
            t = t1 - (q * t2);
            r1 = r2;
            r2 = r;
            t1 = t2;
            t2 = t;
            if (r1 == 1) {
                r2 = t1;
            }

        }
        return Math.abs(r2);
    }

    public String multiplicativeDec(String cipherText, int key) {
        String orginalText = "";
        int invKey = 26 - EA(26, key);
        System.out.println(invKey);
        String t = cipherText.toLowerCase();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int m = getOrder(c);
            int resAsNum = (m * invKey) % 26;
            char currentDec = getChar(resAsNum);

            orginalText += currentDec;

        }
        return orginalText;
    }

    public static void main(String[] args) {
        Multi ob = new Multi();

        String s = ob.multiplicativeDec("AVKAJ", 5);
        System.out.println(s);

    }

}
