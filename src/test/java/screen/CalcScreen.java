package screen;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v138.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static config.Setup.PACKAGE_ID;

public class CalcScreen {
    @FindBy(id=PACKAGE_ID+":id/digit_1")
    WebElement btn_1;
    @FindBy(id=PACKAGE_ID+":id/digit_2")
    WebElement btn_2;
    @FindBy(id=PACKAGE_ID+":id/digit_3")
    WebElement btn_3;
    @FindBy(id=PACKAGE_ID+":id/digit_4")
    WebElement btn_4;
    @FindBy(id=PACKAGE_ID+":id/digit_5")
    WebElement btn_5;
    @FindBy(id=PACKAGE_ID+":id/digit_6")
    WebElement btn_6;
    @FindBy(id=PACKAGE_ID+":id/digit_7")
    WebElement btn_7;
    @FindBy(id=PACKAGE_ID+":id/digit_8")
    WebElement btn_8;
    @FindBy(id=PACKAGE_ID+":id/digit_9")
    WebElement btn_9;
    @FindBy(id=PACKAGE_ID+":id/digit_0")
    WebElement btn_0;

    @FindBy(id=PACKAGE_ID+":id/op_add")
    WebElement btnPlus;
    @FindBy(id=PACKAGE_ID+":id/op_sub")
    WebElement btnMinus;
    @FindBy(id=PACKAGE_ID+":id/op_mul")
    WebElement btnMul;
    @FindBy(id=PACKAGE_ID+":id/op_div")
    WebElement btnDiv;
    @FindBy(id=PACKAGE_ID+":id/const_pi")
    WebElement btnPI;
    @FindBy(id=PACKAGE_ID+":id/op_pow")
    WebElement btnPower;
    @FindBy(id=PACKAGE_ID+":id/op_fact")
    WebElement btnFact;
    @FindBy(id=PACKAGE_ID+":id/clr")
    public WebElement btnClear;

    @FindBy(id=PACKAGE_ID+":id/eq")
    WebElement btnEqual;
    @FindBy(id=PACKAGE_ID+":id/result_final")
    WebElement txtResults;

    AndroidDriver driver;
    public CalcScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public String calculateSeries(String expression) {
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                driver.findElement(By.id(PACKAGE_ID + ":id/digit_" + ch)).click();

            } else if (ch == '+') {
                btnPlus.click();

            } else if (ch == '-') {
                btnMinus.click();

            } else if (ch == '*') {
                btnMul.click();

            } else if (ch == '/') {
                btnDiv.click();

            } else if (ch == '^') {
                    btnPower.click();

            } else if (ch == 'p' && i + 1 < n && expression.charAt(i + 1) == 'i') {
                    btnPI.click();
                    i++;

            } else if (ch == '!') {
                    btnFact.click();

            } else {
                    System.out.println("Unknown char: " + ch);
            }
            }
        btnEqual.click();
        String answer = txtResults.getText().trim().replace(",", "");
        if(answer.contains(".")){
            answer =  String.format("%.2f", Double.parseDouble(answer));
        }
        return answer;
    }


    public int calculateSum(int n1, int n2){
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n1)).click();
//        btn_5.click();
        btnPlus.click();
//        btn_2.click();
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n2)).click();
        btnEqual.click();
        return Integer.parseInt(txtResults.getText());
    }

    public int calculateMinus(int n1, int n2){
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n1)).click();
        btnMinus.click();
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n2)).click();
        btnEqual.click();
        return Integer.parseInt(txtResults.getText());
    }

    public int calculateMultiplication(int n1, int n2){
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n1)).click();
        btnMul.click();
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n2)).click();
        btnEqual.click();
        return Integer.parseInt(txtResults.getText());
    }

    public int calculateDivision(int n1, int n2){
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n1)).click();
        btnDiv.click();
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n2)).click();
        btnEqual.click();
        return Integer.parseInt(txtResults.getText());
    }

}
