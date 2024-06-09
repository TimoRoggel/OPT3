package org.freezer;

public abstract class AppMenu {
    public final void start() {
        displayWelcomeMessage();
        run();
    }

    private void run() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            if (!handleUserChoice(choice)) {
                break;
            }
        }
    }

    protected abstract void displayWelcomeMessage();
    protected abstract void displayMenu();
    protected abstract int getUserChoice();
    protected abstract boolean handleUserChoice(int choice);
}
