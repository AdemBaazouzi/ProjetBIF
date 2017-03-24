import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

public class Main {

	public static void main(String[] args) throws IOException {
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.YEAR, -5); // from 5 years ago

		Stock google = YahooFinance.get("GOOG", from, to, Interval.DAILY);
		
		System.out.println(google.getHistory());

	}

}
