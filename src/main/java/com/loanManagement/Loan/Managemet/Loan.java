package com.loanManagement.Loan.Managemet;

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Loan {
    private String loanId;
    private String customerId;
    private String lenderId;
    private double amount;
    private double remainingAmount;
    private Date paymentDate;
	private double interestPerDay;
    private Date dueDate;
    private double penaltyPerDay;
    
    public Loan(String loanId, String customerId, String lenderId, double amount, double remainingAmount,
            String paymentDate, double interestPerDay, String dueDate, double penaltyPerDay) throws ParseException {
        this.loanId = loanId;
        this.customerId = customerId;
        this.lenderId = lenderId;
        this.amount = amount;
        this.remainingAmount = remainingAmount;
        this.paymentDate = new SimpleDateFormat("dd/MM/yyyy").parse(paymentDate);
        this.interestPerDay = interestPerDay;
        this.dueDate = new SimpleDateFormat("dd/MM/yyyy").parse(dueDate);
        this.penaltyPerDay = penaltyPerDay;
}

    public boolean isOverdue() {
        return new Date().compareTo(dueDate) > 0;
    }

}


