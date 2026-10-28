package entities;

import java.time.LocalDate;

public class Installment {
    private LocalDate dueDate;
    private Double amount;
    private Integer installment;

    public Installment(LocalDate dueDate, Double amount, Integer installment) {
        this.dueDate = dueDate;
        this.amount = amount;
        this.installment = installment;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }
}
