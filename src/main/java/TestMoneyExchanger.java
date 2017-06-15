import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by andrzej on 14.06.17.
 */
public class TestMoneyExchanger {


	public static void main(String[] args) {

		MoneyExchanger moneyExchanger = MoneyExchanger.getInstance();

//		Scanner scanner = new Scanner(System.in);

//		ExchangeRate exchangeRate = new ExchangeRate();
//		moneyExchanger.h("USD", exchangeRate.setBuyPrice(new BigDecimal("4.44")));


		BigDecimal plnToExchange = new BigDecimal("30.22");

		moneyExchanger.buy(plnToExchange, "EUR");
		moneyExchanger.buy(plnToExchange, "GBP");
		moneyExchanger.buy(plnToExchange, "USD");
		moneyExchanger.buy(plnToExchange, "CHF");
		moneyExchanger.buy(plnToExchange, "XXX");

		System.out.println();
		System.out.println("------------");
		System.out.println("SELL CURRENCY");


		BigDecimal currencyToExchange = new BigDecimal("100.3");

		String currency = "USD";

		moneyExchanger.sell(new Money(currencyToExchange, currency));




	}
}
