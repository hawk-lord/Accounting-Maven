package ax.joint.model;

import java.time.LocalDate;

public class AccountingEntry {

    private final Money amount;
    private final LocalDate date;
    private final Account account;
    private final AccountingTransaction transaction;

    public AccountingEntry(final Money amount, final LocalDate date, final Account account, final AccountingTransaction transaction) {
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.transaction = transaction;
    }


    public Money getAmount() {
        return amount;
    }

    public LocalDate getBookingDate() {
        return date;
    }

    public void post() {
        // only used by AccountingTransaction
        account.addEntry(this);
    }

}
