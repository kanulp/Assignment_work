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
public enum PizzaSize {
    SMALL(5.25),
  MEDIUM(7.50),
  LARGE(9.95);
    private double price; 
  
    public double getPrice() 
    { 
        return this.price; 
    } 
  
    // enum constructor - cannot be public or protected 
    private PizzaSize(double price) 
    { 
        this.price = price; 
    } 
}
