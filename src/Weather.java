import com.jaunt.*;
import com.jaunt.component.*;
import java.util.List;
import java.text.NumberFormat;
public class Weather{
  public static void main(String[] args){
    try{
      UserAgent userAgent = new UserAgent(); 
      userAgent.visit("https://www.accuweather.com");
      Element city = userAgent.doc.findFirst("<div class=\"loc\">");
      System.out.println(city.innerText());
      Element temp = userAgent.doc.findFirst("<span class=\"large-temp\">");
      String tvalue = temp.innerText().replaceAll("&deg;", "");
      double num = ((Double.parseDouble(tvalue) - 32.0) * (5.0 / 9.0));
      System.out.printf("The actual temp is "+tvalue+" Fahrenheit."+" In Celsius: %.1f", num);
    }
    catch(JauntException e){                          
      System.out.println(e);
    }    
  }
}