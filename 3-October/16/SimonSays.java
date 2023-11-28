/* Casey Barajas
 * SimonSays.java
 * 10/12/23
 */
 
 public class SimonSays
 {
   public static void main(String[] args)
   {
     String simon = "openingact";
     
     //1. print
     System.out.println(simon);
     
     //2. move open to end
     simon += simon.substring(0, 4);  //add open to the end
     simon = simon.substring(4);  //only take from index 4 to end
     System.out.println(simon);

      //3. change "top" to "bottom"
      for(int i = 0; i < simon.length() - 2; i++) //traverse thru simon
      {
        if(simon.substring(i, i+3).equals("top")) //i is index
        {
          simon = simon.substring(0, i) + "bottom" + simon.substring(i+3);
        }
      }
     System.out.println(simon);
     
     //4. change o to i and t to s
     for(int i = 0; i < simon.length(); i++)
     {
       if(simon.substring(i, i+1).equals("o"))  //find o
       {
          simon = simon.substring(0, i) + "i" + simon.substring(i+1); //take before o, put in i, take after o
       }
       else if(simon.substring(i, i+1).equals("t")) //find t
       {
          simon = simon.substring(0, i) + "s" + simon.substring(i+1);
       }
     }
     System.out.println(simon);
     
     //5. exchange pos of 4th and 7th consonants
     int consCnt = 0; //number of consonants
     int cons4Loc = 0;  //location of 4th cons
     String cons4 = ""; //4th consonant
     int cons7Loc = 0;  //location of 7th cons
     String cons7 = ""; //7th consonant
     
     for(int i = 0; i < simon.length(); i++)
     {
       //determine if something is not a vowel
       if(!simon.substring(i, i+1).equals("a") && 
          !simon.substring(i, i+1).equals("e") &&
          !simon.substring(i, i+1).equals("i") &&
          !simon.substring(i, i+1).equals("o") &&
          !simon.substring(i, i+1).equals("u") &&
          !simon.substring(i, i+1).equals(" "))
          {
            consCnt++;
            
            if(consCnt == 4)
            {
              cons4Loc = i;
              cons4 = simon.substring(i, i+1);
            }
            else if(consCnt == 7)
            {
              cons7Loc = i;
              cons7 = simon.substring(i,i+1);
            }
          }
      }
      
      simon = simon.substring(0, cons4Loc) + cons7 +
              simon.substring(cons4Loc+1, cons7Loc) + cons4 +
              simon.substring(cons7Loc+1);
              
      System.out.println(simon);
      
      //6. remove 2nd cons, replace with r. remove 3rd cons, replace with t
      consCnt = 0;  //reset to 0
      
      for(int i = 0; i < simon.length(); i++)
     {
       //determine if something is not a vowel
       if(!simon.substring(i, i+1).equals("a") && 
          !simon.substring(i, i+1).equals("e") &&
          !simon.substring(i, i+1).equals("i") &&
          !simon.substring(i, i+1).equals("o") &&
          !simon.substring(i, i+1).equals("u") &&
          !simon.substring(i, i+1).equals(" "))
          {
            consCnt++;
            
            if(consCnt == 2)
            {
              simon = simon.substring(0, i) + "r" + simon.substring(i+1);
            }
            else if(consCnt == 3)
            {
              simon = simon.substring(0, i) + "t" + simon.substring(i+1);
            }
          }
      }
      
      System.out.println(simon);
      
      //7. exchange pos of a and e
     int aLoc = -1;  //location of a
     int eLoc = -1;  //location of e
     
     for(int i = 0; i < simon.length(); i++)
     {
       //determine if letter is a or e
       if(simon.substring(i,i+1).equals("a"))
       {
         aLoc = i;
       }
       else if(simon.substring(i,i+1).equals("e"))
       {
         eLoc = i;
       }
     }
      
      simon = simon.substring(0, aLoc) + "e" +
              simon.substring(aLoc+1, eLoc) + "a" +
              simon.substring(eLoc+1);
              
      System.out.println(simon);
      
      //8. take out a and b & put o in place
      for(int i = 0; i < simon.length() - 1; i++) //traverse thu simon
      {
        if(simon.substring(i, i+2).equals("ab") ||
           simon.substring(i, i+2).equals("ba"))
          {
            simon = simon.substring(0, i) + "o" + simon.substring(i+2);
          }
      }
      System.out.println(simon);
      
      //9. reverse the order 3rd, 4th and 5th letter
      String third = ""; //3rd letter
      String fourth = ""; //4th letter
      String fifth = ""; //5th letter
      
      for(int i = 0; i < simon.length(); i++)
      
      {
        if(i == 2)
        {
          third = simon.substring(i,i+1);
        }
        else if(i == 3)
        {
          fourth = simon.substring(i,i+1);
        }
        else if(i == 4)
        {
          fifth = simon.substring(i,i+1);
        }
      }
      
      simon = simon.substring(0,2) + fifth + fourth + third + simon.substring(5);
      
      System.out.println(simon);
      
      //10. replace every letter with the letter 2 after it in the alphabet 
      String abc = "abcdefghijklmnopqrstuvwxyz";
      String abc2 = "cdefghijklmnopqrstuvwxyzab";
      int abcIndex = 0; //index of Letter in abc 
      
      for(int i = 0; i < simon.length(); i++)
      {
        abcIndex = abc.indexOf(simon.substring(i,i+1)); 
        //find Loc of letter from simon in abc
        
        simon = simon.substring(0,i) + abc2.substring(abcIndex,abcIndex + 1) +
                simon.substring(i+1);
      }
      System.out.println(simon);
      
      //11. turn u into r and p into a 
       for(int i = 0; i < simon.length(); i++)
     {
       if(simon.substring(i, i+1).equals("u"))  //find o
       {
          simon = simon.substring(0, i) + "r" + simon.substring(i+1); //take before o, put in i, take after o
       }
       else if(simon.substring(i, i+1).equals("p")) //find t
       {
          simon = simon.substring(0, i) + "a" + simon.substring(i+1);
       }
     }
     System.out.println(simon);
     
     //12. exchange 2nd and 3rd letters 
     String letter2 = simon.substring(1,2);
     String letter3 = simon.substring(2,3);
     
     simon = simon.substring(0,1) + letter3 + letter2 + simon.substring(3);
     
     System.out.println(simon);
     
     //13. delete 3rd 4th and 5th constonants 
     consCnt = 0; //reset conCnt
      for(int i = 0; i < simon.length(); i++)
     {
       //determine if something is not a vowel
       if(!simon.substring(i, i+1).equals("a") && 
          !simon.substring(i, i+1).equals("e") &&
          !simon.substring(i, i+1).equals("i") &&
          !simon.substring(i, i+1).equals("o") &&
          !simon.substring(i, i+1).equals("u") &&
          !simon.substring(i, i+1).equals(" "))
          {
            consCnt++;
            
            if(consCnt == 3)
            {
              simon = simon.substring(0,i) + simon.substring(i+1);
              i--;
            }
            else if(consCnt == 4)
            {
              simon = simon.substring(0,i) + simon.substring(i+1);
              i--;
            }
            else if(consCnt == 5)
            {
              simon = simon.substring(0,i) + simon.substring(i+1);
              i--;
            }
          }             
     }
      System.out.println(simon);
      
    //14. chnage the k to a j the q to an i and the o to an h 
    int kCount = 0; //count of ks
    
     for(int i = 0; i < simon.length(); i++)
     {
       if(simon.substring(i, i+1).equals("o"))  //find o
       {
          simon = simon.substring(0, i) + "h" + simon.substring(i+1); //take before o, put in i, take after o
       }
       else if(simon.substring(i, i+1).equals("q")) //find t
       {
          simon = simon.substring(0, i) + "i" + simon.substring(i+1);
       }
       else if(simon.substring(i, i+1).equals("k"))
       {
         kCount++;
         
         if(kCount == 2)
         {
            simon = simon.substring(0, i) + "j" + simon.substring(i+1);
         }
       }
     }
     System.out.println(simon);
     
     //15. move the forth constant 3 places to the right
      consCnt = 0; //reset conCnt
      for(int i = 0; i < simon.length(); i++)
     {
       //determine if something is not a vowel
       if(!simon.substring(i, i+1).equals("a") && 
          !simon.substring(i, i+1).equals("e") &&
          !simon.substring(i, i+1).equals("i") &&
          !simon.substring(i, i+1).equals("o") &&
          !simon.substring(i, i+1).equals("u") &&
          !simon.substring(i, i+1).equals(" "))
          {
            consCnt++;
            
            if(consCnt == 4)
            {
             simon = simon.substring(0,i) + simon.substring(i+1, i+4) +
             simon.substring(i, i+1) + simon.substring(i+4);
            }
          }             
     }
      System.out.println(simon);
      
      //16. add "pe" to the end
      simon += "pe";
      System.out.println(simon);
      
      //17. swap the fourth and fifth letters
     String letter4 = simon.substring(3,4);
     String letter5 = simon.substring(4,5);
     
     simon = simon.substring(0,3) + letter5 + letter4 + simon.substring(5);
     
     System.out.println(simon);
     
     //18. replace every constant with the letter 4 befroe it in the alphabet 
      String abc4 ="wxyzabcdefghijklmnopqrstuv";
      abcIndex = 0; //resest index of letter in abc
      
      for(int i = 0; i < simon.length(); i++)
     {
       //determine if something is not a vowel
       if(!simon.substring(i, i+1).equals("a") && 
          !simon.substring(i, i+1).equals("e") &&
          !simon.substring(i, i+1).equals("i") &&
          !simon.substring(i, i+1).equals("o") &&
          !simon.substring(i, i+1).equals("u") &&
          !simon.substring(i, i+1).equals(" "))
          {
            abcIndex = abc.indexOf(simon.substring(i,i+1)); 
            //find Loc of letter from simon in abc
            
            simon = simon.substring(0,i) + abc4.substring(abcIndex,abcIndex+1) +
                simon.substring(i+1);
          }             
     }
     
     System.out.println(simon);
   }
 }




