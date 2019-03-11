class Account {
    private int balance;
    private int limit;

    Account(int startingBalance, int limit) {
        balance = startingBalance;
        this.limit = limit;
    }

    Account() {
        this(0, 50);
    }

    int getBalance() {
        return balance;
    }

    void topUp(int amount) throws LimitExceededException {
        if (balance + amount <= limit) {
            balance += amount;
        } else {
            throw new LimitExceededException("Balance cannot exceed " + limit);
        }
    }

    void spend(int amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new InsufficientFundsException();
        }
    }

}
