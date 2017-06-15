import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MoneyExchanger {
//using singleton pattern

	private Map<String, ExchangeRate> hashmap = new HashMap<String, ExchangeRate>();
	ExchangeRate tempExchangeRate;
	BigDecimal tempFinalPrice;
	BigDecimal tempCurrencyRate;



	private static MoneyExchanger instance;

	private MoneyExchanger() {
		initializeHashMap();
	}

	public static MoneyExchanger getInstance() {
		if (instance == null) {
			instance = new MoneyExchanger();
		}
		return instance;
	}

	public BigDecimal buy(BigDecimal amount, String targetCurrency) {
		//buy for PLN with selected currency

		try {

			if (amount != null || targetCurrency != null) {
				tempExchangeRate = initializeHashMap().get(targetCurrency);
				tempFinalPrice = amount.multiply(tempExchangeRate.getBuyPrice(), new MathContext(3));

				System.out.println("You want to buy: " + amount + " " + targetCurrency);
				System.out.println("It will cost you " + tempFinalPrice + " PLN");
			}

		} catch (NullPointerException e) {
			e.getStackTrace();
			System.out.println("We don't have this currency " + targetCurrency);
		}
		return tempFinalPrice;
	}


	public BigDecimal sell(Money money) {

		BigDecimal amountToSell = money.getAmount();
		String currencyToExchange = money.getCurrency();

		try {

			if (amountToSell != null || currencyToExchange != null) {
				tempExchangeRate = initializeHashMap().get(currencyToExchange);
				tempCurrencyRate = tempExchangeRate.getSellPrice();
				tempFinalPrice = amountToSell.multiply(tempExchangeRate.getSellPrice(), new MathContext(3));

				System.out.println("You want to sell: " + amountToSell + " " + currencyToExchange + "\n" +
						"The rate is " + tempCurrencyRate + "\n" +
						"You will get " + tempFinalPrice + " PLN");

			}
		} catch (NullPointerException e) {
			e.getStackTrace();
			System.out.println("No currency available " + currencyToExchange);
		}

		return tempFinalPrice;
	}

	public Map<String, ExchangeRate> initializeHashMap() {
		hashmap.put("USD", new ExchangeRate(new BigDecimal("4.4"), new BigDecimal("4.9")));
		hashmap.put("EUR", new ExchangeRate(new BigDecimal("4.1"), new BigDecimal("4.7")));
		hashmap.put("GBP", new ExchangeRate(new BigDecimal("5.4"), new BigDecimal("5.3")));
		hashmap.put("CHF", new ExchangeRate(new BigDecimal("3.8"), new BigDecimal("4.25")));

		return hashmap;
	}

	public void startExchange() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What would you like to do? \n " +
				"press 'buy' if you want to buy currency \n"
				+ "press 'sell' if you want sell currency");

		String enterExchanger = scanner.next();

		try {
			if (enterExchanger.equals("buy")) {
				System.out.println("Which currency do you want to buy?");
				String chooseCurrency = scanner.next();
				System.out.println("How much currency do you want to buy?");
				BigDecimal chooseAmount = scanner.nextBigDecimal();

				buy(chooseAmount, chooseCurrency);

			} else if (enterExchanger.equals("sell")) {
				System.out.println("Which currency do you want to sell?");
				String chooseCurrency = scanner.next();
				System.out.println("How much currency do you want to sell?");
				BigDecimal chooseAmount = scanner.nextBigDecimal();
				Money money = new Money(chooseAmount, chooseCurrency);
				sell(money);

			} else {
				System.out.println("Write either buy or sell");
				startExchange();
			}
		}catch (InputMismatchException e) {
			e.getStackTrace();
			System.out.println("Wrong input");
		}

	}

}
