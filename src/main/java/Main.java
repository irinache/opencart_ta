import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Main {
    public static void main(String[] args) {
        OperaOptions options = new OperaOptions();
        options.setBinary("E:/Programms/72.0.3815.400/opera.exe");
        System.setProperty("webdriver.opera.driver", "E:/Programms/operadriver_win64/operadriver_win64/operadriver.exe");

        WebDriver driver = new OperaDriver(options);
        driver.get("https://github.com/operasoftware/operachromiumdriver/issues/56");
    }
}
