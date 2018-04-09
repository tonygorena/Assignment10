/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 * @author tonygorena
 */
public class a10main {

    public static void main(String[] args) {
        int choice;                                  //Choice variable for options
        boolean stop = false;                        //variable to stop program
        Scanner keyboard = new Scanner(System.in);   //Creates scanner for user input

        //User menu
        System.out.println("MENU");
        System.out.println("___________________________________");
        System.out.println("1) INSERT item to BEGINNING of list");
        System.out.println("2) INSERT item in ALPHABETICAL order");
        System.out.println("3) DELETE item from list");
        System.out.println("4) SHOW all items in list");
        System.out.println("5) COUNT total number of items in list");
        System.out.println("6) CLEAR list");
        System.out.println("7) QUIT \n");

        DList userList = new DList();


              //Prompt user for choice

        //Loop until user enter 7 to quit
        while (stop == false) {
            try {
                System.out.print("Enter Choice: ");
                choice = keyboard.nextInt();            //Sets choice to next int entered
                if (choice <= 0 || choice > 7) //reports error if choice is not in range
                {
                    error(-3);
                }


                //insert item to beginning of list
                if (choice == 1) {
                    System.out.print("Enter item to INSERT at BEGINNING: ");

                    String item = keyboard.next();
                    userList.insertBeginning(item);

                }

                //Inserts item in alphabetical order

                if (choice == 2) {
                    System.out.print("Enter item to INSERT in ALPHABETICAL order: ");
                    String item = keyboard.next();

                    userList.insertAlpha(item);

                }

                //Delete an item from list
                if (choice == 3) {
                    System.out.print("Enter item to DELETE: ");
                    String item = keyboard.next();
                    error(userList.remove(item));

                }

                //Print list
                if (choice == 4) {
                    userList.show();

                }

                //Prints the amount of items in list
                if (choice == 5) {
                    System.out.println("There are " + userList.count() + " items in your list");

                }

                //Clear list
                if (choice == 6) {
                    userList.clear();

                }

                //Quit the program
                if (choice == 7) {
                    stop = true;
                }

            } catch (Exception e) {
                error(-3);
                keyboard.next();
            }
        }

    }

    /**
     * Reports errors from program
     *
     * @param error the error value associated with error
     */
    public static void error(int error) {
        if (error == 0) //No error has occured
        {
            return;
        }

        //initialize string and reports unknown error if value is null;
        String errorString = "unknown error";

        //Switch statement to report errors
        switch (error) {
            case -1:
                errorString = "List full";
                break;
            case -2:
                errorString = "List empty";
                break;
            case -3:
                errorString = "Invalid input";
                break;
            case -4:
                errorString = "Item not in list";
                break;

        }
        System.out.println(errorString);            //Prints error message
    }

}
