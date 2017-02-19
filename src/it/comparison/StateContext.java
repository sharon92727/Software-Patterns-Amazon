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
public class StateContext {
     private ToolState state;
    
     public StateContext() {
        setState(new InitialState());
    }
 
    void setState(final ToolState newState) {
        state = newState;
    }
 public void writeState(final String name) {
        state.writeState(this, name);
    }
   }
