import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("Type \"n\" for the number of monthly payments,");
        System.out.println("Type \"a\" for the annuity monthly payment amount,");
        System.out.println("Type \"p\" for the loan principal:");

        String option = scanner.nextLine().toLowerCase();

        switch (option) {
            case "n":
                System.out.println("Enter the loan principal:");
                double principalN = scanner.nextDouble();
                System.out.println("Enter the monthly payment:");
                double paymentN = scanner.nextDouble();
                System.out.println("Enter the loan interest:");
                double interestRateN = scanner.nextDouble() / 100;

                int[] resultN = calculateNumberOfPayments(principalN, paymentN, interestRateN);
                System.out.printf("It will take %d years and %d months to repay this loan!\n", resultN[0], resultN[1]);
                break;

            case "a":
                System.out.println("Enter the loan principal:");
                double principalA = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                int periodsA = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                double interestRateA = scanner.nextDouble() / 100;

                double annuityPayment = calculateAnnuityPayment(principalA, periodsA, interestRateA);
                System.out.printf("Your monthly payment = %.2f!\n", annuityPayment);
                break;

            case "p":
                System.out.println("Enter the annuity payment:");
                double paymentP = scanner.nextDouble();
                System.out.println("Enter the number of periods:");
                int periodsP = scanner.nextInt();
                System.out.println("Enter the loan interest:");
                double interestRateP = scanner.nextDouble() / 100;

                double loanPrincipal = calculateLoanPrincipal(paymentP, periodsP, interestRateP);
                System.out.printf("Your loan principal = %.2f!\n", loanPrincipal);
                break;

            default:
                System.out.println("Invalid option. Please choose \"n\", \"a\", or \"p\".");
        }
    }

    private static int[] calculateNumberOfPayments(double principal, double payment, double interestRate) {
        double i = interestRate / 12;
        int n = (int) Math.ceil(Math.log(payment / (payment - i * principal)) / Math.log(1 + i));
        int years = n / 12;
        int months = n % 12;
        return new int[]{years, months};
    }

    private static double calculateAnnuityPayment(double principal, int periods, double interestRate) {
        double i = interestRate / 12;
        return principal * (i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1);
    }

    private static double calculateLoanPrincipal(double payment, int periods, double interestRate) {
        double i = interestRate / 12;
        return payment / ((i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1));
    }
}
