import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.layout.Pane; 
import javafx.stage.Stage;
import javafx.scene.control.Label; 
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.awt.*;

public class BankApp extends Application {
	public static void main(String[] args) { 
		launch(args);
	}
	@Override
	public void start(Stage primaryStage)throws Exception{
		Pane root = new Pane();
		//Deposit button
		Button btn1 = new Button("Deposit");
		btn1.setLayoutX(180);
		btn1.setLayoutY(150);
		root.getChildren().add(btn1);
		//Withdraw button
		Button btn2 = new Button("Withdraw");
		btn2.setLayoutX(245);
		btn2.setLayoutY(150);
		root.getChildren().add(btn2);
		
		Label a= new Label("Account Holder: John Doe");
		a.setLayoutX(175);
		a.setLayoutY(10);
		root.getChildren().add(a);
		
		Label b= new Label("Balance: 0.00");
		b.setLayoutX(200);
		b.setLayoutY(40);
		root.getChildren().add(b);
		
		Label c= new Label("Enter amount:");
		c.setLayoutX(175);
		c.setLayoutY(70);
		root.getChildren().add(c);

		TextField txtName = new TextField(""); 
		txtName.setPrefWidth(100);
		txtName.setLayoutX(270);
		txtName.setLayoutY(65);
		root.getChildren().add(txtName);
		
		Scene scene= new Scene(root,500,200);
		primaryStage.setTitle("My Bank");
		primaryStage.setScene(scene);
		primaryStage.show();
	} 
}