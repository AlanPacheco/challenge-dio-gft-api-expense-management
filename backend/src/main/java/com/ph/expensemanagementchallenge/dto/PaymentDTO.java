package com.ph.expensemanagementchallenge.dto;

import com.ph.expensemanagementchallenge.entities.Payment;
import com.ph.expensemanagementchallenge.entities.enums.PaymentType;

import java.io.Serializable;

public class PaymentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private PaymentType paymentType;
    private Double amount;

    private Long expenseId;

    public PaymentDTO(){
    }

    public PaymentDTO(Long id, PaymentType paymentType, Double amount) {
        this.id = id;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public PaymentDTO(Payment payment){
        this(payment.getId(), payment.getPaymentType(), payment.getAmount());
        this.expenseId = payment.getExpense().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }
}
