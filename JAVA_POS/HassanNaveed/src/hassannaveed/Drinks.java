/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hassannaveed;

/**
 *
 * @author kanu
 */
public enum Drinks {    
COKE(1.25),
JUICE(1.95),
CHOCOLATE_MILK(2.25);
        
 private double price; 
  
    public double getPrice() 
    { 
        return this.price; 
    } 
  
    // enum constructor - cannot be public or protected 
    private Drinks(double price) 
    { 
        this.price = price; 
    } 
}
