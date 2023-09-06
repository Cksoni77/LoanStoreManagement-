package com.loanManagement.Loan.Managemet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanStore {

private List<Loan> loans;

    public LoanStore() {
        loans = new ArrayList<>();
    }

    public void addLoan(Loan loan) throws LoanValidationException {
        if (loan.getPaymentDate().compareTo(loan.getDueDate()) > 0) {
            throw new LoanValidationException("Payment date cannot be greater than the due date.");
        }
        loans.add(loan);
    }

    public void logAlerts() {
        for (Loan loan : loans) {
            if (loan.isOverdue()) {
                System.out.println("Alert: Loan " + loan.getLoanId() + " is overdue!");
            }
        }
    }

    public Map<String, Double> aggregateByLender() {
        Map<String, Double> result = new HashMap<>();
        for (Loan loan : loans) {
            result.put(loan.getLenderId(), result.getOrDefault(loan.getLenderId(), 0.0) + loan.getRemainingAmount());
        }
        return result;
    }

    public Map<Integer, Double> aggregateByInterest() {
        Map<Integer, Double> result = new HashMap<>();
        for (Loan loan : loans) {
            result.put((int) loan.getInterestPerDay(), result.getOrDefault(loan.getInterestPerDay(), 0.0) + loan.getRemainingAmount());
        }
        return result;
    }

    public Map<String, Double> aggregateByCustomerId() {
        Map<String, Double> result = new HashMap();
        for (Loan loan : loans) {
            result.put(loan.getCustomerId(), result.getOrDefault(loan.getCustomerId(), 0.0) + loan.getRemainingAmount());
        }
        return result;
    }

    public List<Loan> getLoans() {
        return loans;
    }

}
