package ro.zynk.futureup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.zynk.futureup.controllers.responses.BaseResponse;
import ro.zynk.futureup.controllers.responses.ErrorResponse;
import ro.zynk.futureup.exceptions.NotFoundException;
import ro.zynk.futureup.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "")
    public ResponseEntity<BaseResponse> getTransactions() {
        try {
            return new ResponseEntity<>(transactionService.getTransactions(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/price_greater_than")
    public ResponseEntity<BaseResponse> getTransactionsWithPriceGreaterThan(@RequestParam("amountOfUsd") Float amountOfUsd) {
        try {
            return new ResponseEntity<>(transactionService.getTransactionsWithPriceGreaterThan(amountOfUsd), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
