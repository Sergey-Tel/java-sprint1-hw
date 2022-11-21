import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Введите номер месяца от 1 до 12.");
                int month = scanner.nextInt();
                if (month < 1 | month > 12) {
                    System.out.println("Неверно введенный месяц.");
                } else {
                    System.out.println("Введите номер дня от 1 до 30.");
                    int day = scanner.nextInt();
                    if (day < 1 | day > 30) {
                        System.out.println("Неверно введеный день");
                    } else {
                        System.out.println("Введите количество пройденных шагов.");
                        int steps = scanner.nextInt();
                        stepTracker.saveData(month, day, steps);
                    }
                }
            } else if (command == 2) {
                System.out.println("Введите номер месяца от 1 до 12.");
                int month = scanner.nextInt();
                if (month < 1 | month > 12) {
                    System.out.println("Неверно введенный месяц.");
                } else {
                    System.out.printf("Количество пройденных шагов за %d-й месяц: ", month);
                    stepTracker.countOfSteps(month);

                    System.out.printf("Общее количество шагов за %d-й месяц: %d шагов \n",
                            month, stepTracker.stepsSum(month));

                    System.out.printf("Максимальное пройденное количество шагов за %d-й месяц: %d шагов \n",
                            month, stepTracker.stepsMax(month));

                    System.out.printf("Среднее количество шагов за %d-й месяц: %.2f шагов \n",
                            month, stepTracker.stepsMiddle(month));

                    System.out.printf("Пройденная дистанция за %d-й месяц: %.2f км \n",
                            month, converter.stepsInKL(stepTracker.stepsSum(month)));

                    System.out.printf("Количество сожжённых килокалорий за %d-й месяц: %.2f киллокалорий \n",
                            month, converter.allCalories(stepTracker.stepsSum(month)));

                    System.out.printf("Лучшая серия: максимальное количество подряд идущих дней, " +
                            "в течение которых количество шагов за день было равно или выше целевого: %d подряд \n",
                            stepTracker.stepsSeries(month));
                }
            } else if (command == 3) {
                System.out.println("Введите требуемое количество шагов");

                int targetStepsCount = scanner.nextInt();

                stepTracker.goalSteps(targetStepsCount);

            } else if (command == 0) {
                break;
            } else {

                System.out.println("Извините, такой команды нет.");

            }
        }
    }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}



