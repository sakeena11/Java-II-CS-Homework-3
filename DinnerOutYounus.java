/**
  * Dinner.Out.java
  * @author Sakeena Younus
  * @description A class that takes the price of a dinner for member of the party and returns each members total cost
  * version 1.0 2022-02-07
  */

  /* Outside resources:
  Worked with William Hernandez on debugging and rounding
  */
import java.util.Scanner;

public class DinnerOutYounus {

  //------attributes------
  private int n; // number of people
  private double tax, tip, amount[]; //array of amounts
  private String people[]; //array of people names

  private Scanner scan = new Scanner(System.in);

  //-----methods-----
  /** constructor */
  public DinnerOutYounus(){}

  /** method that takes in number of individuals attending the party*/
  public void intakeNumOfPeople() {
    System.out.println("How many people are attending the party?");
    n = scan.nextInt();
    scan.nextLine();
    if (n > 6) {
      System.out.println("Sorry, the max number of guests is 6.");
      n = 6;
    } else
    System.out.println("You have " + n + " people attending your party");

    people = new String[n];
    amount = new double[n];
  } //end of intakeNumOfPeople method

  /** method that takes in names of individuals attending the party*/
  public void intakePeopleNames() {
    for (int i = 0; i < n; i++) {
    System.out.println("Enter the name of person " + (i+1) + ".");
    people[i] = scan.nextLine();
    }
  }

  /** method that takes in the amount of the meals*/
  public void intakeAmount() {
      double x;
      for (int i = 0; i < n; i++){
        System.out.println("Enter the cost of " + people[i] + "'s food or enter 0 to move on.");
        x = scan.nextDouble();
        amount[i] += x;

        while (x != 0) {
          System.out.println("Enter the cost of " + people[i] + "'s food or enter 0 to move on.");
          x = scan.nextDouble();
          amount[i] += x;
        } //end of while loop
      } //end of for loop
  } //end of intakeAmount method


  /** method that takes in the rate of the tip and tax*/
  public void intakeTipAndTax(){
    System.out.println("Enter the tax rate as a decimal (ex: for 10% enter 0.10):");
    tax = scan.nextDouble();
    System.out.println("Enter the tip rate as a decimal (ex: for 20% enter 0.20):");
    tip = scan.nextDouble();
  }

  /** method that calculates the total cost for each person*/
  public void totalCost() {
    for (int i = 0; i <n; i++) {
    amount[i] = amount[i] * (tax) * (tip);
    amount[i] = Math.round(amount[i] * 10.0) / 100.0;
    }
  }

  /** prints information of the object */
  public String toString() {
    String s = "";
    for (int i = 0; i < n; i++) {
      s += people[i] + ": $" + amount[i] + "\n";
    }
    return s;

  } //end of toString

  /** main method */
  public static void main(String[] args) {
    DinnerOutYounus party = new DinnerOutYounus();
    party.intakeNumOfPeople();
    party.intakePeopleNames();
    party.intakeAmount();
    party.intakeTipAndTax();
    party.totalCost();
    System.out.println(party);
  } //end of main class

} // end of class
