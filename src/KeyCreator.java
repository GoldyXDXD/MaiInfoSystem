public class KeyCreator {

    private String nameNumber;
    private String polynomial;

    private String key;

    public KeyCreator(String nameNumber, String polynomial) {
        this.nameNumber = nameNumber;
        this.polynomial = polynomial;
    }

    public void generateKey(int messageLength) {
        this.key = nameNumber;
        while (key.length() < messageLength) {
            boolean bits[] = new boolean[5];
            for (int i = 4; i >= 0; i--) {
                if (polynomial.charAt(4 - i) == '1') {
                    bits[i] = key.charAt(key.length() - 1 - i) == '1' ? true : false;
                } else {
                    bits[i] = false;
                }
            }
            key += (bits[0] ^ bits[1] ^ bits[2] ^ bits[3] ^ bits[4]) ? String.valueOf('1') : String.valueOf('0');
        }
    }

//    public void generateAnotherKey() {
//        this.key = this.nameNumber;
//        for (int j = 0; j < 4; j++) {
//            boolean bits[] = new boolean[5];
//            for (int i = 4; i >= 0; i--) {
//                if (polynomial.charAt(4 - i) == '1') {
//                    bits[i] = key.charAt(key.length() - 1 - i) == '1' ? true : false;
//                } else {
//                    bits[i] = false;
//                }
//                System.out.println("Значение полинома " + polynomial.charAt(4 - i));
//                System.out.println("Значение ключа " + key.charAt(4 - i));
//                System.out.println("Значение бита " + bits[i]);
//                System.out.println("-----------------------------------------------------------");
//            }
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            key += (bits[0] ^ bits[1] ^ bits[2] ^ bits[3] ^ bits[4]) ? String.valueOf('1') : String.valueOf('0');
//        }
//    }

    public String getKey() {
        return key;
    }
}
