public class HammingCode {
    private String startCode;

    public HammingCode(String startCode) {
        this.startCode = startCode;
        while (this.startCode.length() % 8 != 0) {
            startCode += "0";
        }
    }

    public String encode() {
        String result = "";
        for (int i = 0; i < this.startCode.length() / 4; i++) {
            String messagePart = this.startCode.substring(i * 4, i * 4 + 4);
            boolean[] infoBits = new boolean[4];
            for (int j = 0; j < 4; j++) {
                infoBits[j] = messagePart.charAt(j) == '1' ? true : false;
            }
            String[] checkBits = new String[3];
            checkBits[0] = infoBits[1] ^ infoBits[3] ^ infoBits[2] ? "1" : "0";
            checkBits[1] = infoBits[0] ^ infoBits[2] ^ infoBits[3] ? "1" : "0";
            checkBits[2] = infoBits[0] ^ infoBits[1] ^ infoBits[3] ? "1" : "0";
            result += checkBits[2] + checkBits[1] + messagePart.charAt(0) + checkBits[0] + messagePart.charAt(1) + messagePart.charAt(2) + messagePart.charAt(3);
        }
        return result;
    }


}
