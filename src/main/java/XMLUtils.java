import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLUtils {

	public Element createXML(Element root, String benchID, String benchmark, String country, String industry, String id,
			String name, String sector, String datefrom, String pricefrom, String priceBenchfrom, String dateto,
			String priceto, String priceBenchto, String alpha3M, String beta3M, String vol3M, String alpha6M,
			String beta6M, String vol6M, String zname, String cname, String alpha1Y, String beta1Y, String iname,
			String te, String ir, String sname, String vol1Y) throws IOException {

		Element stock = new Element("stock");
		stock.setAttribute("benchID", benchID);
		stock.setAttribute("benchmark", benchmark);
		stock.setAttribute("country", country);
		stock.setAttribute("id", id);
		stock.setAttribute("industry", industry);
		stock.setAttribute("name", name);
		stock.setAttribute("sector", sector);
		stock.setAttribute("industry", industry);

		Element prices = new Element("prices");
		Element obs1 = new Element("obs");
		obs1.setAttribute("date", datefrom);
		obs1.setAttribute("price", pricefrom);
		obs1.setAttribute("priceBench", priceBenchfrom);

		Element obs2 = new Element("obs");
		obs2.setAttribute("date", dateto);
		obs2.setAttribute("price", priceto);
		obs2.setAttribute("priceBench", priceBenchto);

		Element indicators = new Element("indicators");
		Element indicator1 = new Element("indicator");
		indicator1.setAttribute("alpha", alpha3M);
		indicator1.setAttribute("beta", beta3M);
		indicator1.setAttribute("period", "3M");
		indicator1.setAttribute("vol", vol3M);
		Element indicator2 = new Element("indicator");
		indicator2.setAttribute("alpha", alpha6M);
		indicator2.setAttribute("beta", beta6M);
		indicator2.setAttribute("period", "6M");
		indicator2.setAttribute("vol", vol6M);

		Element indicator3 = new Element("indicator");
		indicator3.setAttribute("alpha", alpha1Y);
		indicator3.setAttribute("beta", beta1Y);
		indicator3.setAttribute("period", "1Y");
		indicator3.setAttribute("vol", vol1Y);

		Element zone = new Element("zone");
		zone.setAttribute("zname", zname);
		Element Country = new Element("country");
		Country.setAttribute("cname", cname);
		Element Sector = new Element("sector");
		Sector.setAttribute("sname", sname);
		Element Industry = new Element("industry");
		Industry.setAttribute("iname", iname);
		Element trackingError = new Element("trackingError");
		trackingError.setAttribute("te", te);
		Element informationRatio = new Element("informationRatio");
		informationRatio.setAttribute("ir", ir);

		stock.addContent(prices);
		prices.addContent(obs1);
		prices.addContent(obs2);
		stock.addContent(indicators);
		indicators.addContent(indicator1);
		indicators.addContent(indicator2);
		indicators.addContent(indicator3);
		zone.addContent(Country);
		stock.addContent(zone);
		Sector.addContent(Industry);
		stock.addContent(Sector);
		stock.addContent(trackingError);
		stock.addContent(informationRatio);

		return stock;
	}
}
