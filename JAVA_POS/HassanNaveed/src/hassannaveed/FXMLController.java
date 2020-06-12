package hassannaveed;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class FXMLController {
    
    ToggleGroup pizzaGroup;
    ToggleGroup drinkGroup;
       private static DecimalFormat df2 = new DecimalFormat("#.##");

    int noOfPizza=0;
    int noOfDrinks=0;
    double pizzaPrice=0.0;
    double drinksPrice = 0.0;
 
    PizzaSize pizzasize;
    Drinks typeDrink;
 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menubar;

    @FXML
    private RadioButton radioSmall;

    @FXML
    private RadioButton radioMedium;

    @FXML
    private RadioButton radioLarge;

    @FXML
    private TextField txtNoOfPizaa;

    @FXML
    private TextArea txtArea;

    @FXML
    private CheckBox chbxCheese;

    @FXML
    private CheckBox chbxPep;

    @FXML
    private CheckBox chbxMashroom;

    @FXML
    private CheckBox chbxOlives;

    @FXML
    private RadioButton radioCoke;

    @FXML
    private RadioButton radioJuice;

    @FXML
    private RadioButton radioMilk;

    @FXML
    private TextField txtNoOfDrinks;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    void cancelClick(ActionEvent event) {

    }

    @FXML
    void displayReceipt(ActionEvent event) {
                 txtArea.clear();

        try{
            
            String noOfPizzaString = txtNoOfPizaa.getText().toString();
            String noOfDrinksString = txtNoOfDrinks.getText().toString();
            
            int counter = 0 ;

            if(!isBlank(noOfPizzaString))
                if(isOnlyNumber(noOfPizzaString))
                    noOfPizza =  Integer.parseInt(txtNoOfPizaa.getText().toString()==""?"0":txtNoOfPizaa.getText());
                else {
                    counter++;
                }
            else{
            counter++;
            }
            if(!isBlank(noOfDrinksString))
                if(isOnlyNumber(noOfDrinksString))
                    noOfDrinks =  Integer.parseInt(txtNoOfDrinks.getText().toString()==""?"0":txtNoOfDrinks.getText());
                else{
                    counter++;
                } 
            else{
            counter++;
            }
            if(counter==0){
                txtArea.appendText("You must select pizza or drink.");
            }
            
                    
       
        pizzaPrice = pizzasize.getPrice()*noOfPizza;
        drinksPrice = typeDrink.getPrice()*noOfDrinks;
       
        
        }catch(NumberFormatException ne){
            txtArea.appendText("invalid entry, must be an integer");
            //return;
        }
        catch(Exception e ){
        
        }
        
     
            
          
           
       
        ArrayList<Toppings> toppingList = new ArrayList<>();
        
        if(chbxCheese.isSelected())
            toppingList.add(Toppings.CHEESE);
        
        if(chbxPep.isSelected())
            toppingList.add(Toppings.PEPPERONI);
        
        if(chbxMashroom.isSelected())
            toppingList.add(Toppings.MUSHROOMS);
        
        if(chbxOlives.isSelected())
            toppingList.add(Toppings.OLIVES);
        
        
        double toppingPrice=0.0;

        PizzaOrder pizzaOrder = new PizzaOrder(pizzasize,toppingList,typeDrink,noOfPizza,noOfDrinks);
        
        if(noOfPizza>0){
        for(int i=0;i<toppingList.size();i++){
            toppingPrice += toppingList.get(i).getPrice()*noOfPizza;
        }
        }
        if(noOfPizza<=0 && noOfDrinks<=0){
            txtArea.appendText("You must select at least one pizza or drink");
            return;
        }

        double subtotal  =  pizzaPrice+drinksPrice+toppingPrice;
        double hst = subtotal*0.13;
        double total = subtotal+hst;
        
         txtArea.appendText("       Receipt");
         if(pizzaOrder.getNoOfPizza()>0)
            txtArea.appendText("\nPizza :           "+pizzaPrice+"\n"+pizzaOrder.getNoOfPizza()+" @ "+pizzaOrder.pizzaSize+" "+pizzaOrder.pizzaSize.getPrice());
         if(toppingList.size()>0 && noOfPizza>0){
             txtArea.appendText("\nToppings :       "+toppingPrice);
             String txt = "";
         for(int i=0;i<toppingList.size();i++){
            txtArea.appendText("\n "+noOfPizza+" "+toppingList.get(i).name()+" @ "+toppingList.get(i).getPrice());
        }
         }
         if(pizzaOrder.getNumOfDrinks()>0)
            txtArea.appendText("\nDrinks :         "+drinksPrice+"\n"+pizzaOrder.getNumOfDrinks()+" @ "+pizzaOrder.typeDrink+" "+pizzaOrder.typeDrink.getPrice());
       
         txtArea.appendText("\n===============================================================");
         txtArea.appendText("\nSubtotal :        "+df2.format(subtotal));
         txtArea.appendText("\nHST:              "+df2.format(hst));
         txtArea.appendText("\nTotal:            "+df2.format(total));

         
        
    }
    public boolean isBlank(String value) {
    return (value == null || value.equals("") || value.equals("null") || value.trim().equals(""));
    }


public boolean isOnlyNumber(String value) {
    boolean ret = false;
    if (!isBlank(value)) {
        ret = value.matches("^[0-9]+$");
    }
    return ret;
}
    

    @FXML
    void initialize() {
         pizzaGroup = new ToggleGroup();
    radioSmall.setToggleGroup(pizzaGroup);
    radioMedium.setToggleGroup(pizzaGroup);
        radioLarge.setToggleGroup(pizzaGroup);
        
  drinkGroup = new ToggleGroup();
    radioJuice.setToggleGroup(drinkGroup);
    radioMilk.setToggleGroup(drinkGroup);
        radioCoke.setToggleGroup(drinkGroup);

        
        pizzaGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {

            RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
            System.out.println("Selected Radio Button - "+chk.getText());
                           String pizzaType="";

            pizzaType = chk.getText();
            if(pizzaType.equals("Small"))
                 {
                    pizzasize = PizzaSize.SMALL;
                    
                     
                 }
            else if (pizzaType.equals("Medium")){
                    pizzasize = PizzaSize.MEDIUM;

            }
            else if (pizzaType.equals("Large")){
                    pizzasize = PizzaSize.LARGE;

            }else{}


        }
    });
        drinkGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
        @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {

            RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
            System.out.println("Selected Radio Button - "+chk.getText());
    String drinksType="";
            drinksType = chk.getText();
                if(drinksType.equals("Juice"))
                 {
                       typeDrink = Drinks.JUICE;
                 }
            else if (drinksType.equals("Coke")){
                       typeDrink = Drinks.COKE;

            }
            else if (drinksType.equals("Milk")){
                       typeDrink = Drinks.CHOCOLATE_MILK;

            }else{}

        }
    });
    
        assert menubar != null : "fx:id=\"menubar\" was not injected: check your FXML file 'FXML.fxml'.";
        assert radioSmall != null : "fx:id=\"radioSmall\" was not injected: check your FXML file 'FXML.fxml'.";
        assert radioMedium != null : "fx:id=\"radioMedium\" was not injected: check your FXML file 'FXML.fxml'.";
        assert radioLarge != null : "fx:id=\"radioLarge\" was not injected: check your FXML file 'FXML.fxml'.";
        assert txtNoOfPizaa != null : "fx:id=\"txtNoOfPizaa\" was not injected: check your FXML file 'FXML.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'FXML.fxml'.";
        assert chbxCheese != null : "fx:id=\"chbxCheese\" was not injected: check your FXML file 'FXML.fxml'.";
        assert chbxPep != null : "fx:id=\"chbxPep\" was not injected: check your FXML file 'FXML.fxml'.";
        assert chbxMashroom != null : "fx:id=\"chbxMashroom\" was not injected: check your FXML file 'FXML.fxml'.";
        assert chbxOlives != null : "fx:id=\"chbxOlives\" was not injected: check your FXML file 'FXML.fxml'.";
        assert radioCoke != null : "fx:id=\"radioCoke\" was not injected: check your FXML file 'FXML.fxml'.";
        assert radioJuice != null : "fx:id=\"radioJuice\" was not injected: check your FXML file 'FXML.fxml'.";
        assert radioMilk != null : "fx:id=\"radioMilk\" was not injected: check your FXML file 'FXML.fxml'.";
        assert txtNoOfDrinks != null : "fx:id=\"txtNoOfDrinks\" was not injected: check your FXML file 'FXML.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'FXML.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'FXML.fxml'.";

    }
}
