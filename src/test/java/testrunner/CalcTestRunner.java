package testrunner;

import config.SeriesDatasetCSV;
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
    @Test(priority = 1, description = "Checking Sum of two number")
    public void doSum(){
//        CalcScreen calcScreen = new CalcScreen(driver);
//        int res = calcScreen.doSum();
        int res = calcScreen.calculateSum(4,3);
        System.out.println(res);
        Assert.assertEquals(res,7);
    }
    @Test(priority = 2, description = "Checking Subtraction of two number")
    public void doMinus(){;
        int res = calcScreen.calculateMinus(9,8);
        System.out.println(res);
        Assert.assertEquals(res,1);
    }

    @Test(priority = 3, description = "Checking Multiplication of two number")
    public void doMul(){
        int res = calcScreen.calculateMultiplication(5,6);
        System.out.println(res);
        Assert.assertEquals(res,30);
    }

    @Test(priority = 4, description = "Checking Division of two number")
    public void doDiv(){
        int res = calcScreen.calculateDivision(6,2);
        System.out.println(res);
        Assert.assertEquals(res,3);
    }

  @Test(priority = 5,description = "Checking Series calculation")
    public void doSeries(){
        String expression = "100/10*5-10+60";
        String res = calcScreen.calculateSeries(expression);
      Assert.assertEquals(res,"100");

    }

    @Test(priority = 6, dataProvider = "SeriesDatasetCSV", dataProviderClass = SeriesDatasetCSV.class, description = "Checking series calculation from csv")
    public void doSeriesFromCSV(String expression, String expected){
        String res = calcScreen.calculateSeries(expression);

        Assert.assertEquals(res,expected);
        System.out.println(expression+" result= "+res + " expected: "+ expected);
    }

    @AfterMethod
    public void clearScreen(){
//      CalcScreen calcScreen = new CalcScreen(driver);
        calcScreen.btnClear.click();
    }
}
