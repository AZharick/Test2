package MisthyxLabs;

import java.util.Scanner;

public class Main {
   static int year, days, actualDays, score;
   static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
      initGame();
      askOfYearsList();
   }

   public static void initGame() {
      System.out.println("\n\nДобро пожаловать в игру \"Угадай кол-во дней!\"\n");
      score = 0;

      while (true) {
         scanner = new Scanner(System.in);
         System.out.println("Введите год в формате yyyy:");
         year = scanner.nextInt();
         System.out.println("Как Вы думаете, сколько дней в этом году?");
         days = scanner.nextInt();
         actualDays = determineActualDays(year);

         if (days == actualDays) {
            System.out.println("Верно! Вы заработали 1 очко!");
            score++;
            System.out.println("Ваш счёт: " + score);
         } else {
            break;
         }
      }
      gameOver(days, actualDays, score);
   }

   public static void gameOver(int days, int actualDays, int score){
      System.out.println("Неправильно! В этом году " + actualDays + " дней!");
      System.out.println("\nИгра окончена! Набрано очков: " + score);

//      if (days == 365) {
//         System.out.println("Неправильно! В этом году " + actualDays + " дней!");
//      } else {
//         System.out.println("Неправильно! В этом году " + actualDays + " дней!");
//         System.out.println("\nИгра окончена!");
//         System.out.println("Набрано очков: " + score);
//      }
   }

   public static void askOfYearsList() {
      scanner.nextLine(); //LineBreak caught
      boolean flagToExit = false;
      while (true) {
         System.out.println("Хотите вывести список високосных лет? (Y/N)");
         String answer = scanner.nextLine().toLowerCase();

         switch (answer) {
            case "y":
               displayAllLeapYears();
               flagToExit = true;
               break;
            case "n":
               System.out.println("Выход из игры...");
               flagToExit = true;
               break;
            default:
               System.out.println("Нужно ответить \"Y\" или \"N\"!");
               break;
         }
         if(flagToExit){
            break;
         }
      }
   }

   public static boolean isLeap(int year) {
      if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
         return true;
      } else {
         return false;
      }
   }

   public static int determineActualDays(int year) {
      if (isLeap(year)) {
         return 366;
      } else {
         return 365;
      }
   }

   public static void displayAllLeapYears() {
      System.out.println("\nФормируем список високосных лет...");
      System.out.println("Начальный год в списке?");
      int init = scanner.nextInt();
      System.out.println("Конечный год в списке?");
      int end = scanner.nextInt();

      if(init>end) {
         int temp = end;
         end = init;
         init = temp;
      }

      System.out.printf("ВИСОКОСНЫЕ ГОДА ОТ %d ДО %d:\n", init, end);
      for (int i = init; i<=end; i++) {
         if (isLeap(i)) {
            System.out.print(i + " ");
            i++;
         } else {
            i++;
         }
      }
   }

}