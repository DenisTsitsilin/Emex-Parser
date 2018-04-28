package parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Tsits
 */
public class Logic{
    public static void main(String[] args) throws IOException {
            
        List<Logic> logic = new ArrayList<Logic>();
        String url = "https://www.emex.ru/f?detailNum="+numberString+"&packet=-1&locationId=11912";
        Document doc  = Jsoup.connect(url).get();
        Elements floatrightElements = doc.getElementsByClass("quantity");
//        String cost = floatrightElements.text();
//        Elements floatrightElements = doc.getElementsByAttributeValue("class", "float-right");
        floatrightElements.forEach(floatrightElement ->{
            Element spanElement = floatrightElement.child(0);
            String d = floatrightElement.text();
//            String cost = spanElement.text();
//            logic.add(new Logic(cost, cost, cost, cost, cost));         
            logic.add(new Logic(d, d, d, d, d));
        });

        logic.forEach(System.out::println);
    }
    public static String numberString = "9091901164";
    String name;
    String code;
    String cost;
    String count;
    String date;

    public Logic(String name, String code, String cost, String count, String date) {
        this.name = name;
        this.code = code;
        this.cost = cost;
        this.count = count;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCost() {
        return cost;
    }

    public String getCount() {
        return count;
    }

    public String getDate() {
        return date;
    }  

    @Override
    public String toString() {
        return "Logic{" + "name=" + name + ", code=" + code + ", cost=" + cost + ", count=" + count + ", date=" + date + '}';
    }
    
}