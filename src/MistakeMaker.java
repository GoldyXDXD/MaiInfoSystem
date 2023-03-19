import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MistakeMaker {
    private String sentMessage;
    private String sentWrongMessage = "";

    public MistakeMaker(String sentMessage) {
        this.sentMessage = sentMessage;
    }

    public String addMistakes(int errorCount) {
        List<String> errorList = new ArrayList<>();
        for (int i = 0; i < sentMessage.length(); i++) {
            if (i < sentMessage.length() - errorCount) {
                errorList.add("0");
            } else {
                errorList.add("1");
            }
        }
        Collections.shuffle(errorList);
        String errorString = String.join("", errorList);
        for (int i = 0; i < this.sentMessage.length(); i++) {
            int messageBit = Integer.valueOf(sentMessage.charAt(i));
            int errorBit = Integer.valueOf(errorString.charAt(i));
            String enMessage = (messageBit ^ errorBit) == 1 ? "1" : "0";
            sentWrongMessage += enMessage;
        }
        return sentWrongMessage;
    }

    public String deleteErrors(String errorMessage) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < errorMessage.length() / 7; i++) {
            String errorMessagePart = errorMessage.substring(i * 7, i * 7 + 7);
            int[] infoBits = new int[7];
            for (int j = 0; j < 7; j++) {
                infoBits[j] = errorMessagePart.charAt(j) == '1' ? 1 : 0;
            }
            int s1 = infoBits[0] ^ infoBits[2] ^ infoBits[4] ^ infoBits[5]; // p_1 + i_1 + i_2 + i_3
            int s2 = infoBits[1] ^ infoBits[4] ^ infoBits[5] ^ infoBits[6]; //p_2 + i_2 + i_3 + i_4
            int s3 = infoBits[3] ^ infoBits[2] ^ infoBits[4] ^ infoBits[6]; //p_3 + i_1 + i_2 + i_4
            String errorStr = "0000000";
            if (s1 == 1 && s2 == 0 && s3 == 1) {
                errorStr = "1000000";
            } else if (s1 == 1 && s2 == 1 && s3 == 1) {
                errorStr = "0100000";
            } else if (s1 == 1 && s2 == 1 && s3  == 0) {
                errorStr = "0010000";
            } else if (s1 == 0 && s2 == 1 && s3 == 1) {
                errorStr = "0001000";
            } else if (s1 == 1 && s2 == 0 && s3 == 0) {
                errorStr = "0000100";
            } else if (s1 == 0 && s2 == 1 && s3 == 0) {
                errorStr = "0000010";
            } else if (s1 == 0 && s2 == 0 && s3 == 1) {
                errorStr = "0000001";
            }
            for (int j = 0; j < errorMessagePart.length(); j++) {
                int messageBit = (int) errorMessagePart.charAt(j);
                int errorBit = (int) errorStr.charAt(j);
                String enMessage = (messageBit ^ errorBit) == 1 ? "1" : "0";
                result.append(enMessage);
            }
        }
        return result.toString();
    }
    public boolean isMessageCorrect(String message1, String message2) {
        if (message1.equals(message2)) {
            System.out.println("Сообщение восстановлено правильно");
        } else {
            System.out.println("Сообщение восстановлено неправильно");
        }
        return message1.equals(message2);
    }
}
