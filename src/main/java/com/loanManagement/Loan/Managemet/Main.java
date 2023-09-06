package com.loanManagement.Loan.Managemet;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, ParseException {
        // Create Loan objects with provided data
        Loan loan1 = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
        Loan loan2 = new Loan("L2", "C1", "LEN1", 20000, 5000, "01/06/2023", 1, "05/08/2023", 0.01);
        Loan loan3 = new Loan("L3", "C2", "LEN2", 50000, 30000, "04/04/2023", 2, "04/05/2023", 0.02);
        Loan loan4 = new Loan("L4", "C3", "LEN2", 50000, 30000, "04/04/2023", 2, "04/05/2023", 0.02);

        // Now you have Loan objects ready with the provided data
        System.out.println("Loan 1 ID: " + loan1.getLoanId());
        System.out.println("Loan 2 Lender ID: " + loan2.getLenderId());
        System.out.println("Loan 3 Remaining Amount: " + loan3.getRemainingAmount());
        System.out.println("Loan 4 Due Date: " + loan4.getDueDate());
    }
}

