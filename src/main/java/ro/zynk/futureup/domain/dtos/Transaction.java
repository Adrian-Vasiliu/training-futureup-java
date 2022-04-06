package ro.zynk.futureup.domain.dtos;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions", uniqueConstraints = {@UniqueConstraint(columnNames = {"coin_id"})})
public class Transaction extends BaseEntity {
    @Column
    private LocalDateTime transactionDate;

    @ManyToOne
    @JoinColumn(name = "coin_id")
    private Coin coin;

    @Column
    private Double amount;

    @Column
    private Float totalValue;

    public Transaction() {
    }

    public Transaction(LocalDateTime transactionDate, Coin coin, double amount, float totalValue) {
        this.transactionDate = transactionDate;
        this.coin = coin;
        this.amount = amount;
        this.totalValue = totalValue;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }
}
