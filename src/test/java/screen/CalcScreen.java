package screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v138.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static config.Setup.PACKAGE_ID;

public class CalcScreen {
    @FindBy(id="com.google.android.calculator:id/digit_1")
    WebElement btn_1;
    @FindBy(id="com.google.android.calculator:id/digit_2")
    WebElement btn_2;
    @FindBy(id="com.google.android.calculator:id/digit_3")
    WebElement btn_3;
    @FindBy(id="com.google.android.calculator:id/digit_4")
    WebElement btn_4;
    @FindBy(id="com.google.android.calculator:id/digit_5")
    WebElement btn_5;
    @FindBy(id="com.google.android.calculator:id/digit_6")
    WebElement btn_6;
    @FindBy(id="com.google.android.calculator:id/digit_7")
    WebElement btn_7;
    @FindBy(id="com.google.android.calculator:id/digit_8")
    WebElement btn_8;
    @FindBy(id="com.google.android.calculator:id/digit_9")
    WebElement btn_9;
    @FindBy(id="com.google.android.calculator:id/digit_0")
    WebElement btn_0;

    @FindBy(id="com.google.android.calculator:id/op_add")
    WebElement btnPlus;
    @FindBy(id="com.google.android.calculator:id/op_sub")
    WebElement btnMinus;
    @FindBy(id="com.google.android.calculator:id/op_mul")
    WebElement btnMul;
    @FindBy(id="com.google.android.calculator:id/op_div")
    WebElement btnDiv;
    @FindBy(id="com.google.android.calculator:id/clr")
    public WebElement btnClear;

    @FindBy(id="com.google.android.calculator:id/eq")
    WebElement btnEqual;
    @FindBy(id="com.google.android.calculator:id/result_final")
    WebElement txtResults;

    AndroidDriver driver;
    public CalcScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public int doSum(int n1, int n2){
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n1)).click();
//        btn_5.click();
        btnPlus.click();
//        btn_2.click();
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n2)).click();
        btnEqual.click();
        return Integer.parseInt(txtResults.getText());
    }

    public int doMinus(int n1, int n2){
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n1)).click();
//        btn_5.click();
        btnMinus.click();
//        btn_2.click();
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n2)).click();
        btnEqual.click();
        return Integer.parseInt(txtResults.getText());
    }

    public int doMultiplication(int n1, int n2){
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n1)).click();
//        btn_5.click();
        btnMul.click();
//        btn_2.click();
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n2)).click();
        btnEqual.click();
        return Integer.parseInt(txtResults.getText());
    }

    public int doDivision(int n1, int n2){
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n1)).click();
//        btn_5.click();
        btnDiv.click();
//        btn_2.click();
        driver.findElement(By.id(PACKAGE_ID+":id/digit_"+n2)).click();
        btnEqual.click();
        return Integer.parseInt(txtResults.getText());
    }

}
