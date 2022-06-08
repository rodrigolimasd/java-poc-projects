package com.rodtech.javapoprojects.pocspringdatajpa.controller;

import com.rodtech.javapoprojects.pocspringdatajpa.dto.TransactionDTO;
import com.rodtech.javapoprojects.pocspringdatajpa.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id){
        return ResponseEntity.ok(transactionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<TransactionDTO>> list(Pageable page){
        return ResponseEntity.ok(transactionService.list(page));
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> create(@RequestBody TransactionDTO transactionDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.create(transactionDTO));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody TransactionDTO transactionDTO){
        transactionService.update(transactionDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
