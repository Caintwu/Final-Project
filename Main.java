import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
public class Main {
	  JFrame window;
	  Container con;
	  JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	  JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	  Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	  Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 30);
	  Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
	  JButton startButton, choice1, choice2, choice3, choice4, choice5;
	  JTextArea mainTextArea;
	  double total, cost;
	  int weapon;
	  String position;
	  TitleScreenHandler tsHandler = new TitleScreenHandler();
	  ChoiceHandler choiceHandler  = new ChoiceHandler();
	  public static void main(String[] args) {
	    new Main();
	  }
	  public Main(){
	    window = new JFrame();
	    window.setSize(800, 600);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.getContentPane().setBackground(Color.pink);
	    window.setVisible(true);
	    window.setLayout(null);
	    window.setLocationRelativeTo(null);
	    con = window.getContentPane();
	    titleNamePanel = new JPanel();
	    titleNamePanel.setBounds(100, 100, 600, 150);
	    titleNamePanel.setBackground(Color.pink);
	    titleNameLabel = new JLabel("Boba Express");
	    titleNameLabel.setForeground(Color.white);
	    titleNameLabel.setFont(titleFont);
	    startButtonPanel = new JPanel();
	    startButtonPanel.setBounds(300, 400, 200, 100);
	    startButtonPanel.setBackground(Color.white);
	    startButton = new JButton("Order Now!");
	    startButton.setBackground(Color.pink);
	    startButton.setForeground(Color.black);
	    startButton.setFont(startButtonFont);
	    startButton.addActionListener(tsHandler);
	    startButton.setFocusPainted(false);
	   
	    titleNamePanel.add(titleNameLabel);
	    startButtonPanel.add(startButton);
	   
	    con.add(titleNamePanel);
	    con.add(startButtonPanel);
	  }
	  public void createGameScreen() {
	    titleNamePanel.setVisible(false);
	    startButtonPanel.setVisible(false);
	   
	    mainTextPanel = new JPanel();
	    mainTextPanel.setBounds(100, 100, 600, 250);
	    mainTextPanel.setBackground(Color.blue);
	    con.add(mainTextPanel);
	   
	    mainTextArea = new JTextArea("What kind of drink would you like?");
	    mainTextArea.setBounds(100, 100, 600, 250);
	    mainTextArea.setBackground(Color.blue);
	    mainTextArea.setForeground(Color.white);
	    mainTextArea.setFont(normalFont);
	    mainTextArea.setLineWrap(true);
	    mainTextPanel.add(mainTextArea);
	    choiceButtonPanel = new JPanel();
	    choiceButtonPanel.setBounds(250, 350, 300, 150);
	    choiceButtonPanel.setBackground(Color.green);
	    choiceButtonPanel.setLayout(new GridLayout(5,1));
	    con.add(choiceButtonPanel);
	    choice1  = new JButton("Milk Teas");
	    choice1.setBackground(Color.white);
	    choice1.setForeground(Color.black);
	    choice1.setFont(normalFont);
	    choice1.setFocusPainted(false);
	    choice1.addActionListener(choiceHandler);
	    choice1.setActionCommand("c1");
	    choiceButtonPanel.add(choice1);
	    choice2  = new JButton("Slushies");
	    choice2.setBackground(Color.white);
	    choice2.setForeground(Color.black);
	    choice2.setFont(normalFont);
	    choice2.setFocusPainted(false);
	    choice2.addActionListener(choiceHandler);
	    choice2.setActionCommand("c2");
	    choiceButtonPanel.add(choice2);
	    choice3  = new JButton("Regular Teas");
	    choice3.setBackground(Color.white);
	    choice3.setForeground(Color.black);
	    choice3.setFont(normalFont);
	    choice3.setFocusPainted(false);
	    choice3.addActionListener(choiceHandler);
	    choice3.setActionCommand("c3");
	    choiceButtonPanel.add(choice3);
	    choice4  = new JButton("Milk");
	    choice4.setBackground(Color.white);
	    choice4.setForeground(Color.black);
	    choice4.setFont(normalFont);
	    choice4.setFocusPainted(false);
	    choice4.addActionListener(choiceHandler);
	    choice4.setActionCommand("c4");
	    choiceButtonPanel.add(choice4);
	   
	    choice5  = new JButton("Back");
	    choice5.setBackground(Color.white);
	    choice5.setForeground(Color.black);
	    choice5.setFont(normalFont);
	    choice5.setFocusPainted(false);
	    choice5.addActionListener(choiceHandler);
	    choice5.setActionCommand("c5");
	    choiceButtonPanel.add(choice5);
	    playerPanel = new JPanel();
	    playerPanel.setBounds(100, 15, 600, 50);
	    playerPanel.setBackground(Color.orange);
	    playerPanel.setLayout(new GridLayout(1,4));
	    con.add(playerPanel);
	   
	    hpLabel = new JLabel("Cost:");
	    hpLabel.setFont(normalFont);
	    hpLabel.setForeground(Color.white);
	    playerPanel.add(hpLabel);
	   
	    hpLabelNumber = new JLabel("$0.00");
	    hpLabelNumber.setFont(normalFont);
	    hpLabelNumber.setForeground(Color.white);
	    playerPanel.add(hpLabelNumber);
	   
	    weaponLabel = new JLabel("Cart:");
	    weaponLabel.setFont(normalFont);
	    weaponLabel.setForeground(Color.white);
	    playerPanel.add(weaponLabel);
	   
	    weaponLabelName = new JLabel("0");
	    weaponLabelName.setFont(normalFont);
	    weaponLabelName.setForeground(Color.white);
	    playerPanel.add(weaponLabelName);
	    playerSetup();
	  }
	  public void playerSetup(){
	    total = 0.0;
	    weapon = 0;
	    weaponLabelName.setText("" + weapon);
	    hpLabelNumber.setText("" + total);
	    townGate();
	    cost =  5.75;
	  }
	  //generalDrinkOptions
	  public void townGate() {
		  position = "townGate";
		  mainTextArea.setText("What would you like to order?");
		  choice1.setText("Milk Teas");
		  choice2.setText("Slushies");
		  choice3.setText("Regular Teas");
		  choice4.setText("Milks");
		  choice5.setText("Back");
	  }
	  //specificDrinkOptions
	  public void milkTeas() {
		  position = "milkTeas";
		  mainTextArea.setText("Which milk tea would you like?");
		  choice1.setText("Thai tea - $" + cost);
		  choice2.setText("Taro milk tea - $" + cost);
		  choice3.setText("Brown sugar milk tea - $" + cost);
		  choice4.setText("Matcha milk tea latte - $" + cost);
		  choice5.setText("Back");
	  }
	  public void slushies() {
		  position = "slushies";
		  mainTextArea.setText("Which slushie would you like?");
		  choice1.setText("Thai tea slushie - $" + cost);
		  choice2.setText("Taro slushie - $" + cost);
		  choice3.setText("Mango slushie - $" + cost);
		  choice4.setText("Strawberry slushie - $" + cost);
		  choice5.setText("Back");
	  }
	  public void regularTeas() {
		  position = "regularTeas";
		  mainTextArea.setText("Which tea would you like?");
		  choice1.setText("Green tea - $" + cost);
		  choice2.setText("Black tea - $" + cost);
		  choice3.setText("Jasmine tea - $" + cost);
		  choice4.setText("Oolong tea - $" + cost);
		  choice5.setText("Back");
	  }
	  public void milks() {
		  position = "milks";
		  mainTextArea.setText("Which milk would you like?");
		  choice1.setText("Banana milk - $" + cost);
		  choice2.setText("Strawberry milk - $" + cost);
		  choice3.setText("Chocolate milk - $" + cost);
		  choice4.setText("Mango milk - $" + cost);
		  choice5.setText("Back");
	  }
	 
	  //sweetnesslevels
	  public void thaiTea() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void taroTea() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void bsmTea() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void mmtmilk() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void thaiTeaSlushie() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void taroSlushie() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void mangoSlushie() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void strawberrySlushie() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void greenTea() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void blackTea() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void jasmineTea() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void oolongTea() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void bananaMilk() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void strawberryMilk() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void chocolateMilk() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	  public void mangoMilk() {
		  position = "milkTea";
		  mainTextArea.setText("What level of sweetness would you like?");
		  choice1.setText("125%");
		  choice2.setText("100%");
		  choice3.setText("75%");
		  choice4.setText("50%");
		  choice5.setText("Back");
	  }
	 
	  //toppings
	  public void drinkToppings() {
		  position = "toppings";
		  mainTextArea.setText("What drink toppings would you like?");
		  choice1.setText("Boba");
		  choice2.setText("Pudding");
		  choice3.setText("Jelly");
		  choice4.setText("None");
		  choice5.setText("Back");
	  }
	  //takes user back to the beginning
	  public void backToGate() {
		  position = "townGate";
		  mainTextArea.setText("What would you like to order?");
		  choice1.setText("Milk Teas");
		  choice2.setText("Slushies");
		  choice3.setText("Regular Teas");
		  choice4.setText("Milks");
		  choice5.setText("Back");
	  }
	  public void addToCart() {
		 
		  position = "boba";
		  mainTextArea.setText("You're almost there!");
		  choice1.setText("Add to cart");
		  choice2.setText("Continute customizing");
		  choice3.setText("");
		  choice4.setText("");
		  choice5.setText("Back");
		 
	  }
	 
	  public void addToTotal() {
		  String s = JOptionPane.showInputDialog(null, "Please enter your name:");
		  String name = s;
		  position = "total";
		  total+=cost;
		  weapon++;
		  weaponLabelName.setText("" + weapon);
		  hpLabelNumber.setText("" + total);
		  mainTextArea.setText("Thank you for your order, " + name + "!");
		  choice1.setText("Order more?");
		  choice2.setText("No thanks!");
		  choice3.setText("");
		  choice4.setText("");
		  choice5.setText("");
		 
	  }
	  public void close() {
		  playerPanel.setVisible(false);
		  position = "close";
		  mainTextArea.setFont(startButtonFont);
		  mainTextArea.setText("Thank you for using Boba Express!");
		  choice1.setVisible(false);
		  choice2.setVisible(false);
		  choice3.setVisible(false);
		  choice4.setVisible(false);
		  choice5.setVisible(false);
		  choiceButtonPanel.setVisible(false);
	  }
	  public class TitleScreenHandler implements ActionListener{
	    public void actionPerformed(ActionEvent event){
	      createGameScreen();
	    }
	   
	  }
	 
	  public class ChoiceHandler implements ActionListener{
		 
		 public void actionPerformed(ActionEvent event) {
			  String yourChoice = event.getActionCommand();
			 
			  //Drink choices
			  switch(position) {
			  case "townGate":
				  switch(yourChoice) {
				  case "c1": milkTeas(); break;
				  case "c2": slushies(); break;
				  case "c3": regularTeas(); break;
				  case "c4": milks(); break;
				  case "c5": backToGate(); break;
				  }
				  break;
			  //want this to be sweetness levels
			  case "milkTeas":
				  switch(yourChoice) {
				  case "c1": thaiTea(); break;
				  case "c2": taroTea(); break;
				  case "c3": bsmTea(); break;
				  case "c4": mmtmilk(); break;
				  case "c5": backToGate(); break;
				  }
				  break;
				  //want this to be sweetness levels
			  case "slushies":
				  switch(yourChoice) {
				  case "c1": thaiTeaSlushie(); break;
				  case "c2": taroSlushie(); break;
				  case "c3": mangoSlushie(); break;
				  case "c4": strawberrySlushie(); break;
				  case "c5": backToGate(); break;
				  }
				  break;
					  //want this to be sweetness levels
			  case "regularTeas":
				  switch(yourChoice) {
				  case "c1": greenTea(); break;
				  case "c2": blackTea(); break;
				  case "c3": jasmineTea(); break;
				  case "c4": oolongTea(); break;
				  case "c5": backToGate(); break;
				  }
				  break;
						  //want this to be sweetness levels
			  case "milks":
				  switch(yourChoice) {
				  case "c1": bananaMilk(); break;
				  case "c2": strawberryMilk(); break;
				  case "c3": chocolateMilk(); break;
				  case "c4": mangoMilk(); break;
				  case "c5": backToGate(); break;
				  }
				  break;
				  		//want this to be drink toppings
			  case "milkTea":
				  switch(yourChoice) {
				  case "c1": drinkToppings(); break;
				  case "c2": drinkToppings(); break;
				  case "c3": drinkToppings(); break;
				  case "c4": drinkToppings(); break;
				  case "c5": backToGate(); break;
				  }
				  break;
			  case "toppings":
				  switch(yourChoice) {
				  case "c1": addToCart(); break;
				  case "c2": addToCart(); break;
				  case "c3": addToCart(); break;
				  case "c4": addToCart(); break;
				  case "c5": backToGate(); break;
				  }
				  break;
			  case "boba":
				  switch(yourChoice) {
				  case "c1": addToTotal(); break;
				  case "c2": drinkToppings();break;
				  case "c3": break;
				  case "c4": break;
				  case "c5": break;
				  }
				  break;
			  case "total":
				  switch(yourChoice) {
				  case "c1": backToGate(); break;
				  case "c2": close(); break;
				  case "c3": break;
				  case "c4": break;
				  case "c5": break;
				  }
				  break;
			  }
			 
			 
		  }
	  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  }
