/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.comparison;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class ParserContext {
   private Parser strategy;   

   //this can be set at runtime by the application preferences
   public void setParserStrategy(Parser strategy) 
   {
       this.strategy = strategy;  
   }

  //use the strategy
   public void parse(String html) 
   {
        strategy.parse(html);
   }

}    

