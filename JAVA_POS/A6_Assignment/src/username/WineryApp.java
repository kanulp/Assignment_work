/*
    Name:  [your name here]
    Assignment:  [assignment name]
    Program: [your program name here]
    Date:  [the date the program was written]
    
    Description:
    [program description in your own words]
*/
package username;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author H.D
 */
public class WineryApp extends Application{
    
    public static void main(String[] args) {
        launch(args);        
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        stage.setTitle("Winery Application");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
