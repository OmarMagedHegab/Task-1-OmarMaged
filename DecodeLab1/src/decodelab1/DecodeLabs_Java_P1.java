/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package decodelab1;
import java.util.*;

/**
 *
 * @author engom
 */
public class DecodeLabs_Java_P1 {

    
    public static void main(String[] args) {
       Scanner scan= new Scanner(System.in);
       Random random= new Random();
       int min=1;
       int max= 100;
       int score = 0; 
       String playAgain;
       do{
       int randomNum= random.nextInt(max-min+1)+min;
       int guess=0;
       boolean isWinner = false;
        System.out.println("\n--- NEW ROUND ---");
        System.out.println("Current Score: " + score);
        System.out.println("You have maximum of 3 attempts to guess a number from 1 to 100");
        for(int i=0; i<3; i++){
            System.out.println("enter guess number " + (i+1) +":");
            try{
                guess= scan.nextInt();
            } catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter a whole number");
                scan.nextLine();
                i--;
                continue;
            }
            if(guess< 1 || guess>100){
                System.out.println("your guess is out of range! Please pick a number from 1 to 100");
                i--;
                continue;
            }
            else if (guess<randomNum && i!= 2)
                System.out.println("You guess is too low, try again!");
            else if (guess>randomNum && i!= 2)
                System.out.println("Your guess is too high, try again!");
            else if(guess==randomNum){
                isWinner= true;
                break;
            }
                           
        }
        if (isWinner){
            System.out.println("Great job! Your guess is correct");
            score++;
        }
        else
            System.out.println("Hard Luck! The correct answer is "+ randomNum);
        scan.nextLine();
        System.out.println("\nPlay Again? [Y/N]: ");
        playAgain= scan.nextLine();
       }while(playAgain.equalsIgnoreCase("Y"));
        System.out.println("Thanks for playing! Your score is: "+ score);
        scan.close();  
    }
}
