import java.util.Scanner;


public class Main {

    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyzабвгдежзийклмнопрстуфхцчшщъыьэюя_,.:!?".toCharArray();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ввод сообщения
        System.out.println("Введите сообщение:");
        String message = scanner.nextLine().toLowerCase();

        //перевод сообщения в двоичный вид
        FullMessageCreator fullMessageCreator = new FullMessageCreator(message);
        fullMessageCreator.createFullMessage(alphabet);

        //ввод полинома
        System.out.println("Введите полином:");
        String polynomial = scanner.nextLine();

        //создание ключа
        KeyCreator keyCreator = new KeyCreator(polynomial);
        keyCreator.generateKey(fullMessageCreator.getFullMessage().length());

        //шифрование
        fullMessageCreator.encryptFullMessage(keyCreator.getKey());
        String encryptedMessage = fullMessageCreator.getEncryptedMessage();

        //код хэмминга
        HammingCode hammingCode = new HammingCode(encryptedMessage);
        String radioMessage = hammingCode.encode();

        //вывод данных
        System.out.println("\n" + fullMessageCreator.getFullMessage());
        System.out.println(keyCreator.getKey());
        System.out.println(encryptedMessage);
        System.out.println(radioMessage);
        System.out.println(encryptedMessage.length());
        System.out.println(radioMessage.length());
    }
}