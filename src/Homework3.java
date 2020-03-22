/* Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше. После
победы или проигрыша выводится запрос - "Повторить игру еще раз? 1-да/0-нет" (1 - повторить, 0 - нет).
 */


import java.util.Scanner;

public class Homework3 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("I want to play a game! Вам необходимо угадать число.");
        int maxTryCount = 3;
        int tryCount = 1;
        int playerAnswer = 1;
        while (playerAnswer == 1) {                                     //Цикл, позволяющий при определенном ответе сыграть еще одну игру
            System.out.print("Угадайте число от 0 до 9. ");
            System.out.println("У Вас " + maxTryCount + " попытки.");
            int number = (int) (Math.random() * 9);                     //Система загадывает рандомное число в диапазоне от 0 до 9
            while (tryCount <= maxTryCount){
                int triesLeft = maxTryCount - tryCount;
                System.out.println("Введите число с клавиатуры.");
                int input_number = scanner.nextInt();                   //Пользователь вводит свой ответ
                if (input_number == number) {                           //Различные варианты развития событий: пользователь угадал, выход из цикла, предложение повторной игры
                    System.out.println("Поздравляю! Вы угадали!");
                    break;
                } else if (input_number < number){                      //Выбранное пользователем число меньше правильного ответа
                    System.out.println("Загаданное число больше введенного.");
                    System.out.println("Оставшееся количество попыток: " + triesLeft + ".");
                } else {                                                //Выбранное пользователем число больше правильного ответа
                    System.out.println("Загаданное число меньше введенного.");
                    System.out.println("Оставшееся количество попыток: " + triesLeft + ".");
                }
                tryCount++;
                if (tryCount > maxTryCount){
                    System.out.println("К сожалению, Вы проиграли. Загаданным числом было: " + number + ".");
                }
            }
            tryCount = 1;                                                //Выходим из внутреннего цикла и обнуляем счетчик попыток
            System.out.println("Повторить игру еще раз? 1-да/0-нет");
            playerAnswer = scanner.nextInt();                            //Выбор пользователя и возврат к внешнему циклу
        }
        scanner.close();
    }

}
