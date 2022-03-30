package com.model;

import java.util.Optional;

public interface IssueBook {
    Optional<BorrowTransaction> issueBook(BookItem bookToBorrow);
}
