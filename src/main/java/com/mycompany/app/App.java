/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

/*
Programmed by: Jillian Feld and Evelyn Irwin, with help From Noah Virjee
Last Edited Date:
Program Description:
*/

import java.util.Random;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class App 
{
  static int total = 0;
  static int comTotal = 0;
  static int numPlayers = 0;
  static FileWriter fw;
  static PrintWriter outputFile;
  static ArrayList <Integer> totals = new ArrayList <> ();
  //Evelyn
  // Colours are from
  // https://replit.com/talk/ask/What-are-all-the-color-options/53516
  static String RESET = "\u001B[0m";
  static String BLUE = "\033[0;94m";
  static String PURPLE = "\u001B[35m";
  static String TURQUOISE = "\033[0;36m";
  static String RED = "\u001B[31m";
  static String BLACK = "\033[0;30m";
  static String GREEN = "\u001B[32m";
  public static void main(String[] args) throws IOException{
  Scanner keyboard = new Scanner(System.in);

  // Clear screen
  System.out.print("\033[H\033[2J");

  //Title
  //Ascii font from: https://patorjk.com/software/taag/#p=display&f=ANSI%20Shadow&t=Type%20Something%20
  System.out.println("\n\n██████╗ ██╗      █████╗  ██████╗██╗  ██╗     ██╗ █████╗  ██████╗██╗  ██╗");  
  System.out.println("██╔══██╗██║     ██╔══██╗██╔════╝██║ ██╔╝     ██║██╔══██╗██╔════╝██║ ██╔╝"); 
  System.out.println("██████╔╝██║     ███████║██║     █████╔╝      ██║███████║██║     █████╔╝"); 
  System.out.println("██╔══██╗██║     ██╔══██║██║     ██╔═██╗ ██   ██║██╔══██║██║     ██╔═██╗"); 
  System.out.println("██████╔╝███████╗██║  ██║╚██████╗██║  ██╗╚█████╔╝██║  ██║╚██████╗██║  ██╗"); 
  System.out.println("╚═════╝ ╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝ ╚════╝ ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝"); 

  //Ascii Art
  //Art from this photo:   https://www.shutterstock.com/image-vector/blackjack-card-game-icon-260nw-1365724247.jpg
  //Art from this website:  asciiart.club
  System.out.println("                                       ,▄▄,"); 
  System.out.println("                             ,,▄▄    ▄████████▄▄▄"); 
  System.out.println("                ,,▄▄▄▄▄█████████    ████████████████▄▄▄"); 
  System.out.println("         ,▄████████████████████`   ▐██████████████████████▄▄▄"); 
  System.out.println("        ██████████████████████▌   ╒████████▀   █████████████████▄▄▄"); 
  System.out.println("       j████████▄  ╒█████████▌    ████████,█▌  ███████████████████████▄▄▄"); 
  System.out.println("        █████████▌  █████████    ███████▀▄▄▀   ██████████████████████████████▄,"); 
  System.out.println("        ▐█████████  ████████    ██████▌ ████▌ j█████████████████████████████████"); 
  System.out.println("         █████████  ▐██████`   ▐███████████▄,  █████████████████████████████████▌"); 
  System.out.println("         ███████ ',▄██████▌   ╒█████████████████████████████████████████████████");    
  System.out.println("         ▐███████████████▌    █████████████████████████████████████████████████"); 
  System.out.println("          ███████████████    ███████████████████████▀ ▐███████████████████████▌"); 
  System.out.println("          ██████████████    ███████████████████▀▀'     ▀█████████████████████▌"); 
  System.out.println("          ]████████████`   ▐█████████████▀▀▀            ▀████████████████████"); 
  System.out.println("           ███████████▌   ╒█████████▀▀                   ▀██████████████████"); 
  System.out.println("           ▐█████████▌    ███████▀                        ▀████████████████"); 
  System.out.println("            █████████    ███████▀                           ██████████████▌"); 
  System.out.println("            ████████    ███████▌                             ████████████▌");
  System.out.println("            ▐██████`   ▐███████▌                              ███████████"); 
  System.out.println("             █████▌   ╒█████████                               █████████"); 
  System.out.println("             ▐███▌    ███████████▄                             ▐███████"); 
  System.out.println("              ███    ███████████████▄▄,,,,▄▄                   ███████▌"); 
  System.out.println("              ██    ██████████████████████▀    █,             ▄██████▌"); 
  System.out.println("              ▐`   ▐███████████████▌ '`        ███▄         ▄████████"); 
  System.out.println("                  ╒████████████████▄▄          ██████▄▄▄███████████"); 
  System.out.println("                  ██████████████████████▄▄▄       ▀████████████████");
  System.out.println("                  █████████████████████████████▄▄ ▐███████████████▌");
  System.out.println("                   ▀█████████████████████████████████████████████▌");
  System.out.println("                       ▀▀▀███████████████████████████████████████");      
    
    //Evelyn
      // Menu
    do{
      System.out.println("\n\nMenu\n");
      System.out.println("1)" + TURQUOISE + " Play game" + RESET);
      System.out.println("2)" + PURPLE + " Program Instructions" + RESET);
      System.out.println("3)" + BLUE + " Exit"  + RESET);
      System.out.print("Please enter your selection: ");
      String menuSelection = keyboard.nextLine();

     if (menuSelection.equals("1")) {
       //Reset varaibles
       total = 0; 
       comTotal = 0;
       numPlayers = 0;
       totals.clear();
       
       //Get number of players
       System.out.println("\nPlease enter the number of players: ");
       numPlayers = keyboard.nextInt();

       //Single Player Game
       //Evelyn
       if (numPlayers == 1)
       {
         //Evelyn
         //Draws cards
         System.out.println("You drew the following cards.\n\n");
         randomNumber();
         randomNumber();
  
         //Display user total
         System.out.println("\nYour total is " + total + ".");
  
         //Evelyn
         //Do while loop so it keeps on asking the user if they want to hit again
         String ans;
         do
         {
          System.out.println("\nWould you like to hit? \nPlease answer with \"yes\" or \"no\".");
          ans = keyboard.nextLine();
  
          if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes")){
            randomNumber();
            System.out.println("\nYour total is " + total + " .");
           }
  
          else if(ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no")){
            System.out.println("\nYour total is " + total + " .");
          }
  
          else
          {
            invalidEntry();
          }
         }while (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes") || (!ans.equalsIgnoreCase("no") && !ans.equalsIgnoreCase("n")));
         
       //Run the computers (dealers) hand
       dealerHand();


       //Evelyn
       //Tells the user who won
       //If both the computer and user went bust
       if(total > 21 && comTotal > 21){
         System.out.println("\nBoth the computer and you were bust so nobody won. Good luck next time!");
       }

       //If the person went bust, so the computer won
       else if(total > 21 && comTotal < 21){
         System.out.println("\nUnfortunately, you were bust but the computer wasn't so you lost. Good luck next time!");
       }

       //If the computer went bust, so the user won
       else if (total < 21 && comTotal > 21){
         System.out.println("\nCongratulations, you won! The computer was bust.");
       }

       else{
       int userDiff = 21 - total;
       int comDiff = 21 - comTotal;

         //If the users score is closer to 21 than the computers
        if (userDiff < comDiff){
          System.out.println("\nCongratulations, your score is closer to 21 than the computers. You won!");
        }

        if (userDiff > comDiff){
          System.out.println("\nUnfortunately, you lost. The computers score was closer to 21.");
        }

         if (userDiff == comDiff){
           System.out.println("You and the computer had the same score. It is a tie.");
         }
       }
     }
       }

       //Multiplayer game
       //Jillian
       else if (numPlayers > 1)
       {
         int playerNum = 0;
         do 
         {
           //Reset variables 
           total = 0;

           //Set variables
           playerNum = playerNum + 1;
           
           //Draws cards
           System.out.println("\n\nPlayer " + playerNum + " drew the following cards.\n\n");
           randomNumber();
           randomNumber();
    
           //Display user total
           System.out.println("\nPlayer " + playerNum + ", your total is " + total + ".");
    
           //Do while loop so it keeps on asking the user if they want to hit again
           String ans;
           do
           {
            System.out.println("\nPlayer " + playerNum + ", Would you like to hit? \nPlease answer with \"yes\" or \"no\".");
            ans = keyboard.nextLine();
    
            if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes"))
            {
              randomNumber();
              System.out.println("\nPlayer " + playerNum + ", your total is " + total + ".");
            }
    
            else if(ans.equalsIgnoreCase("n") || ans.equalsIgnoreCase("no"))
            {
              //Add each player's total to arraylist
              totals.add(playerNum - 1, total);
              
              //Display player's total
              System.out.println("\nPlayer " + playerNum + ", your total is " + total + ".");
            }
    
            else
            {
              invalidEntry();
            }
           }while (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("yes") || (!ans.equalsIgnoreCase("no") && !ans.equalsIgnoreCase("n")));
        } while (playerNum < numPlayers);
         
         //Run the dealer's hand
         dealerHand();

         //Add dealer's total to the end of the arrayList
         totals.add(totals.size() -1, comTotal);

         //Determine who won
         
       }


    //Instructions option
    else if (menuSelection.equals("2"))
    {
      instructions();        
    }
      
    //Exit option
    else if (menuSelection.equals("3")){
       System.out.println("Thank you for using this program. Have a good day!");
        System.exit(0);
    }

    else
    {
      invalidEntry();
    }
  }while (true);
}

  //Evelyn
   public static void randomNumber() {
     int value = 0;
     //Random number is created and then the corresponding card is displayed
    Random random = new Random();

    //Generates random a number
int rand = random.nextInt(52);


     //Ensures that the number is not zero
    if (rand == 0){
      rand = rand+1;
    }

      //Playing cards ascii art is from https://www.asciiart.eu/miscellaneous/playing-cards
    //Spades
    //Ace of spades
    if (rand == 1){
   System.out.println("\nYou drew the ace of spades.");
System.out.println("  _______\n |A      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______A|");
      value = 11;
    }

    //King of spades
    if (rand == 2){
      System.out.println("\nYou drew the king of spades.");
System.out.println("  _______\n |K      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______K|");
      value = 10;
    }

    //Queen of spades
    if(rand == 3){
      System.out.println("\nYou drew the queen of spades.");
System.out.println("  _______\n |Q      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______Q|");
      value = 10;
    }

    //Jack of spades
    if(rand == 4){
      System.out.println("\nYou drew the jack of spades.");
System.out.println("  _______\n |J      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______J|");
      value = 10;
    }

    //If they draw a 2-9 of spades
    if (rand > 5 && rand <= 13){
      int numSpades = 15-rand;
      System.out.println("\nYou drew the " + numSpades + " of sapdes.");
      System.out.println("  _______\n |" + numSpades + "      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______" + numSpades + "|");
      value = numSpades;
    }

    //When they draw a 10 of spades
    if (rand == 5){
System.out.println("\nYou drew the 10 of sapdes.");
       System.out.println("  _______\n |10     |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |_____10|");
      value = 10;
    }
     
    //Diamond
    //Ace diamonds
    if (rand == 14){
    System.out.println("\nYou drew the ace of diamonds.");
    System.out.println("  _______\n |A      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______A|");
      value = 11;
    }

    //King of diamonds
if (rand == 15){
    System.out.println("\nYou drew the king of diamonds.");
    System.out.println("  _______\n |K      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______K|");

  value = 10;
    }
    
    //Queen of diamonds
if (rand == 16){
    System.out.println("\nYou drew the queen of diamonds.");
    System.out.println("  _______\n |Q      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______Q|");

  value = 10;
    }
    
    //Jack of diamonds
    if (rand == 17){
    System.out.println("\nYou drew the jack of diamonds.");
    System.out.println("  _______\n |J      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______J|");
      value = 10;
    }

    //If they drew a 2-9 of diamonds
    if (rand > 18 && rand <= 26){
      int numDiamonds = 28-rand;
      System.out.println("\nYou drew the " + numDiamonds + " of diamonds.");
       System.out.println("  _______\n |" + numDiamonds + "      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______" + numDiamonds + "|");
      value = numDiamonds;
    }

    //If they drew the 10 of diamonds
     if (rand == 18){
    System.out.println("\nYou drew the 10 of diamonds.");
    System.out.println("  _______\n |10     |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |_____10|");
      value = 10;
    }
     
    //Clubs
    //Ace of clubs
    if (rand == 27){
    System.out.println("\nYou drew the ace of clubs.");
    System.out.println("  _______ \n |A      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______A|");
      value = 11;
    }

    //King of clubs
 if (rand == 28){
    System.out.println("\nYou drew the king of clubs.");
    System.out.println("  _______ \n |K      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______K|");
   value = 10;
    }
    
    //Queen of clubs
 if (rand == 29){
    System.out.println("\nYou drew the queen of clubs.");
   System.out.println("  _______ \n |Q      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______Q|");
   value = 10;
    }
    
    //Jack of clubs
     if (rand == 30){
    System.out.println("\nYou drew the jack of clubs.");
    System.out.println("  _______ \n |J      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______J|");
       value = 10;
    }

     //If they draw a 2-9 of clubs
    if (rand > 31 && rand <= 39){
      int numClubs = 41-rand;
      System.out.println("\nYou drew the " + numClubs + " of clubs.");
      System.out.println("  _______ \n |" + numClubs + "      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______" + numClubs + "|");
      value = numClubs;
    }
     
      //If they draw a 10 of clubs
      if(rand == 31){
        System.out.println("You drew the 10 of clubs.");
            System.out.println("  _______ \n |10     |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |_____10|");
    value = 10;
      }
     
    
    //Hearts
    //Ace of hearts
    if (rand == 40){
    System.out.println("\nYou drew the ace of hearts.");
    System.out.println("  _______ \n |A      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______A|");
      value = 11;
    }

    //King of hearts
  if (rand == 41){
    System.out.println("\nYou drew the king of hearts.");
     System.out.println("  _______ \n |K      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______K|");
    value = 10;
    }
    
    //Queen of hearts
if (rand == 42){
    System.out.println("\nYou drew the queen of hearts.");
     System.out.println("  _______ \n |Q      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______Q|");
  value = 10;
    }
    
    //Jack of hearts
    if (rand == 43){
    System.out.println("\nYou drew the jack of hearts.");
     System.out.println("  _______ \n |J      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______J|");
      value = 10;
    }

    //If they draw a 2-9 of hearts
    if (rand > 44){
      int numHearts = 54-rand;
      System.out.println("\nYou drew the " + numHearts + " of hearts.");
        System.out.println("  _______ \n |" + numHearts + "      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______" + numHearts + "|");
    value = numHearts;
    }

      //If they draw a 10 of hearts
        if (rand == 44){
    System.out.println("\nYou drew the 10 of hearts.");
     System.out.println("  _______ \n |10     |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |_____10|");
      value = 10;
    }
      
     //Add to total
     total = total + value;
    }

  
  /**
   *Programmed by: Jillian Feld
   *This method provides the user with the program instructions.
   */
  public static void instructions()
  {
    System.out.println("\n\n\nWelcome to BlackJack!");
    System.out.println("Here are your game instructions:");

    //General instructions
    System.out.println(BLUE + "\nGoal of the game: " + RESET + "You want to get as close as possible to 21 points without exceeding 21.");
    System.out.println("Each card in the deck has its own value. Here is a list of each card's values.");
    System.out.println("\t1) Any suit of card with numbers 1-10, is worth that number of points");
    System.out.println("\t2) A jack, queen or king of any suit is worth 10 points");
    System.out.println("\t3) An ace of any suit is worth 11 points");
    
    System.out.println("\nYou will start by selecting either \"Single player game\" or \"Multiplayer game\".");

    //Single player
    System.out.println(TURQUOISE + "\n\nSingle Player Game:" + RESET);
    System.out.println("If you choose to play the single player version of the game, your instructions are as follows. The computer will start by automatically drawing two cards. It will display your current total, and ask you if you would like to hit. If you choose to hit, the computer will draw another card and display your total once again. This process repeats until you decide not to hit. If your total is over 21, you lose.");

    //Multiplayer
    System.out.println(PURPLE + "\n\nMultiplayer Game:" + RESET);
    System.out.println("");
  }//End of instructions method

  /**
   *Programmed by: Jillian Feld
   *This method tells the user they have entered invalid data into the program.
   */
  public static void invalidEntry()
  {
    System.out.println(RED + "\nSorry, that was an invalid input. Please try again." + RESET);
  }//End of invalidEntry method
  

  /**
   *Programmed by: 
   *This method 
   */
  public static void dealerHand()
  {
     //The computers (dealers) hand
     randomNumberDealer();
     randomNumberDealer();
  
     if (comTotal < 15){
       randomNumberDealer();
       System.out.println("\nThe dealers total is " + comTotal + " .");
     }
  
     else
     {
       System.out.println("\nThe dealers total is " + comTotal + " .");
     }
  }//End of dealerHand method

  //Evelyn
   public static void randomNumberDealer() {
     int value = 0;
      //Random number is created and then the corresponding card is displayed
    Random random = new Random();

    //Generates random a number
int rand = random.nextInt(52);

     //Ensures that the number is not zero
    if (rand == 0){
      rand = rand+1;
    }
       //Playing cards ascii art is from https://www.asciiart.eu/miscellaneous/playing-cards
    //Spades
    //Ace of spades
    if (rand == 1){
   System.out.println("\nThe dealer drew the ace of spades.");
System.out.println("  _______\n |A      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______A|");
      value = 11;
    }

    //King of spades
    if (rand == 2){
      System.out.println("\nThe dealer drew the king of spades.");
System.out.println("  _______\n |K      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______K|");
      value = 10;
    }

    //Queen of spades
    if(rand == 3){
      System.out.println("\nThe dealer drew the queen of spades.");
System.out.println("  _______\n |Q      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______Q|");
      value = 10;
    }

    //Jack of spades
    if(rand == 4){
      System.out.println("\nThe dealer drew the jack of spades.");
System.out.println("  _______\n |J      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______J|");
      value = 10;
    }

    //If they draw a 2-9 of spades
    if (rand > 5 && rand <= 13){
      int numSpades = 15-rand;
      System.out.println("\nThe dealer drew the " + numSpades + " of sapdes.");
      System.out.println("  _______\n |" + numSpades + "      |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |______" + numSpades + "|");
      value = numSpades;
    }

    //When they draw a 10 of spades
    if (rand == 5){
System.out.println("\nThe dealer drew the 10 of sapdes.");
       System.out.println("  _______\n |10     |\n |   " + BLACK + "." + RESET + "   |\n | " + BLACK + " /.\\  " + RESET + "|\n |" + BLACK + " (_._) " + RESET + "| \n |" + BLACK + "   |   " + RESET + "|\n" + " |       |\n |_____10|");
      value = 10;
    }
     
    //Diamond
    //Ace diamonds
    if (rand == 14){
    System.out.println("\nThe dealer drew the ace of diamonds.");
    System.out.println("  _______\n |A      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______A|");
      value = 11;
    }

    //King of diamonds
if (rand == 15){
    System.out.println("\nThe dealer drew the king of diamonds.");
    System.out.println("  _______\n |K      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______K|");

  value = 10;
    }
    
    //Queen of diamonds
if (rand == 16){
    System.out.println("\nThe dealer drew the queen of diamonds.");
    System.out.println("  _______\n |Q      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______Q|");

  value = 10;
    }
    
    //Jack of diamonds
    if (rand == 17){
    System.out.println("\nThe dealer drew the jack of diamonds.");
    System.out.println("  _______\n |J      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______J|");
      value = 10;
    }

    //If they drew a 2-9 of diamonds
    if (rand > 18 && rand <= 26){
      int numDiamonds = 28-rand;
      System.out.println("\nThe dealer drew the " + numDiamonds + " of diamonds.");
       System.out.println("  _______\n |" + numDiamonds + "      |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |______" + numDiamonds + "|");
      value = numDiamonds;
    }

    //If they drew the 10 of diamonds
     if (rand == 18){
    System.out.println("\nThe dealer drew the 10 of diamonds.");
    System.out.println("  _______\n |10     |\n |   " + RED + "^" + RESET + "   |\n |" + RED + "  / \\  " + RESET + "|\n |" + RED + "  \\ /  " + RESET + "|\n |  " + RED + " .   " + RESET + "|\n |       |\n |_____10|");
      value = 10;
    }
     
    //Clubs
    //Ace of clubs
    if (rand == 27){
    System.out.println("\nThe dealer drew the ace of clubs.");
    System.out.println("  _______ \n |A      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______A|");
      value = 11;
    }

    //King of clubs
 if (rand == 28){
    System.out.println("\nThe dealer drew the king of clubs.");
    System.out.println("  _______ \n |K      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______K|");
   value = 10;
    }
    
    //Queen of clubs
 if (rand == 29){
    System.out.println("\nThe dealer drew the queen of clubs.");
   System.out.println("  _______ \n |Q      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______Q|");
   value = 10;
    }
    
    //Jack of clubs
     if (rand == 30){
    System.out.println("\nThe dealer drew the jack of clubs.");
    System.out.println("  _______ \n |J      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______J|");
       value = 10;
    }

     //If they draw a 2-9 of clubs
    if (rand > 31 && rand <= 39){
      int numClubs = 41-rand;
      System.out.println("\nThe dealer drew the " + numClubs + " of clubs.");
      System.out.println("  _______ \n |" + numClubs + "      |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |______" + numClubs + "|");
      value = numClubs;
    }
     
      //If they draw a 10 of clubs
      if(rand == 31){
        System.out.println("The dealer drew the 10 of clubs.");
            System.out.println("  _______ \n |10     |\n |   " + BLACK + "_" + RESET + "   |\n |  " + BLACK + "( )" + RESET + "  |\n | " + BLACK + "(_'_)" + RESET + " |\n |   " + BLACK + "|" + RESET + "   |\n |       |\n |_____10|");
    value = 10;
      }
     
    
    //Hearts
    //Ace of hearts
    if (rand == 40){
    System.out.println("\nThe dealer drew the ace of hearts.");
    System.out.println("  _______ \n |A      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______A|");
      value = 11;
    }

    //King of hearts
  if (rand == 41){
    System.out.println("\nThe dealer drew the king of hearts.");
     System.out.println("  _______ \n |K      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______K|");
    value = 10;
    }
    
    //Queen of hearts
if (rand == 42){
    System.out.println("\nThe dealer drew the queen of hearts.");
     System.out.println("  _______ \n |Q      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______Q|");
  value = 10;
    }
    
    //Jack of hearts
    if (rand == 43){
    System.out.println("\nThe dealer drew the jack of hearts.");
     System.out.println("  _______ \n |J      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______J|");
      value = 10;
    }

    //If they draw a 2-9 of hearts
    if (rand > 44){
      int numHearts = 54-rand;
      System.out.println("\nThe dealer drew the " + numHearts + " of hearts.");
        System.out.println("  _______ \n |" + numHearts + "      |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |______" + numHearts + "|");
    value = numHearts;
    }

      //If they draw a 10 of hearts
        if (rand == 44){
    System.out.println("\nThe dealer drew the 10 of hearts.");
     System.out.println("  _______ \n |10     |\n |  " + RED + "_ _" + RESET + "  |\n | " + RED + "( v )" + RESET + " |\n |  " + RED + "\\ /" + RESET + "  |\n |   " + RED + "." + RESET + "   |\n |       |\n |_____10|");
      value = 10;
    }
      
     comTotal = comTotal + value;
   }
   }//End of class Main
