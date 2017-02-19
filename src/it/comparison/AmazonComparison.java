package it.comparison;

import java.util.*;

public class AmazonComparison implements Observable {
    private List<Amazon> amazonSites = new ArrayList<Amazon>();
    private Display display;

    static int  count=0;
      private static AmazonComparison instance = new AmazonComparison();
    
      private  AmazonComparison() {
        this.display = new ConsoleDisplay();
    
    }

   //Get the only object available
   public static AmazonComparison getInstance(){
       if(count==0)
       {
           count++;
            return instance;
       }
       else
       {System.out.println("Cant create object");
       return null;}
   }
       
    	private Set<Observer> observers;
	private boolean priceChanged;

     /*       
    public AmazonComparison(Display display) {
        this.display = display;
    }*/

          
    @Override
	public void notifyObservers() {
	
            Iterator<Observer> observerIterator = this.observers.iterator();
	while(observerIterator.hasNext()){
		Observer observer = observerIterator.next();
		observer.update(this, null);
	}
	
           
             ObserverRepository observerRepository = new ObserverRepository();

  //    for(Iterator iter = ObserverRepository.getIterator(); iter.hasNext();){
       //  String name = (String)iter.next();
       //  System.out.println("Name : " + name);
          //  } 
    
        }
      
	public void registerObserver(Observer observer) {
		if(observer != null && observer instanceof Observer){
			this.observers.add(observer);
		}
		
	}

	
	public void removeObserver(Observer observer) {
		if(observer != null && observer instanceof Observer){
			this.observers.remove(observer);
		}
		
	}

    public PriceResults findPrices(String isbn) {
        PriceResults priceResults = new PriceResults();
        for (Amazon site : amazonSites) {
            String price = site.findPrice(isbn);
            priceResults.addResult(site, price);
        }
        display.update(this, priceResults);
        //this.notifyObservers();
        //display.show(priceResults);
        return priceResults;
    }

    public void addSite(Amazon amazon) {
        amazonSites.add(amazon);
    }
}
