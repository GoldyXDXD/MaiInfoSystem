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

        //вывод данных
        System.out.println("\n" + fullMessageCreator.getFullMessage());
        System.out.println(keyCreator.getKey());
        System.out.println(encryptedMessage);
    }
}