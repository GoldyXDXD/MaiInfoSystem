import java.util.Scanner;


public class Main {

    public static final char[] alphabet = "abcdefghijklmnopqrstuvwxyzабвгдежзийклмнопрстуфхцчшщъыьэюя_,.:!?".toCharArray();

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

        //внесение ошибок
        System.out.println("Введите количество ошибок: ");
        int errorCount = scanner.nextInt();
        MistakeMaker mistakeMaker = new MistakeMaker(radioMessage);
        String messageWithErrors = mistakeMaker.addMistakes(errorCount);

        //исправление ошибок
        String newMessage = mistakeMaker.deleteErrors(messageWithErrors);

        //удаление избыточных символов
        String finishBinaryMessage = hammingCode.decode(newMessage);

        //дешифрование
        String decodedMessage = fullMessageCreator.encryptFullMessage(finishBinaryMessage, keyCreator.getKey());

        //перевод в нормальный вид
        String resultString = "";
        if (mistakeMaker.isMessageCorrect(fullMessageCreator.getFullMessage(), fullMessageCreator.encryptFullMessage(finishBinaryMessage, keyCreator.getKey()))) {
            System.out.println(fullMessageCreator.binaryToString(decodedMessage));
        }

        //вывод данных
        System.out.println("\n" + "Фамилия в двоичном виде:\n" + fullMessageCreator.getFullMessage() + "\n");
        System.out.println("Псевдослучайная последовательность:\n" + keyCreator.getKey() + "\n");
        System.out.println("Зашифрованное сообщение:\n" + encryptedMessage + "\n");
        System.out.println("Сообщение кода Хэмминга:\n" + radioMessage + "\n");
        System.out.println("Сообщение с внесенными ошибками:\n" + messageWithErrors + "\n");
        System.out.println("Сообщение после исправления ошибок:\n" + newMessage + "\n");
        System.out.println("Сообщение в бинарном виде после удаления избыточных символов:\n" + finishBinaryMessage + "\n");
        System.out.println("Итоговое сообщение:\n" + fullMessageCreator.encryptFullMessage(finishBinaryMessage, keyCreator.getKey()) + "\n");
//        System.out.println("Итоговое сообщение:\n" + resultString + "\n");

    }
}