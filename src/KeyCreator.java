public class KeyCreator {

    private String polynomial;
    private String key;

    public KeyCreator(String pol) {
        this.polynomial = pol;
    }

    public void generateKey(int messageLength) {
        this.key = polynomial;
        while (key.length() < messageLength) {
            boolean lastBit = key.charAt(key.length() - 1) == '1' ? true : false;
            boolean secondToLast = key.charAt(key.length() - 2) == '1' ? true : false;
            key += lastBit ^ secondToLast == true ? String.valueOf('1') : String.valueOf('0');
        }
    }

    public String getKey() {
        return key;
    }
}
