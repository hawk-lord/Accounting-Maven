package ax.joint;

import ax.joint.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {

        System.out.println( "Hello World!" );

        final CardAccount creditCard1 = new CardAccount();
        final DepositAccount depositAccount1 = new DepositAccount();
        final MerchantAccount merchantAccount1 = new MerchantAccount();

        final String name1 = "Tidskrifter";
        final LocalDate date1 = LocalDate.of(2018,9,8);
        final AccountingTransaction accountingTransaction1 =
                new AccountingTransaction(name1, date1, Currency.getInstance("EUR"));

        final Money money11 = new Money(BigDecimal.valueOf(22.35), Currency.getInstance("EUR"));
        accountingTransaction1.add(money11, merchantAccount1);

        final Money money12 = new Money(BigDecimal.valueOf(-22.35), Currency.getInstance("EUR"));
        accountingTransaction1.add(money12, creditCard1);

        accountingTransaction1.post();

        for (AccountingEntry accountingEntry: creditCard1.getEntries()) {
            System.out.format("%s %s", accountingEntry.getBookingDate(), accountingEntry.getAmount());
        }

    }
}
