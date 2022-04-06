package ro.zynk.futureup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.zynk.futureup.controllers.responses.ListTransactionResponse;
import ro.zynk.futureup.controllers.responses.TransactionResponse;
import ro.zynk.futureup.domain.dtos.Transaction;
import ro.zynk.futureup.domain.repositories.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public ListTransactionResponse getTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionResponse> transactionResponses = new ArrayList<>();
        for(Transaction transaction:transactions) {
            transactionResponses.add(new TransactionResponse(transaction));
        }
        return new ListTransactionResponse(transactionResponses);
    }

    public ListTransactionResponse getTransactionsWithPriceGreaterThan(Float amountOfUsd) {
        List<Transaction> transactions = transactionRepository.findAll();
        List<TransactionResponse> transactionResponses = new ArrayList<>();
        for(Transaction transaction:transactions) {
            if(transaction.getTotalValue() > amountOfUsd)
            transactionResponses.add(new TransactionResponse(transaction));
        }
        return new ListTransactionResponse(transactionResponses);
    }
}
