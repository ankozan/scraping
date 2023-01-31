import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import rei.Item;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class Scraping {
    public static void main(String[] args) throws IOException {
        String searchQuery = "iphone 13";

// Instantiate the client
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(true);
        client.getOptions().setThrowExceptionOnScriptError(false);

// Set up the URL with the search term and send the request
        String searchUrl = "https://www.rei.com/f/scd-deals";
        HtmlPage page = client.getPage(searchUrl);
        List<HtmlElement> items = page.getByXPath("//div[@id='search-results']//*[@data-ui='savings-percent']//ancestor::li");
        if(items.isEmpty()){
            System.out.println("No items found !");
        }else{
            for(HtmlElement htmlItem : items){

                String brand  = ((HtmlElement) htmlItem.getFirstByXPath(".//span[@data-ui='product-brand']")).asNormalizedText() ;
                String title  = ((HtmlElement) htmlItem.getFirstByXPath(".//span[@data-ui='product-title']")).asNormalizedText() ;
                String newPrice  = ((HtmlElement) htmlItem.getFirstByXPath(".//span[@data-ui='sale-price']")).asNormalizedText() ;
                String oldPrice  = ((HtmlElement) htmlItem.getFirstByXPath(".//span[@data-ui='compare-at-price']")).asNormalizedText() ;
                String savingsPercentage  = ((HtmlElement) htmlItem.getFirstByXPath(".//div[@data-ui='savings-percent']")).asNormalizedText() ;
                String imgLink  = "https://www.rei.com/" + ((HtmlElement) htmlItem.getFirstByXPath(".//*[contains(@alt,'0')]")).getAttribute("src") ;

                Item item = new Item(brand,title,newPrice,oldPrice,savingsPercentage,imgLink);
                ObjectMapper mapper =  new ObjectMapper();
                String jsonString = mapper.writeValueAsString(item);
                System.out.println(jsonString);

            }
        }


    }
}
