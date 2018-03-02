package kirill.smartCore.smartCore.controllers.interactoinWithUser;

public interface IUserInteraction {

    void firstUserGreeting() throws InterruptedException;

    boolean isFirstStart();

    void firstStartSystem() throws InterruptedException;

    void startSystem() throws InterruptedException;

    void userMenu();

}
