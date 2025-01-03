import java.util.Scanner;
import java.util.Random;

public class DetectiveGame extends BaseGame {
    private String detectiveName;
    private Scanner scanner;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public DetectiveGame() {
        super("DetectiveGame");
    }

    @Override
    public void play() {
        scanner = new Scanner(System.in);

        System.out.println(ANSI_GREEN + "Welcome to the New York Detective Game! \n" + ANSI_RESET);
        System.out.print("Enter your detective's name: \n");
        detectiveName = scanner.nextLine();

        System.out.println("Hello, Detective " + detectiveName + ". Let's start your investigation! \n");

        System.out.println("A murder has occurred in Central Park. Where do you want to start your investigation? \n");
        System.out.println(ANSI_GREEN + "1. Visit the crime scene in Central Park" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "2. Go to the victim's home" + ANSI_RESET);
        System.out.println(ANSI_RED + "3. Visit the local police station" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "4. Go investiage on your own" + ANSI_RESET);
        System.out.println("5. Go get coffee first");
        System.out.println("6. Go get food");


        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline character

        switch (choice) {
            case 1:
                visitCrimeScene();
                break;
            case 2:
                visitVictimsHome();
                break;
            case 3:
                visitPoliceStation();
                break;
            case 4:
                goRouge();
                break;
            case 5:
                goGetCoffee();
                break;
            case 6:
                goGetFood();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

        private void visitCrimeScene() {
            System.out.println("You are at the crime scene in Central Park. You find a few clues that might help you solve the case. \n");
            System.out.println("You find a wallet with an" + ANSI_YELLOW + " ID card." + ANSI_RESET + " The name on the ID card is" + ANSI_YELLOW + " 'Holland Virbrainium'.\n" + ANSI_RESET);
            System.out.println("You also find a" + ANSI_YELLOW +" bloody knife" + ANSI_RESET + " near the bushes. \n");
            System.out.println("What would you like to do next? \n");

            System.out.println(ANSI_GREEN + "1. Collect the wallet and knife as evidence" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "2. Take a picture of the crime scene" + ANSI_RESET);
            System.out.println(ANSI_RED + "3. Interview witnesses" + ANSI_RESET);

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline character

            switch (choice) {
                case 1:
                    collectEvidence();
                    break;
                case 2:
                    takePicture();
                    break;
                case 3:
                    interviewWitnesses();
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }

        private void visitVictimsHome() {
            System.out.println("You are at the victim's home. You find a few items that might help you solve the case. \n");
            System.out.println("You find a" + ANSI_YELLOW + " family photo." + ANSI_RESET + " The people in the photo seem to be" + ANSI_YELLOW + " 'Holland Virbrainium' and his family.\n" + ANSI_RESET);
            System.out.println("You also find a" + ANSI_YELLOW +" torn letter" + ANSI_RESET + " in the trash bin. \n");
            System.out.println("What would you like to do next? \n");

            System.out.println(ANSI_GREEN + "1. Collect the photo and letter as evidence" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "2. Search the rest of the house" + ANSI_RESET);
            System.out.println(ANSI_RED + "3. Interview the family members" + ANSI_RESET);

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline character

            switch (choice) {
                case 1:
                    collectEvidence();
                    break;
                case 2:
                    takePicture();
                    break;
                case 3:
                    interviewWitnesses();
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }

    private void visitPoliceStation() {
        System.out.println("You are at the local police station. You meet with the chief of police to discuss the case. \n");
        System.out.println("The chief is wearing a" + ANSI_YELLOW + " green bowler cap" + ANSI_RESET + " and smoking a cigar. \n");
        System.out.println("The chief tells you to stop looking into the case. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println(ANSI_GREEN + "1. Ask the chief why you should stop." + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "2. Leave the police station and drop the case" + ANSI_RESET);

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline character

        switch (choice) {
            case 1:
                questionCheif();
                break;
            case 2:
                leaveStation();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
        
    }

    private void questionCheif() {
        System.out.println("The chief says 'i'd have to kill you' \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1." + ANSI_RED + " Pull out your gun on the chieft" + ANSI_RESET);
        System.out.println("2." + ANSI_RED + " die." + ANSI_RESET);

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                ChiefGun();
                break;
            case 2:
                DeadLOL();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void leaveStation() {
        System.out.println("You hang up your fedora and leave the station \n");
        System.exit(0);
    }

    private void ChiefGun() {
        System.out.println("The chief pulls out his gun before you even can' \n");
        System.out.println("He tells you that its over");
        System.out.println("What would you like to do next? \n");

        System.out.println("1." + ANSI_RED + " Beg for forgiveness" + ANSI_RESET);
        System.out.println("2. Pull out your gun and" + ANSI_RED + " shoot the chief" + ANSI_RESET);

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                DeadLOL();
                break;
            case 2:
                shootChief();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void shootChief() {
        System.out.println("You pull out your gun and shoot the chief \n");
        System.out.println("The chief falls to the ground, dead. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Search the chief's body");
        System.out.println("2. Leave the police station");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                searchOffice();
                break;
            case 2:
                leaveStation();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void searchOffice() {
        System.out.println("You search the chief's body and find a" + ANSI_YELLOW + " letter" + ANSI_RESET + " in his pocket. \n");
        System.out.println("The letter is addressed to" + ANSI_YELLOW + " 'Holland Virbrainium'." + ANSI_RESET + " It says that the chief was involved in a ploy to kill him. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Take this letter as and leave the police station");
        System.out.println("2. Show the letter to the other officers");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                leaveStation();
                break;
            case 2:
                showLetter();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;

        }
    }

    private void showLetter() {
        System.out.println("You show the letter to the other officers. They are shocked to see the contents of the letter. \n");
        System.out.println("The officers decide to" + ANSI_GREEN + " arrest the chief's accomplices" + ANSI_RESET + " and" + ANSI_GREEN + " reopen the case" + ANSI_RESET + " of Holland Virbrainm");
        System.out.println("Congratulations, Detective " + detectiveName + "! You have solved the case and brought the criminals to justice. - good ending \n");
        System.exit(0);
    }

    private void DeadLOL() {
        System.out.println("you died lol - bad ending");
        System.exit(0);
    }

    private void collectEvidence() {
        System.out.println("You collect the evidence and stores it in the evidence bag. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Go to the cheif and show him the evidence");
        System.out.println("2. Continue investigating the crime scene");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                visitPoliceStation();
                break;
            case 2:
                visitCrimeSceneDone();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
        
    }

    private void visitCrimeSceneDone() {
        System.out.println("There is nothing left. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Go to the chief and show him the evidence");
        System.out.println("2. KURT KOBAIN POV");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                visitPoliceStation();
                break;
            case 2:
                DeadLOL();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void takePicture() {
        System.out.println("You take a picture of the crime scene as evidence. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Go to the cheif and show him the evidence");
        System.out.println("2. Continue investigating the crime scene");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                visitPoliceStation();
                break;
            case 2:
                visitCrimeSceneDone();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void interviewWitnesses() {
        System.out.println("You interview the witnesses at the crime scene. \n");
        System.out.println("The witnesses tell you that they saw a man wearing a" + ANSI_YELLOW + " green bowler cap" + ANSI_RESET + " near the crime scene. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Go to the cheif and show him the evidence");
        System.out.println("2. Continue investigating the crime scene");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                visitPoliceStation();
                break;
            case 2:
                visitCrimeSceneDone();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void goRouge() {
        System.out.println("You decide to go rouge and investigate the case on your own. \n");
        System.out.println("You find a" + ANSI_YELLOW + " secret passage" + ANSI_RESET + " in the crime scene that leads to an underground hideout. \n");
        System.out.println("You find a" + ANSI_YELLOW + " secret room" + ANSI_RESET + " with a" + ANSI_YELLOW + " hidden safe" + ANSI_RESET + " inside. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Open the safe");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                openSafe();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void openSafe() {
        System.out.println("You open the safe and find a" + ANSI_YELLOW + " letter" + ANSI_RESET + " inside. \n");
        System.out.println("The letter is addressed to" + ANSI_YELLOW + " 'Holland Virbrainium'." + ANSI_RESET + " It says that the chief of police was involved in a ploy to kill him. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Show the letter to the other officers");
        System.out.println("2. Leave the hideout");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                showLetter();
                break;
            case 2:
                leaveHideout();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void leaveHideout() {
        System.out.println("You leave the hideout and decide to show the letter to the other officers. \n");
        System.out.println("The officers are shocked to see the contents of the letter. \n");
        System.out.println("The officers decide to" + ANSI_GREEN + " arrest the chief's accomplices" + ANSI_RESET + " and" + ANSI_GREEN + " reopen the case" + ANSI_RESET + " of Holland Virbrainium. \n");
        System.out.println("Congratulations, Detective " + detectiveName + "! You have solved the case and brought the criminals to justice. - good ending \n");
        System.exit(0);
    }

    private void goGetCoffee() {
        System.out.println("You decide to go get coffee first before starting your investigation. \n");
        System.out.println("What kind of coffee would you like? \n");

        System.out.println("1. Black coffee");
        System.out.println("2. Latte");
        System.out.println("3. Cappuccino");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                drinkCoffee();
                break;
            case 2:
                drinkCoffee();
                break;
            case 3:
                drinkCoffee();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void drinkCoffee() {
        System.out.println("You drink your coffee and feel refreshed. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Go pay for your coffee and start your investigation");
        System.out.println("2. Go get more coffee");
        System.out.println("3. Walk out without paying");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                visitCrimeScene();
                break;
            case 2:
                drinkCoffee();
                break;
            case 3:
                noPay();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void noPay() {
        System.out.println("You walk out without paying for your coffee. \n");
        System.out.println("A bystander pulls out a gun and shoots you in the knee, rendering you handicapped for life \n");
        System.out.println("You are thrown in jail and the case remains unsolved. - thief ending \n");
        System.exit(0);
    }

    private void goGetFood() {
        System.out.println("You decide to go get food first before starting your investigation. \n");
        System.out.println("What kind of food would you like? \n");

        System.out.println("1. Pizza Hut");
        System.out.println("2. Burger King");
        System.out.println("3. McDonald's");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                eatFood();
                break;
            case 2:
                eatFood();
                break;
            case 3:
                eatFood();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }

    private void eatFood() {
        System.out.println("You eat your food and feel satisfied. \n");
        System.out.println("What would you like to do next? \n");

        System.out.println("1. Go pay for your food and start your investigation");
        System.out.println("2. Go get more food");
        System.out.println("3. Walk out without paying");

        int choice = scanner.nextInt();
        scanner.nextLine(); //consume leftover newline character

        switch (choice) {
            case 1:
                visitCrimeScene();
                break;
            case 2:
                eatFood();
                break;
            case 3:
                noPay();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }
}
