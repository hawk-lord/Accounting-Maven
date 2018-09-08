package ax.joint.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

public abstract class Account {

    private Set<AccountingEntry> entries = new HashSet<>();

    private Currency currency;

    /*
    public void addEntry(Money money, LocalDate date) {

        entries.add(new AccountingEntry(money, date, this, this));

    }
    */

    public void addEntry(AccountingEntry accountingEntry) {

        entries.add(accountingEntry);

    }


    public Money balance() {

        final Money result = new Money(BigDecimal.ZERO, currency);

        for (AccountingEntry accountingEntry: entries) {
            result.add(accountingEntry.getAmount());
        }

        return result;
    }

    public Set<AccountingEntry> getEntries() {
        return entries;
    }

}
