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
		moneyExchanger.startExchange();

	}
}
