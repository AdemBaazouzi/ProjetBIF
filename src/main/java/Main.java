import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

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
		Stock google = YahooFinance.get("BN.PA", from, to, Interval.MONTHLY);
		for (HistoricalQuote s : google.getHistory()) {
			String formatted = format1.format(s.getDate().getTime());

			System.out.println(formatted + " : " + s.getAdjClose());
		}
	}

	
	//Fonction pour creer OUTPUT.XML
	void createXML() throws IOException {

		Element root = new Element("data");
		Document doc = new Document();

		XMLUtils x = new XMLUtils();
		Element stock1 = x.createXML(root, "benchID", "benchmark", "country", "industry", "id", "name", "sector",
				"datefrom", "pricefrom", "priceBenchfrom", "dateto", "priceto", "priceBenchto", "alpha3M", "beta3M",
				"vol3M", "alpha6M", "beta6M", "vol6M", "zname", "cname", "alpha1Y", "beta1Y", "iname", "te", "ir",
				"sname", "vol1Y");

		root.addContent(stock1);
		doc.setRootElement(root);
		XMLOutputter outter = new XMLOutputter();
		outter.setFormat(Format.getPrettyFormat());
		outter.output(doc, new FileWriter(new File("OUTPUT.xml")));
	}

}
