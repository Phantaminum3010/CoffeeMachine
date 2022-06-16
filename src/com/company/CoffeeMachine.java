package com.company;

import java.util.Scanner;

class CoffeeMachine {
    enum State {
        WRITE_ACTION, CHOOSE_COFFEE, SHOW_RESOURCES, ADD_WATER, ADD_MILK, ADD_COFFEE_BEANS, ADD_CUPS, TAKE_MONEY,
        EXIT
    }

    int waterSupply = 400;
    int milkSupply = 540;
    int coffeeBeansSupply = 120;
    int cupsSupply = 9;
    int moneySupply = 550;

    final int waterEspresso = 250;
    final int milkEspresso = 0;
    final int coffeeBeansEspresso = 16;
    final int moneyEspresso = 4;

    final int waterLatte = 350;
    final int milkLatte = 75;
    final int coffeeBeansLatte = 20;
    final int moneyLatte = 7;

    final int waterCappuccino = 200;
    final int milkCappuccino = 100;
    final int coffeeBeansCappuccino = 12;
    final int moneyCappuccino = 6;

    State state;

    public CoffeeMachine() {
        this.state = State.WRITE_ACTION;
    }

    public void processState() {
        switch(this.state) {
            case WRITE_ACTION:
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case CHOOSE_COFFEE:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - " +
                        "to main menu:");
                break;
            case SHOW_RESOURCES:
                System.out.println("The coffee machine has:");
                System.out.println(this.waterSupply + " ml of water");
                System.out.println(this.milkSupply + " ml  of milk");
                System.out.println(this.coffeeBeansSupply + " g of coffee beans");
                System.out.println(this.cupsSupply + " disposable cups");
                System.out.println("$" + moneySupply + " of money");
                System.out.println();
                break;
            case ADD_WATER:
                System.out.println("Write how many ml of water you want to add:");
                break;
            case ADD_MILK:
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case ADD_COFFEE_BEANS:
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case ADD_CUPS:
                System.out.println("Write how many disposable cups of coffee you want to add:");
                break;
            case TAKE_MONEY:
                System.out.println("I gave you $" + this.moneySupply);
                this.moneySupply -= this.moneySupply;
                System.out.println();
                break;
            case EXIT:
                break;
            default:
                System.out.println("Sorry, invalid option");
                break;
        }
    }

    public void processRequest(String input) {
        switch(this.state) {
            case WRITE_ACTION:
                switch(input) {
                    case "buy":
                        this.state = State.CHOOSE_COFFEE;
                        break;
                    case "fill":
                        this.state = State.ADD_WATER;
                        break;
                    case "take":
                        this.state = State.TAKE_MONEY;
                        break;
                    case "remaining":
                        this.state = State.SHOW_RESOURCES;
                        break;
                    case "exit":
                        this.state = State.EXIT;
                        break;
                    default:
                        System.out.println("I'm sorry, your option is not valid!");
                        this.state = State.WRITE_ACTION;
                        break;
                }
                System.out.println();
                break;
            case CHOOSE_COFFEE:
                switch (input) {
                    case "1":
                        if (this.waterSupply < this.waterEspresso) {
                            System.out.println("Sorry, not enough water!");
                        } else if (this.milkSupply < this.milkEspresso) {
                            System.out.println("Sorry, not enough milk!");
                        } else if (this.coffeeBeansSupply < this.coffeeBeansEspresso) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (this.cupsSupply < 1) {
                            System.out.println("Sorry, not enough cups!");
                        } else {
                            this.waterSupply -= this.waterEspresso;
                            this.milkSupply -= this.milkEspresso;
                            this.coffeeBeansSupply -= this.coffeeBeansEspresso;
                            this.moneySupply += this.moneyEspresso;
                            this.cupsSupply -= 1;
                            System.out.println("I have enough resources, making you a coffee!");
                        }
                        break;
                    case "2":
                        if (this.waterSupply < this.waterLatte) {
                            System.out.println("Sorry, not enough water!");
                        } else if (this.milkSupply < this.milkLatte) {
                            System.out.println("Sorry, not enough milk!");
                        } else if (this.coffeeBeansSupply < this.coffeeBeansLatte) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (this.cupsSupply < 1) {
                            System.out.println("Sorry, not enough cups!");
                        } else {
                            this.waterSupply -= this.waterLatte;
                            this.milkSupply -= this.milkLatte;
                            this.coffeeBeansSupply -= this.coffeeBeansLatte;
                            this.moneySupply += this.moneyLatte;
                            this.cupsSupply -= 1;
                            System.out.println("I have enough resources, making you a coffee!");
                        }
                        break;
                    case "3":
                        if (this.waterSupply < this.waterCappuccino) {
                            System.out.println("Sorry, not enough water!");
                        } else if (this.milkSupply < this.milkCappuccino) {
                            System.out.println("Sorry, not enough milk!");
                        } else if (this.coffeeBeansSupply < this.coffeeBeansCappuccino) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (this.cupsSupply < 1) {
                            System.out.println("Sorry, not enough cups!");
                        } else {
                            this.waterSupply -= this.waterCappuccino;
                            this.milkSupply -= this.milkCappuccino;
                            this.coffeeBeansSupply -= this.coffeeBeansCappuccino;
                            this.moneySupply += this.moneyCappuccino;
                            this.cupsSupply -= 1;
                            System.out.println("I have enough resources, making you a coffee!");
                        }
                        break;
                    case "back":
                        break;
                    default:
                        System.out.println("Not a valid option, please try again");
                        break;

                }
                System.out.println();
                this.state = State.WRITE_ACTION;
                break;
            case ADD_WATER:
                waterSupply += Integer.parseInt(input);
                this.state = State.ADD_MILK;
                break;
            case ADD_MILK:
                milkSupply += Integer.parseInt(input);
                this.state = State.ADD_COFFEE_BEANS;
                break;
            case ADD_COFFEE_BEANS:
                coffeeBeansSupply += Integer.parseInt(input);
                this.state = State.ADD_CUPS;
                break;
            case ADD_CUPS:
                cupsSupply += Integer.parseInt(input);
                System.out.println();
                this.state = State.WRITE_ACTION;
                break;
            default:
                break;

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        while (coffeeMachine.state != State.EXIT) {
            coffeeMachine.processState();
            State currentState = coffeeMachine.state;
            if (currentState != State.SHOW_RESOURCES && currentState != State.TAKE_MONEY) {
                coffeeMachine.processRequest(scanner.next());
            } else {
                coffeeMachine.state = State.WRITE_ACTION;
            }
        }
    }

}