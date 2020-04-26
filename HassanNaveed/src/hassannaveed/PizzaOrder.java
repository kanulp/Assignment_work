/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hassannaveed;

import java.util.ArrayList;

/**
 *
 * @author kanu
 */
public class PizzaOrder {
    
    PizzaSize pizzaSize;
    ArrayList<Toppings> toppingList;
    Drinks typeDrink;
    int noOfPizza;
    int numOfDrinks;
    final double TAX_RATE = 0.13;

    

    public PizzaSize getPizzaSize() {
        return this.pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public ArrayList<Toppings> getToppingList() {
        return this.toppingList;
    }

    public void setToppingList(ArrayList<Toppings> toppingList) {
        this.toppingList = toppingList;
    }

    public Drinks getTypeDrink() {
        return this.typeDrink;
    }

    public void setTypeDrink(Drinks typeDrink) {
        this.typeDrink = typeDrink;
    }

    public int getNoOfPizza() {
        return this.noOfPizza;
    }

    public void setNoOfPizza(int noOfPizza) {
        this.noOfPizza = noOfPizza;
    }

    public int getNumOfDrinks() {
        return this.numOfDrinks;
    }

    public void setNumOfDrinks(int numOfDrinks) {
        this.numOfDrinks = numOfDrinks;
    }

    public PizzaOrder(PizzaSize pizzaSize, ArrayList<Toppings> toppingList, Drinks typeDrink, int noOfPizza,
            int numOfDrinks) {
        this.pizzaSize = pizzaSize;
        this.toppingList = toppingList;
        this.typeDrink = typeDrink;
        this.noOfPizza = noOfPizza;
        this.numOfDrinks = numOfDrinks;
    }

    
}
