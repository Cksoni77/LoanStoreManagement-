package com.loanManagement.Loan.Managemet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class LoanStoreTest {


private LoanStore loanStore;

    @BeforeEach
    void setUp() {
        loanStore = new LoanStore();
    }

    @Test
    void testAddLoan_ValidLoan() throws LoanValidationException, ParseException {
        Loan validLoan = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
        loanStore.addLoan(validLoan);
        Assertions.assertEquals(1, loanStore.getLoans().size());
    }

    @Test
    void testAddLoan_InvalidPaymentDate() throws ParseException {
        Loan invalidLoan = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/08/2023", 1, "05/07/2023", 0.01);
        Assertions.assertThrows(LoanValidationException.class, () -> loanStore.addLoan(invalidLoan));
    }

    @Test
    void testAggregateByLender() throws LoanValidationException, ParseException {
        Loan loan1 = new Loan("L1", "C1", "LEN1", 10000, 10000, "05/06/2023", 1, "05/07/2023", 0.01);
        Loan loan2 = new Loan("L2", "C1", "LEN1", 20000, 5000, "01/06/2023", 1, "05/08/2023", 0.01);
        loanStore.addLoan(loan1);
        loanStore.addLoan(loan2);

        Assertions.assertEquals(1, loanStore.aggregateByLender().size());
        Assertions.assertEquals(15000.0, loanStore.aggregateByLender().get("LEN1"));
    }



}
