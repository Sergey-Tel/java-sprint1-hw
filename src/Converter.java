public class Converter {
    double STEP_SIZE = 0.00075;
    int CALORIES_PER_STEP = 50; //калорий на шаг
    int CALORIES_TO_K_CALORIES = 1000; //1 кКалория - 1000 калорий
    public double stepsInKL(double steps) {
        return steps * STEP_SIZE ;
    }

   public double allCalories(double steps) {
        return steps * CALORIES_PER_STEP / CALORIES_TO_K_CALORIES;
    }

}


