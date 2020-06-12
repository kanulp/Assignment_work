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
public enum Toppings {
   CHEESE(1.00),
    MUSHROOMS(1.25),
    OLIVES(1.50),
   PEPPERONI(1.75);
    
   private double price; 
  
    public double getPrice() 
    { 
        return this.price; 
    } 
  
    // enum constructor - cannot be public or protected 
    private Toppings(double price) 
    { 
        this.price = price; 
    } 
}
