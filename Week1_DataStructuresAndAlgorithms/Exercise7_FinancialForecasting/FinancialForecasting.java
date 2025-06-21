// DSA: Exercise 7

package Week1_DataStructuresAndAlgorithms.Exercise7_FinancialForecasting;

public class FinancialForecasting {

    public static double forecastRecursive(double currentValue, double growthRate, int monthsLeft) {
        if (monthsLeft == 0)
            return currentValue;
        return forecastRecursive(currentValue, growthRate, monthsLeft - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;
        double monthlyGrowthRate = 0.05;
        int forecastMonths = 6;

        System.out.println("Forecasting using recursion:");
        double future = forecastRecursive(currentValue, monthlyGrowthRate, forecastMonths);
        System.out.printf("Future Value (Recursive) after %d months: %.2f\n", forecastMonths, future);
    }
}

// Understanding Recursion:
// Programming technique where a method calls itself.

// Naive Recursion: O(n) → calls itself n times
// Improvement: Memoization: O(n) → avoids recomputation by storing results