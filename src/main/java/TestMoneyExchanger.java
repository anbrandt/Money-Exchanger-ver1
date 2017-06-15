import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by andrzej on 14.06.17.
 */
public class TestMoneyExchanger {


	public static void main(String[] args) {

		//singleton design pattern - use only one instance of the class
		MoneyExchanger moneyExchanger = MoneyExchanger.getInstance();


		System.out.println();
		System.out.println("------------");
		System.out.println("BUY CURRENCY");

		BigDecimal plnToExchange = new BigDecimal("30.22");

		moneyExchanger.buy(plnToExchange, "EUR");
		moneyExchanger.buy(plnToExchange, "GBP");
		moneyExchanger.buy(plnToExchange, "USD");
		moneyExchanger.buy(plnToExchange, "CHF");
		moneyExchanger.buy(plnToExchange, "XXX");

		System.out.println();
		System.out.println("------------");
		System.out.println("SELL CURRENCY");


		BigDecimal amountToExchange = new BigDecimal("100.3");


		moneyExchanger.sell(new Money(amountToExchange, "USD"));
		moneyExchanger.sell(new Money(amountToExchange, "GBP"));
		moneyExchanger.sell(new Money(amountToExchange, "EUR"));
		moneyExchanger.sell(new Money(amountToExchange, "CHF"));
		moneyExchanger.sell(new Money(amountToExchange, "XXX"));

	}
}
