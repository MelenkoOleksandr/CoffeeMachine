package machine;
import java.util.*;
public class CoffeeMachine {
    private static int amountOfWater = 400;
    private static int  amountOfMilk = 540;
    private static int amountOfBeens = 120;
    private static int disposalCups = 9;
    private static int money = 550;

    public static void machineContent() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water %n%d of milk %n%d of coffee beans %n%d of disposal cups %n%d of money", amountOfWater, amountOfMilk, amountOfBeens, disposalCups, money);
        System.out.println();
    }

    public static void buyCoffee() {
        Scanner scanner = new Scanner(System.in);
        int neededWater = 0;
        int neededMilk = 0;
        int neededCups = 0;
        int neededBeens = 0;
        int moneyToAdd = 0;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffeeType = scanner.next();
        switch (coffeeType) {
            case "1":
                //For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
                neededWater += 250;
                neededBeens += 16;
                moneyToAdd += 4;
                neededCups++;
                break;
            case "2":
                //or the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
                neededWater += 350;
                neededMilk += 75;
                neededBeens += 20;
                neededCups++;
                moneyToAdd += 7;
                break;
            case "3":
                //for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
                neededWater += 200;
                neededMilk += 100;
                neededBeens += 12;
                neededCups++;
                moneyToAdd += 6;
                break;
            case "back":
                return;
        }
        if (amountOfWater - neededWater < 0) {
            System.out.println("Sorry, not enough water!");
        } else if (amountOfMilk - neededMilk < 0 ) {
            System.out.println("Sorry, not enough milk!");
        } else if(amountOfBeens - neededBeens < 0){
            System.out.println("Sorry, not enough beens!");
        } else if (disposalCups - neededCups < 0) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            amountOfWater -= neededWater;
            amountOfMilk -= neededMilk;
            amountOfBeens -= neededBeens;
            disposalCups -= neededCups;
            money += moneyToAdd;
        }
    }

    public static void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add");
        amountOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        amountOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        amountOfBeens += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposalCups += scanner.nextInt();
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.nextLine();
        while (true){
            switch (action) {
                case "buy":
                    buyCoffee();
                    System.out.println();
                    break;
                case "fill":
                    fillMachine();
                    System.out.println();
                    break;
                case "take":
                    takeMoney();
                    System.out.println();
                    break;
                case "remaining":
                    machineContent();
                    System.out.println();
                    break;
                case "exit":
                    return;
            }
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
        }


    }
}
