import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DSETableScraper {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void scrapTableData() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        FileWriter fw = new FileWriter("./src/test/resources/DSE_Share_Prices.txt", true);
        WebElement table = driver.findElements(By.className("table")).get(1);
        List<WebElement> tbody = table.findElements(By.tagName("tbody"));
        int i=0;
        for(WebElement tb :tbody){
            List<WebElement> rows = tb.findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + "\t");
                    fw.write(cell.getText() + "\t");
                }
                System.out.println();
                fw.write("\n");
            }
            i++;
            if(i==30){
                fw.close();
                break;
            }
        }
    }
    @AfterAll
    public void quitDriver(){
        driver.quit();
    }
}
