package math;

class Math {

    public static void main(String[] args) {

    //Use the // to create single line comments to either add info or to take out code for debugging

    System.out.println("Hello world!");

    //We will be using System.out.println and System.out.print throughout the year. Try using both below to see what the difference is!






    //ANSWER:



    //Throughout the year this year we will need to store information. For that we will be using VARIABLES!

    //Java is an Object-Oriented programming language. All variables we use this year will either be OBJECTS or PRIMITIVES

    //There are 8 primitives in Java: int, byte, short, long, float, double, boolean, char

    //For AP we need to know: int, double, boolean

    //List examples of the types below and give definition
    //int (integer):
    //double:
    //boolean:

    //For now we are just going to work with primitive

    //Create 3 variables of each of the above types (USE GOOD CODING PRACTICE WHEN CREATING THE VARIABLES
    int score1 = 100;
    int count = 50;
    int year = 2025;
    // 3 double variables 
    double price = 19.99;
    double temperature = 98.6;
    double pi = 3.14159;
    // 3 booleans
    boolean isActive = true;
    boolean isHungry = false;
    boolean isGood = true;




    //MATH TIME!

    //What are the math operators that we can use?
    //+ - * / %
    int sum = 5+3;
    int difference = 10-4;
    int product = 4*3;
    int quotient = 10/2;


    //Try doing some math operations with numbers. How can we check to see if the math worked?

    //Create codes that weill print the following:

    //Odd integers from 1 to 100, inclusive of both
    for (int i = 1; i <= 100; i++) {
      if (i % 2 != 0) {
        System.out.print(i+ " ");
      }
    }
    




    //All multiples of 3 from 1 to 100
    for (int i = 1; i <= 100; i++) {
      if (i % 3 == 0) {
        System.out.print(i + " ");
      }
    }
    




    //Starting at 1000, print on the same line (with a - [hypthen] between each) all of the numbers that end in 0 going down to 0
   for (int i = 1000; i>=0; i-=10) {
    System.out.print(i);
    if(i>0) {
      System.out.print("-");
    }
   }
   
    
   }
  }
