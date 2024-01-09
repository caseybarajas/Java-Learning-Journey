/*
 * Casey
 * breakfast food
 * 9/6/2024
 */

public class Breakfast 
{
  public String type;
  public int amount;
  public boolean isGood;
  public double calAmt;
  public boolean isHealthy;

  public Breakfast(String t, int a, boolean g) 
  {
    this.type = t;
    this.amount = a;
    this.isGood = g;
  }

  public String toString() 
  {
    return "Type: " + this.type + " Amount: " + this.amount + " Is good: " + this.isGood;
  }
}