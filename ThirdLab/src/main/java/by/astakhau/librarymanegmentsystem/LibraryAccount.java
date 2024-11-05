package by.astakhau.librarymanegmentsystem;

import java.util.List;

public final class LibraryAccount {
    private String libraryName;
    private List<Book> books;
    private String accountLogin;
    private String accountPassword;
    private List<Notification> notifications;

    public LibraryAccount(String libraryName, List<Book> books, String accountLogin, String accountPassword) {
        this.libraryName = libraryName;
        this.books = books;
        this.accountLogin = accountLogin;
        this.accountPassword = accountPassword;
    }

    public String getLibraryName() {
        return libraryName;
    }

    private void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public boolean authentication(String accountLogin, String accountPassword) {
        return accountLogin.equals(this.accountLogin) && accountPassword.equals(this.accountPassword);
    }

    public void changePassword(String accountLogin, String accountPassword, String newPassword) {
        if (authentication(accountLogin, accountPassword)) {
            setAccountPassword(newPassword);
        }
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addNotifications(Notification notification) {
        if (notifications != null) {
            this.notifications.add(notification);
        }
    }

    public void watchNotification() {
        this.notifications.remove(0);
    }

    public void watchNotifications(Notification notification) {
        this.notifications.clear();
    }
}
