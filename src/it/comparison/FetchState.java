/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.comparison;

/**
 *
 * @author welcome
 */
public class FetchState implements ToolState{
   
 
    @Override
    public void writeState(final StateContext context,String name) {
        System.out.println(name);
         context.setState(new ParserState());
    }
    
}
