package Bridgelabz.Generics;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        return new Meal<>(mealPlan);
    }

    public static <T extends MealPlan> boolean validateMealPlan(T mealPlan) {
        return mealPlan != null;
    }
}

public class Meal {
    public static void main(String[] args) {
        VegetarianMeal vegetarianMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();
        KetoMeal ketoMeal = new KetoMeal();
        HighProteinMeal highProteinMeal = new HighProteinMeal();

        if (MealPlanGenerator.validateMealPlan(vegetarianMeal)) {
            Meal<VegetarianMeal> meal = MealPlanGenerator.generateMealPlan(vegetarianMeal);
            System.out.println("Generated: " + meal.getMealPlan().getMealType());
        }

        if (MealPlanGenerator.validateMealPlan(veganMeal)) {
            Meal<VeganMeal> meal = MealPlanGenerator.generateMealPlan(veganMeal);
            System.out.println("Generated: " + meal.getMealPlan().getMealType());
        }

        if (MealPlanGenerator.validateMealPlan(ketoMeal)) {
            Meal<KetoMeal> meal = MealPlanGenerator.generateMealPlan(ketoMeal);
            System.out.println("Generated: " + meal.getMealPlan().getMealType());
        }

        if (MealPlanGenerator.validateMealPlan(highProteinMeal)) {
            Meal<HighProteinMeal> meal = MealPlanGenerator.generateMealPlan(highProteinMeal);
            System.out.println("Generated: " + meal.getMealPlan().getMealType());
        }
    }
}