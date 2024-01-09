/*
 * Casey
 * main.java
 */
import java.util.ArrayList;

 public class main   
{
  public static void main(String[] args) 
  {
    ArrayList<Breakfast> mourningFood = new ArrayList<Breakfast>();

    Breakfast omlet = new Breakfast("omlet", 1, true);
    Breakfast cereal = new Breakfast("frosted flakes", 2, true);
    Breakfast bakedBeans = new Breakfast("baked beans", 40, false);

    mourningFood.add(omlet);
    mourningFood.add(cereal);
    mourningFood.add(bakedBeans);

    System.out.println(mourningFood);
    System.out.println(""); //spacing

    Breakfast sausage = new Breakfast("sausage", 2, true);

    mourningFood.add(1, sausage);
    System.out.println(mourningFood);
    System.out.println(""); //spacing
    
    Breakfast toast = new Breakfast("toast", 999, true);
    mourningFood.set(3, toast);
    System.out.println(mourningFood);
    System.out.println(""); //spacing

    System.out.println("my favorite breakfast food is " + mourningFood.get(0).type);
    System.out.println(""); //spacing

    System.out.println("sausage for breakfast? " + mourningFood.contains(sausage));
    System.out.println("baked beans for breakfast? " + mourningFood.contains(bakedBeans));
    System.out.println(""); //spacing

    mourningFood.remove(2);
    System.out.println(mourningFood);
    System.out.println(""); //spacing

    System.out.println("mourningFood is an empty arraylist " + mourningFood.isEmpty());

    System.out.println(""); //spacing

    mourningFood.clear();

    if(!mourningFood.isEmpty())
    {
      System.out.println("mourningFood has " + mourningFood.size() + " items in it");
    }
    else
    {
      System.out.println("mourningFood is empty");
    }
  }
}