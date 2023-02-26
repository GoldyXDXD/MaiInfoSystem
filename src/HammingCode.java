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
        for (int i = 0; i < this.startCode.length() / 8; i++) {
            String messagePart = this.startCode.substring(i * 8, i * 8 + 8);
            boolean[] infoBits = new boolean[8];
            for (int j = 0; j < 8; j++) {
                infoBits[j] = messagePart.charAt(j) == '1' ? true : false;
            }
            String[] checkBits = new String[4];
            checkBits[0] = infoBits[0] ^ infoBits[1] ^ infoBits[3] ^ infoBits[4] ^ infoBits[6] ? "1" : "0";
            checkBits[1] = infoBits[0] ^ infoBits[2] ^ infoBits[3] ^ infoBits[5] ^ infoBits[6] ? "1" : "0";
            checkBits[2] = infoBits[1] ^ infoBits[2] ^ infoBits[3] ^ infoBits[7] ? "1" : "0";
            checkBits[3] = infoBits[4] ^ infoBits[5] ^ infoBits[6] ^ infoBits[7] ? "1" : "0";
            result += checkBits[0] + checkBits[1] + messagePart.charAt(0) + checkBits[2] + messagePart.charAt(1) + messagePart.charAt(2) + messagePart.charAt(3) + checkBits[3] + messagePart.charAt(4) + messagePart.charAt(5) + messagePart.charAt(6) + messagePart.charAt(7);
        }
        return result;
    }


}
