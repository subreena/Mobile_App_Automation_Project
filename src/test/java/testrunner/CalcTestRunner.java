package testrunner;

import config.Setup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screen.CalcScreen;

public class CalcTestRunner extends Setup {

    CalcScreen calcScreen;
    @BeforeClass
    public void initScreenObject(){
        calcScreen = new CalcScreen(driver);
    }
    @Test(priority = 1, description = "sum of two number")
    public void doSum(){
//        CalcScreen calcScreen = new CalcScreen(driver);
//        int res = calcScreen.doSum();
        int res = calcScreen.doSum(4,3);
        System.out.println(res);
        Assert.assertEquals(res,7);
    }
    @Test(priority = 2, description = "subtraction of two number")
    public void doMinus(){;
        int res = calcScreen.doMinus(4,3);
        System.out.println(res);
        Assert.assertEquals(res,1);
    }

    @Test(priority = 3, description = "Multiplication of two number")
    public void doMul(){
        int res = calcScreen.doMultiplication(5,6);
        System.out.println(res);
        Assert.assertEquals(res,30);
    }

    @Test(priority = 4, description = "Multiplication of two number")
    public void doDiv(){
        int res = calcScreen.doDivision(6,2);
        System.out.println(res);
        Assert.assertEquals(res,3);
    }

    @AfterMethod
    public void clearScreen(){
//        CalcScreen calcScreen = new CalcScreen(driver);
        calcScreen.btnClear.click();
    }
}
