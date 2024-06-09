package org.freezer;

import java.util.Scanner;

public class UserAppMenu extends AppMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final Manager manager = new Manager();
    private final PrinterManager printerManager = new PrinterManager();

    @Override
    protected void displayWelcomeMessage() {
        System.out.println("Welkom bij het Gebruikersmenu!");
    }

    @Override
    protected void displayMenu() {
        System.out.println("\nUser Menu:");
        System.out.println("1. Product Lijst");
        System.out.println("2. Sluiten");
        System.out.println("-----------------------");
        System.out.println("3. Product Lijst Printen");
        System.out.println("4. Stuur lijst via email");
        System.out.print("Kies een optie: ");
    }

    @Override
    protected int getUserChoice() {
        return scanner.nextInt();
    }

    @Override
    protected boolean handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                manager.displayProductList();
                break;
            case 2:
                System.out.println("Sluiten...");
                return false;
            case 3:
                printProductList();
                break;
            case 4:
                sendProductListByEmail();
                break;
            default:
                System.out.println("Geen toegangsrechten voor deze optie.");
        }
        return true;
    }

    private void printProductList() {
        System.out.println("Lijst wordt uitgeprint...");
        printerManager.printProductList();
    }

    private void sendProductListByEmail() {
        System.out.println("Uw email:");
        scanner.nextLine();
        String emailAddress = scanner.nextLine();
        manager.sendProductListByEmail(emailAddress);
    }
}
