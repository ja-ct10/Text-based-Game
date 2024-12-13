package consolegame;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ConsoleGame extends Player{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player p = new Player(){};
        
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        
        p.playerName(name);
        
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");
        
        while(true){
            try {
                System.out.print("Enter your choice: ");
                int choices = sc.nextInt();
                
                switch(choices){
                    case 1:
                        p.story();
                        p.start();
                        break;
                    case 2:
                        p.survival();
                        break;
                    default:
                        System.out.println("Invalid input. Enter 1 or 2 only.");
                        continue;
                }
                break;
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number");
                sc.next();
            }
        }
    }
}
