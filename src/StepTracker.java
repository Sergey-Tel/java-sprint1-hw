public class StepTracker {
    int stepGoal = 10000;
    int[][] monthData = new int[12][30];

    public void saveData(int month, int day, int steps) {
        if (steps < 0) {
            System.out.println("Введено отрицательное значение. Пожалуйста введите положительное значение.");
        } else {
            monthData[month - 1][day - 1] = steps;
            System.out.println(steps + "- Шаги," + day + "- Дни," + month + "- Месяца.");
        }
    }

   public void countOfSteps(int month) {
        for (int i = 0; i < monthData[month - 1].length - 1; i++) {
            System.out.print((i + 1) + " день: " + monthData[month - 1][i] + ", ");
        }
        System.out.print(monthData[month - 1].length + " день: " + monthData[month - 1][monthData[month - 1].length - 1]);
    }

    public int stepsSum(int month) {
        int stepsSum = 0;
        for (int i = 0; i < monthData[month - 1].length; i++) {
            stepsSum = stepsSum + monthData[month - 1][i];
        }
        return stepsSum;
    }

   public int stepsMax(int month) {
        int stepsMax = 0;
        for (int i = 0; i < monthData[month - 1].length; i++) {
            if (monthData[month - 1][i] > stepsMax) {
                stepsMax = monthData[month - 1][i];
            }
        }
        return stepsMax;
    }

     public double stepsMiddle(int month) {
        double sumStepsDouble = stepsSum(month);
        double monthToDataLengthDouble = monthData[month - 1].length;
        return sumStepsDouble / monthToDataLengthDouble;
    }

    public int stepsSeries(int month) {
        int seriesSteps = 1;
        int maxSeriesStep = 0;
        for (int i = 1; i < monthData[month - 1].length; i++) {
            if ((monthData[month - 1][i] >= stepGoal) & (monthData[month - 1][i - 1] >= stepGoal)) {
                seriesSteps = seriesSteps + 1;
                if (seriesSteps > maxSeriesStep) {
                    maxSeriesStep = seriesSteps;
                }
            } else {
                seriesSteps = 1;
            }
        }
        return maxSeriesStep;
    }

    public void goalSteps(int goalStepsNew) {
        if (goalStepsNew < 0) {
            System.out.println("Введите положительное число.");
        } else {
            stepGoal = goalStepsNew;
            System.out.println("Новая цель по количеству шагов в день: " + stepGoal + " шагов");
        }
    }
}



