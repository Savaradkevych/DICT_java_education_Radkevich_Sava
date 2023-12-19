public class CreditCalculator {
    public static void main(String[] args) {
        int loanPrincipal = 1000;
        int[] monthlyRepayment = {250, 250, 500};

        System.out.println("Loan principal: " + loanPrincipal);

        for (int i = 0; i < monthlyRepayment.length; i++) {
            System.out.println("Month " + (i + 1) + ": repaid " + monthlyRepayment[i]);
            loanPrincipal -= monthlyRepayment[i];
        }

        System.out.println("The loan has been repaid!");
    }
}
