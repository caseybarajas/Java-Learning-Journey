/*
 * Casey Barajas
 * Cheese.java -> Cheese class to make object array
 * December 6th, 2023
 */
 
 public class Cheese 
 {
    public String type;
    public boolean hasHoles;
    public int numPieces;
    public double price;
    private int age;

    public Cheese()
    {
        //no args constructor
    }

    public Cheese(String t, boolean h, int n, double p)
    {
        //set instance variables = parameters
        type = t;
        hasHoles = h;
        numPieces = n;
        price = p;
    }

    public void setAge(int a)
    {
        age = a;
    }

    public int getAge()
    {
        return age;
    }
 }