package it.comparison;

public class AmazonComparisonApp {

    public static void main(String[] args) {
       AmazonComparison comparison = AmazonComparison.getInstance();
      AmazonComparison comparison1 = AmazonComparison.getInstance();
       
     
       final StateContext sc = new StateContext();
 
        sc.writeState(" Application Loading  ");
     
        Fetcher fetcher = new HTMLFetcher();
        sc.writeState(" Fetching data from website  ");
        Parser parser = new DomParser();
     
        
        Amazon india = new AmazonImpl(fetcher, parser, "http://www.amazon.in/dp");
        Amazon italy = new AmazonImpl(fetcher, parser, "http://www.amazon.it/dp");
        Amazon france = new AmazonImpl(fetcher, parser, "http://www.amazon.fr/dp");
        Amazon german = new AmazonImpl(fetcher, parser, "http://www.amazon.de/dp");
        
        System.out.println();
        sc.writeState(" Parsing Data ");
        comparison.addSite(india);
        comparison.addSite(italy);
        comparison.addSite(france);
        comparison.addSite(german);
       // comparison.findPrices("8862561709");
       comparison.findPrices("8129135728"); 
        //System.out.println(italy.findPrice("8129135728"));
      
        
             

    }
}
