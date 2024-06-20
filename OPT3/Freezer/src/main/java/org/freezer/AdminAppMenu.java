package org.freezer;

import java.util.Scanner;

public class AdminAppMenu extends AppMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final Manager manager = new Manager();
    private final PrinterManager printerManager = new PrinterManager();

    @Override
    protected void displayWelcomeMessage() {
        System.out.println("Welkom bij het Beheerdersmenu!");
    }

    @Override
    protected void displayMenu() {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Voeg Product Toe");
        System.out.println("2. Verwijderen Product");
        System.out.println("3. Product Lijst");
        System.out.println("4. Sluiten");
        System.out.println("-----------------------");
        System.out.println("5. Product Lijst Printen");
        System.out.println("6. Stuur lijst via email");
        System.out.print("Kies een optie: ");
    }

    @Override
    protected int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    @Override
    protected boolean handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                manager.addAndGenerateProduct(scanner);
                break;
            case 2:
                manager.removeProductAndQrCode(scanner);
                break;
            case 3:
                manager.displayProductList();
                break;
            case 4:
                System.out.println("Sluiten...");
                return false;
            case 5:
                printProductList();
                break;
            case 6:
                sendProductListByEmail();
                break;
            default:
                System.out.println("Verkeerde keuze. Probeer opnieuw.");
        }
        return true;
    }

    private void printProductList() {
        System.out.println("Lijst wordt uitgeprint...");
        printerManager.printProductList();
    }

    private void sendProductListByEmail() {
        System.out.println("Uw email:");
        scanner.nextLine(); // clear the buffer
        String emailAddress = scanner.nextLine();
        manager.sendProductListByEmail(emailAddress);
    }
}
