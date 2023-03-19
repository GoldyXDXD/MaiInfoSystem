public class FullMessageCreator {

    private String message;
    private char[] messageArray;
    private String fullMessage = "";
    private String encryptedMessage = "";

    public FullMessageCreator(String message) {
        this.message = message;
    }

    public String getFullMessage() {
        return fullMessage;
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public void createFullMessage(char[] alphabet) {
        this.messageArray = message.toCharArray();
        for (int i = 0; i < messageArray.length; i++) {
            int symbolIndex = new String(alphabet).indexOf(messageArray[i]);
            if (symbolIndex < 2) {
                fullMessage += "0000000" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 4) {
                fullMessage += "000000" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 8) {
                fullMessage += "00000" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 16) {
                fullMessage += "0000" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 32) {
                fullMessage += "000" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 64) {
                fullMessage += "00" + Integer.toBinaryString(symbolIndex);
            }
        }
    }

    public String encryptFullMessage(String key) {
        for (int i = 0; i < this.fullMessage.length(); i++) {
            int messageBit = Integer.valueOf(fullMessage.charAt(i));
            int keyBit = Integer.valueOf(key.charAt(i));
            String enMessage = (messageBit ^ keyBit) == 1 ? "1" : "0";
            encryptedMessage += enMessage;
        }
        return encryptedMessage;
    }

    public String encryptFullMessage(String m, String key) {
        String result = "";
        for (int i = 0; i < m.length(); i++) {
            int messageBit = Integer.valueOf(m.charAt(i));
            int keyBit = Integer.valueOf(key.charAt(i));
            String enMessage = (messageBit ^ keyBit) == 1 ? "1" : "0";
            result += enMessage;
        }
        return result;
    }

    public String decryptFullMessage(String m, String mKey) {
        System.out.println(m.length());
        System.out.println(mKey.length());
        String result = "";
        for (int i = 0; i < m.length(); i++) {
            int messageBit = Integer.valueOf(m.charAt(i));
            int keyBit = Integer.valueOf(mKey.charAt(i));
            String enMessage = (messageBit ^ keyBit) == 1 ? "1" : "0";
            result += enMessage;
        }
        return m;
    }

    public String binaryToString(String binaryMessage) {
        String result = "";
        for (int i = 0; i < binaryMessage.length() / 8; i++) {
            String binarySymbol = binaryMessage.substring(i * 8, i * 8 + 8);
            int symbolNumber = Integer.parseInt(binarySymbol, 2);
            String symbol = String.valueOf(Main.alphabet[symbolNumber]);
            result += symbol;
        }
        return result;
    }

}
