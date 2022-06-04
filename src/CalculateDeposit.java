import java.util.Scanner;

public class CalculateDeposit {
    public static void main(String[] args) {
        new Main().calculateAmountByEndOfPeriod();
    }

    double calculateComplexPercent(double amount, double yearInterestRate, int depositPeriod) {
        double interestPay = amount * Math.pow((1 + yearInterestRate / 12), 12 * depositPeriod);
        return roundValue(interestPay, 2);
    }

    double calculateSimplePercent(double amount, double yearInterestRate, int depositPeriod) {
        double interestPay = amount + amount * yearInterestRate * depositPeriod;
        return roundValue(interestPay, 2);
    }

    double roundValue(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateAmountByEndOfPeriod() {
        int depositPeriod;
        int action;
        int amount;
        double amountByEndOfPeriod = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) amountByEndOfPeriod = calculateSimplePercent(amount, 0.06, depositPeriod);
        if (action == 2) amountByEndOfPeriod = calculateComplexPercent(amount, 0.06, depositPeriod);
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + amountByEndOfPeriod);
    }
}