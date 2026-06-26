package com.jpmc.midascore.component;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConduit {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public DatabaseConduit(UserRepository userRepository,
                           TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Existing helper method used by the project scaffold and test utilities
     * to populate the database with users.
     */
    public void save(UserRecord userRecord) {
        userRepository.save(userRecord);
    }

    /**
     * Processes an incoming transaction.
     */
    public void processTransaction(Transaction transaction) {

        UserRecord sender = userRepository.findById(transaction.getSenderId());
        UserRecord recipient = userRepository.findById(transaction.getRecipientId());

        // Transaction is invalid if either user does not exist.
        if (sender == null || recipient == null) {
            return;
        }

        // Transaction is invalid if sender has insufficient funds.
        if (sender.getBalance() < transaction.getAmount()) {
            return;
        }

        // Update balances.
        sender.setBalance(sender.getBalance() - transaction.getAmount());
        recipient.setBalance(recipient.getBalance() + transaction.getAmount());

        // Persist updated users.
        userRepository.save(sender);
        userRepository.save(recipient);

        // Persist the transaction.
        TransactionRecord transactionRecord =
                new TransactionRecord(sender, recipient, transaction.getAmount());

        transactionRepository.save(transactionRecord);
    }
}