import com.jaunt.*;
import com.jaunt.component.*;
import java.util.List;
import java.text.NumberFormat;
/**
*
* @author D4v1d41
*/
public class Weather{
  public static void main(String[] args){
    try{
    	// User Agent
      UserAgent userAgent = new UserAgent(); 
      // Visit accuweather
      userAgent.visit("https://www.accuweather.com");
      // find the first element with the given html
      Element city = userAgent.doc.findFirst("<div class=\"loc\">");
      // print inner text of the city element, which is the text where displays the city
      System.out.println(city.innerText());
      // Find first element w/ the given html 
      Element temp = userAgent.doc.findFirst("<span class=\"large-temp\">");
      // declare string tvalue (temperature value)
      String tvalue = temp.innerText().replaceAll("&deg;", "");
      // format the tvalue string to double, and already convert fahrenheit to celsius
      double num = ((Double.parseDouble(tvalue) - 32.0) * (5.0 / 9.0));
      // print the temp in f and num, which is a double, with only two decimals
      System.out.printf("The actual temp is "+tvalue+" Fahrenheit."+" In Celsius: %.1f", num);
    }
    catch(JauntException e){                          
      System.out.println(e);
    }    
  }
}