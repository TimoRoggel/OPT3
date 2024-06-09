package org.freezer;

public class GebruikerFactory implements UserFactory {
    @Override
    public UserAppMenu createAppMenu() {
        return new UserAppMenu();
    }
}