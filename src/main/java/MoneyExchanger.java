import com.sun.org.apache.xpath.internal.SourceTree;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class MoneyExchanger {
//using singleton pattern

	private Map<String, ExchangeRate> hashmap = new HashMap<String, ExchangeRate>();
	ExchangeRate tempExchangeRate;
	BigDecimal tempBigDecimal;

	public Map<String, ExchangeRate> getHashmap() {
		return hashmap;
	}

	public void setHashmap(Map<String, ExchangeRate> hashmap) {
		this.hashmap = hashmap;
	}


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
				tempBigDecimal = amount.multiply(tempExchangeRate.getBuyPrice(), new MathContext(3));

				System.out.println("You want to buy: " + amount + " " + targetCurrency);
				System.out.println("It will cost you " + tempBigDecimal + " PLN");
			}

		} catch (NullPointerException e) {
			e.getStackTrace();
			System.out.println("We don't have this currency " + targetCurrency);
		}
		return tempBigDecimal;
	}


	public BigDecimal sell(Money money) {
		
		BigDecimal valueInPLN = null;

		BigDecimal amountToSell = money.getAmount();

		String currencyToExchange = money.getCurrency();
		tempBigDecimal = initializeHashMap().get(currencyToExchange).getSellPrice();


		if (currencyToExchange.equals("USD")) {

			valueInPLN = tempBigDecimal.multiply((amountToSell), new MathContext(3));

		} else if (currencyToExchange.equals("GBP")) {

			valueInPLN = tempBigDecimal.multiply((amountToSell), new MathContext(3));
		} else if (currencyToExchange.equals("EUR")) {

			valueInPLN = tempBigDecimal.multiply((amountToSell), new MathContext(3));
		} else if (currencyToExchange.equals("CHF")) {

			valueInPLN = tempBigDecimal.multiply((amountToSell), new MathContext(3));
		} else {
			System.out.println("there is no valid currency");
		}
		System.out.println("You want to sell: " + amountToSell + " " + currencyToExchange + "\n" +
				"The rate is " + tempBigDecimal + "\n" +
				"You will get " + valueInPLN + " PLN");
		return valueInPLN;
	}

	public Map<String, ExchangeRate> initializeHashMap() {
		hashmap.put("USD", new ExchangeRate(new BigDecimal("4.4"), new BigDecimal("4.9")));
		hashmap.put("EUR", new ExchangeRate(new BigDecimal("4.1"), new BigDecimal("4.7")));
		hashmap.put("GBP", new ExchangeRate(new BigDecimal("5.4"), new BigDecimal("5.3")));
		hashmap.put("CHF", new ExchangeRate(new BigDecimal("3.8"), new BigDecimal("4.25")));

		return hashmap;
	}

}
