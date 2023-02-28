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

        //ввод номера по списку
        System.out.println("Введите номер:");
        String nameNumber = scanner.nextLine();

        //ввод полинома
        System.out.println("Введите полином:");
        String polynomial = scanner.nextLine();

        //создание ключа
        KeyCreator keyCreator = new KeyCreator(nameNumber, polynomial);
        keyCreator.generateKey(fullMessageCreator.getFullMessage().length());

        //шифрование
        fullMessageCreator.encryptFullMessage(keyCreator.getKey());
        String encryptedMessage = fullMessageCreator.getEncryptedMessage();

        //код хэмминга
        HammingCode hammingCode = new HammingCode(encryptedMessage);
        String radioMessage = hammingCode.encode();

        //вывод данных
        System.out.println("\n" + "Фамилия в двоичном виде:\n" + fullMessageCreator.getFullMessage() + "\n");
        System.out.println("Псевдослучайная последовательность:\n" + keyCreator.getKey() + "\n");
        System.out.println("Зашифрованное сообщение:\n" + encryptedMessage + "\n");
        System.out.println("Сообщение кода Хэмминга:\n" + radioMessage + "\n");
    }
}