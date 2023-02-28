public class MistakeMaker {
    private String sentMessage;
    private String sentWrongMessage;

    public MistakeMaker(String sentMessage) {
        this.sentMessage = sentMessage;
    }

//    public String addMistakes() {
//
//    }

    public void isMessageCorrect(String message1, String message2) {
        if (message1.equals(message2)) {
            System.out.println("Message is right");
        } else {
            System.out.println("Message is wrong");
        }
    }

}
