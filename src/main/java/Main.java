import drivers.DriverManager;

public class Main {
    public static void main(String[] args) {
        DriverManager dm = new DriverManager("opera");
        dm.loadPage("site_home");
    }
}
