package ro.zynk.futureup.controllers.responses;

import ro.zynk.futureup.domain.dtos.Transaction;

import java.time.LocalDateTime;

public class TransactionResponse extends BaseResponse {
    private LocalDateTime transactionDate;
    private Long coinId;
    private Double amount;
    private Float totalValue;

    public TransactionResponse(Transaction transaction) {
        this.transactionDate = transaction.getTransactionDate();
        this.coinId = transaction.getCoin().getId();
        this.amount = transaction.getAmount();
        this.totalValue = transaction.getTotalValue();
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Long getCoinId() {
        return coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Float totalValue) {
        this.totalValue = totalValue;
    }
}
