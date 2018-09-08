package ax.joint.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

public class AccountingTransaction {

    private final String name;
    private final LocalDate date;
    private final Currency currency;
    private final Set<AccountingEntry> entries = new HashSet<>();
    private boolean wasPosted;


    public AccountingTransaction(final String  name, final LocalDate date, final Currency currency) {
        this.name = name;
        this.date = date;
        this.currency = currency;
    }

    public void add(final Money money, final Account account) {
        final AccountingEntry entry = new AccountingEntry(money, date, account, this);
        entries.add(entry);
    }

    public void post() {
        if (!canPost()) {
            throw new RuntimeException();
        }

        for (AccountingEntry accountingEntry: entries) {
            accountingEntry.post();
        }
        wasPosted = true;
    }

    public boolean canPost(){
        return balance().isZero();
    }

    private Money balance() {
        final Money balance = new Money(BigDecimal.ZERO, currency);
        for (AccountingEntry accountingEntry: entries) {
            balance.add(accountingEntry.getAmount());
        }
        return balance;
    }

}
