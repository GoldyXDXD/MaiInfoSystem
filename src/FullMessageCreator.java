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
                fullMessage += "00000" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 4) {
                fullMessage += "0000" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 8) {
                fullMessage += "000" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 16) {
                fullMessage += "00" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 32) {
                fullMessage += "0" + Integer.toBinaryString(symbolIndex);
            } else if (symbolIndex < 64) {
                fullMessage += Integer.toBinaryString(symbolIndex);
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

}
