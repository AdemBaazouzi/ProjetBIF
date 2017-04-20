import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

public class Main {

	public static void main(String[] args) throws IOException {
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.YEAR, -1); // from 5 years ago
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Stock google = YahooFinance.get("GOOG", from, to, Interval.MONTHLY);
		for (HistoricalQuote s : google.getHistory()) {
			String formatted = format1.format(s.getDate().getTime());

			System.out.println(formatted + " : " + s.getAdjClose());
		}
	}

}
