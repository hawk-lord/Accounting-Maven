package ax.joint.model;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {

    private final Currency currency;
    private BigDecimal amount;

    public Money(final BigDecimal amount, final Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }


    public void add(final Money money) {
        if (money.currency.equals(this.currency)) {
            this.amount = this.amount.add(money.amount);
        }
    }

    public boolean isZero() {
        return BigDecimal.ZERO.compareTo(amount) == 0;
    }

    @Override
    public String toString() {
        return String.format("%+.2f %s", amount, currency);
    }

}
