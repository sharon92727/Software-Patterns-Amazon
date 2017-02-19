package it.comparison;

import java.util.Calendar;

public class ConsoleDisplay implements Display,Observer {
    

    @Override
    public void update(Observable observable, PriceResults results) {
		 AmazonComparison ac = (AmazonComparison)observable;
                System.out.println("URL - Price\n");

                 results.getPrices().stream()
                .forEach(o -> System.out.printf("%s - %s\n", o.getUrl(), o.getPrice()));

		
		// this.display(message);
	}

        
	public void display(String msg) {
	System.out.println(msg);
		
	}

    /*   @Override
    public void show(PriceResults results) {

        System.out.println("URL - Price\n");

        results.getPrices().stream()
                .forEach(o -> System.out.printf("%s - %s\n", o.getUrl(), o.getPrice()));

    }
  */  

    
    
}
