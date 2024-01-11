/*
 * Casey Barajas
 * 01/11/2024
 * traversing arraylists
 */
import java.util.ArrayList;
 
 public class TraversingArrayList {
    public static void main(String[] args) 
    {
        ArrayList<String> doughnutz = new ArrayList<String>();

        doughnutz.add("long john");
        doughnutz.add("cruller");
        doughnutz.add("jelly");
        doughnutz.add("boston creme");
        doughnutz.add("munckins");
        doughnutz.add("powdered");
        doughnutz.add("glazed");
        doughnutz.add("cake");
        
        System.out.println("doughnutz: " + doughnutz);
        System.out.println(); //spacing

        for(String s : doughnutz)
        {
            System.out.println(s);
        } 
        System.out.println(); //spacing

        for(int i = 0; i < doughnutz.size(); i++)
        {
            if(doughnutz.get(i).length() > 5)  
            {
                System.out.println(doughnutz.get(i).substring(0 , 4));
            }
        }

        System.out.println(); //spacing

        while()

    }
 }