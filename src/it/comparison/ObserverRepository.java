/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.comparison;

import java.util.*;

/**
 *
 * @author welcome
 */
public class ObserverRepository  implements Container{
   //public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

   public List<Observer> listObserver = new ArrayList<Observer>();
   
   public ObserverRepository(){
       listObserver.add(new ConsoleDisplay());
   }
   @Override
   public Iteratr getIterator() {
      return new ObserverIterator();
   }

   
   private class ObserverIterator implements Iteratr {

          int index;

      @Override
      public boolean hasNext() {
         if(index < listObserver.size()){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
         if(this.hasNext()){
             return listObserver.get(index++);
           // return names[index++];
         }
         return null;
      }
   }
     
   
   }
