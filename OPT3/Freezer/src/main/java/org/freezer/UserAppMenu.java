package org.freezer;

import java.util.Scanner;

public class UserAppMenu extends AppMenu{
    private final Scanner scanner = new Scanner(System.in);
    private final Manager manager = new Manager();
    private final PrinterManager printerManager = new PrinterManager();

    public void run() {
        while (true) {
            displayUserMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    manager.displayProductList();
                    break;
                case 2:
                    System.out.println("Sluiten...");
                    return;
                case 3:
                    printProductList();
                    break;
                case 4:
                    sendProductListByEmail();
                    break;
                default:
                    System.out.println("Geen toegangsrechten voor deze optie.");
            }
        }
    }

    private void displayUserMenu() {
        System.out.println("\nUser Menu:");
        System.out.println("1. Product Lijst");
        System.out.println("2. Sluiten");
        System.out.println("-----------------------");
        System.out.println("3. Product Lijst Printen");
        System.out.println("4. Stuur lijst via email");
        System.out.print("Kies een optie: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void printProductList() {
        System.out.println("Lijst wordt uitgeprint...");
        printerManager.printProductList();
    }

    private void sendProductListByEmail() {
        System.out.println("Uw email:");
        String emailAddress = scanner.nextLine();
        manager.sendProductListByEmail(emailAddress);
    }
}
