import java.util.Locale;

public class CalculatorLogic {
    public void dataAnalyze(String type, String principal, String periods, String interest, String payment) {
        if (type == null || (!type.equals("annuity") && !type.equals("diff"))) {
            System.out.println("Incorrect parameters");
            return;
        }

        boolean isAnnuity = type.equals("annuity");

        double principalAmount = validateAndParse(principal);
        int numberOfPayments = validateAndParseInt(periods);
        double interestRate = validateAndParse(interest);
        double monthlyPayment = validateAndParse(payment);

        if (principalAmount < 0 || numberOfPayments < 0 || interestRate < 0 || monthlyPayment < 0) {
            System.out.println("Incorrect parameters");
            return;
        }

        if (isAnnuity) {
            if (monthlyPayment == 0) {
                calculateAnnuityPayment(principalAmount, numberOfPayments, interestRate);
            } else if (numberOfPayments == 0) {
                calculateNumberOfPayments(principalAmount, interestRate, monthlyPayment);
            } else if (principalAmount == 0) {
                calculateLoanPrincipal(monthlyPayment, numberOfPayments, interestRate);
            } else {
                System.out.println("Incorrect parameters");
            }
        } else {
            if (monthlyPayment != 0) {
                System.out.println("Incorrect parameters");
            } else if (numberOfPayments != 0) {
                calculateDiffPayments(principalAmount, numberOfPayments, interestRate);
            } else {
                System.out.println("Incorrect parameters");
            }
        }
    }

    private double validateAndParse(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int validateAndParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void calculateAnnuityPayment(double principal, int periods, double interestRate) {
        double i = interestRate / 100 / 12;
        double annuityPayment = principal * (i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1);
        System.out.printf(Locale.US, "Your annuity payment = %.0f!\n", annuityPayment);
    }

    private void calculateNumberOfPayments(double principal, double interestRate, double monthlyPayment) {
        double i = interestRate / 100 / 12;
        int numberOfPayments = (int) Math.ceil(Math.log(monthlyPayment / (monthlyPayment - i * principal)) / Math.log(1 + i));
        int years = numberOfPayments / 12;
        int months = numberOfPayments % 12;
        System.out.printf("It will take %d years", years);
        if (months > 0) {
            System.out.printf(" and %d months", months);
        }
        System.out.println(" to repay this loan!");
    }

    private void calculateLoanPrincipal(double monthlyPayment, int periods, double interestRate) {
        double i = interestRate / 100 / 12;
        double loanPrincipal = monthlyPayment / ((i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1));
        System.out.printf(Locale.US, "Your loan principal = %.0f!\n", loanPrincipal);
    }

    private void calculateDiffPayments(double principal, int periods, double interestRate) {
        double i = interestRate / 100 / 12;
        double totalPayment = 0;
        for (int month = 1; month <= periods; month++) {
            double diffPayment = principal / periods + i * (principal - (principal * (month - 1)) / periods);
            totalPayment += diffPayment;
            System.out.printf(Locale.US, "Month %d: payment is %.0f\n", month, Math.ceil(diffPayment));
        }
        double overpayment = totalPayment - principal;
        System.out.printf(Locale.US, "Overpayment = %.0f\n", overpayment);
    }
}
