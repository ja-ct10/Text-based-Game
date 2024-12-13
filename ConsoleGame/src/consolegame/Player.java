package consolegame;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Player implements PlayerInfo, StoryMode, SurvivalMode, StartGame {
    
    private String name;
    private String characterClass;
    private int health;
    private String weapon;
    
    public void playerName(String name){
        this.name = name;
    }
    
    public String showName(){
        return name;
    }
    
    public void CharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }
    
    public String showCharacterClass() {
        return characterClass;
    }

    public void Health(int health) {
        this.health = health;
    }

    public int showHealth() {
        return health;
    }

    public void Weapon(String weapon) {
        this.weapon = weapon;
    }

    public String showWeapon() {
        return weapon;
    }

    public boolean isDefeated() {
        return health <= 0;
    }

     public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
    
    public void story() {
        System.out.println("\nIn the mystical land of Eldoria, a dark shadow has fallen over the kingdom.");
        System.out.println("The sacred gem, a powerful artifact that maintains the balance of light and darkness, has been stolen by the sorcerer named Demonkite.");
        System.out.println("Without the sacred gem, the kingdom is falling into chaos, and the forces of darkness are growing stronger.");
        System.out.println("The village elder Eudora has tasked you with retrieving the sacred gem that will be found in the Forest of Shadows.");
    }
    
    public void survival(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nYou're going to enter the Arsenal.");
        
        while(true){
                System.out.print("Would you like to continue? (Y/N): ");
                String response = sc.nextLine().trim().toUpperCase();
            
                switch(response){
                
                    case "Y":
                        System.out.println("That's great to hear! Start your journey now!");
                        start();
                        return;
                    case "N":
                        System.out.println("\nThank you for your time!");
                        System.out.println("End Game...");
                        return;
                    default:
                        System.out.println("Invalid input. Please respond with 'Y' or 'N'.");
                }
        }
    }
    
    public void start(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nPress P to start playing, " + showName() + ". ");
        
        while (true) {
            char press = sc.next().toUpperCase().charAt(0);
        
            if (press == 'P') {
                break;
            } else {
                System.out.println("Invalid input. Try Again.");
            }
        }
        
        System.out.println("\nWelcome to Tales of Adventure, " + showName() + "!");
        
        while (true) {
            try {
                System.out.println("\nChoose your character class:");
                System.out.println("1. Warrior (Health: 120)");
                System.out.println("2. Mage (Health: 90)");
                System.out.println("3. Archer (Health: 100)");
                System.out.print("Enter your choice: ");
                int classChoice = sc.nextInt();

                switch (classChoice) {
                    case 1:
                        CharacterClass("Warrior");
                        Health(120);
                        break;
                    case 2:
                        CharacterClass("Mage");
                        Health(90);
                        break;
                    case 3:
                        CharacterClass("Archer");
                        Health(100);
                        break;
                    default:
                        System.out.println("Invalid input. Enter 1, 2, or 3 only.");
                        continue;
                }
                System.out.println("\nYou have chosen: " + showCharacterClass());
                break;
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
        
        while(true) {
            try {
                System.out.println("\nChoose your weapon:");
                System.out.println("1. Sword");
                System.out.println("2. Gun");
                System.out.println("3. Crossbow");
                System.out.print("Enter your choice: ");
                int chooseWeapon = sc.nextInt();

                switch (chooseWeapon) {
                    case 1:
                        Weapon("Sword");
                        break;
                    case 2:
                        Weapon("Gun");
                        break;
                    case 3:
                        Weapon("Crossbow");
                        break;
                    default:
                        System.out.println("Invalid input. Enter 1, 2, or 3 only.");
                        continue;
                }
                System.out.println("\nYou have prepared your belongings: ");
                System.out.println("Weapon: " + showWeapon());
                break; 
            } catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
        
        System.out.println("\nYou embark on your journey, traveling through the land of Eldoria.");
        System.out.println("After a while, you finally reach the heart of the Forest of Shadows.");
        System.out.println("\nAs you step into the ruins, you sense a malevolent presence.");
        System.out.println("Suddenly, Demonkite appears before you, his eyes blazing with dark magic.");
        System.out.println("He clutches the sacred gem in his hand, the source of his dark power.");

        int dkHealth = 90;
        
        while (isAlive() && dkHealth > 0) {
            
                while(true) {
                    try {
                        System.out.println("\nYour health: " + showHealth() + " | Demonkite's health: " + dkHealth);
                        System.out.println("What will you do?");
                        System.out.println("1. Attack");
                        System.out.println("2. Run");
                        System.out.print("Enter your choice: ");
                        int choice = sc.nextInt();
                
                        if (choice == 1) {
                            int playerDamage = (int) (Math.random() * 8) + 20; 
                            dkHealth -= playerDamage;
                            System.out.println("\nYou attack Demonkite with your " + showWeapon() + " and deal " + playerDamage + " damage!");
                        
                            if (dkHealth <= 0) {
                                System.out.println("Congratulations! You have defeated Demonkite and retrieved the sacred gem!");
                                break;
                            }
                            
                            int damageTaken = (int) (Math.random() * 18) + 20;
                            takeDamage(damageTaken);
                            System.out.println("Demonkite attacks you and deals " + damageTaken + " damage!");

                            if (isDefeated()) {
                                System.out.println("You have been defeated by Demonkite.");
                                System.out.println("Game Over!");
                                break;
                            }
                        
                        } else if (choice == 2) {
                            System.out.println("\nYou run away, but Demonkite catches you.");
                            System.out.println("Game Over!");
                            return;
                        } else {
                            System.out.println("Invalid input. Enter 1 or 2 only.");
                        }
                    } catch(InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                    }
                }
        }       
    }
}
