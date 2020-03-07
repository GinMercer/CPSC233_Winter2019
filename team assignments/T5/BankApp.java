import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BankApp extends Application {

  //Instance Variables for user and interactive elements of GUI
  private BankAccount johnDoe = new BankAccount(0.0, "0000");
  private TextField amount = new TextField();
  private Label balance;

  //Start Method
  public static void main(String[] args) {
    launch(args);
  }


/**
 * this is an inner class in BankApp that handles an event when Deposit button is pressed.
 * it reads the user input from textfield and deposit the number into instance of BankAccount class
 * after depositing the amount, the updated balance will be shown in the label field of the app.
 * @param the event prameter at "handle" method takes the button pressed event as parameter
 * but the handle method returns nothirng
 */
   public class Deposit implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event){

      //Takes user input in text field and uses it as deposit amount
      double amountToDeposit = Double.parseDouble(amount.getText());
      johnDoe.deposit(amountToDeposit);

      //Displays updated balance from BankAccount
      balance.setText("Current Balance: " + johnDoe.getBalance());
    }
  }

/**
 * this is an inner class in BankApp that handles an event when Withdraw button is pressed.
 * it reads the user input from textfield and withdraw the number out of instance of BankAccount class
 * after withdrawing the amount, the updated balance will be shown in the label field of the app.
 * @param the event prameter at "handle" method takes the button pressed event as parameter
 * but the handle method returns nothirng
 */
  public class Withdrawl implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event){

      //Takes user input in the text field and uses it as withdraw amount
      double amountToWithdraw = Double.parseDouble(amount.getText());
      johnDoe.withdraw(amountToWithdraw);

      //Displays updated balance
      balance.setText("Current Balance: " + johnDoe.getBalance());
    }
  }



  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("My Bank");

    BorderPane root = new BorderPane();

    //creates a grid for withdrawl and deposit buttons,
    GridPane buttons = new GridPane();
    buttons.setAlignment(Pos.CENTER);
    buttons.setHgap(5);
    buttons.setVgap(5);

    //creates buttons and adds them to the grid
    Button depositButton = new Button("Deposit");
    depositButton.setOnAction(new Deposit());

    Button withdrawlButton = new Button("Withdrawl");
    withdrawlButton.setOnAction(new Withdrawl());

    buttons.add(depositButton, 0, 0);
    buttons.add(withdrawlButton, 1, 0);

    //places the grid of buttons in the root pane
    root.setBottom(buttons);

    //creates grid for user name and balance
    GridPane accountInfo = new GridPane();
    accountInfo.setAlignment(Pos.CENTER);
    accountInfo.setHgap(5);
    accountInfo.setVgap(5);

    //creates labels for user name and balance, puts them into the grid
    Label userName = new Label("Account Holder: John Doe");
    balance = new Label("Current Balance: " + johnDoe.getBalance());
    accountInfo.add(userName, 0, 0);
    accountInfo.add(balance, 0, 1);

    //places grid of user info in root pane
    root.setTop(accountInfo);

    //creates grid pane for the text box to withdraw or deposit
    GridPane userInput = new GridPane();
    userInput.setAlignment(Pos.CENTER);
    userInput.setHgap(5);
    userInput.setVgap(5);

    //creates text field and label
    amount.setPrefWidth(100);
    Label enterAmount = new Label("Enter an amount: ");

    //adds elements to user input grid
    userInput.add(enterAmount, 1, 1);
    userInput.add(amount, 2, 1);

    //places grid in root pane
    root.setCenter(userInput);

    //shows scene
    Scene scene = new Scene(root, 500, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
