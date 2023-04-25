package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test()
        public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){

        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));

        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/ul[@class='sublist first-level']/li/a[text()='Cell phones ']"));

        String expectedCellPhoneText = "Cell phones";

        String actualCellPhonesText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));

        Assert.assertEquals("not on cell phones tab", expectedCellPhoneText, actualCellPhonesText);
        }
        @Test
        public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
            mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
            mouseHoverAndClickOnElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
            String expectedCellPhoneText = "Cell phones";
            String actualCellPhonesText = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
            Thread.sleep(1000);
            Assert.assertEquals("not on cell phones tab", expectedCellPhoneText, actualCellPhonesText);

            clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));

            Thread.sleep(2000);
            clickOnElement(By.linkText("Nokia Lumia 1020"));

            String expectedNokia = "Nokia Lumia 1020";

            String actualNokia = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/h1[1]"));

            Assert.assertEquals("not on nokia", expectedNokia, actualNokia);

            String expectedNokiaPrice = "$349.00";

            String actualNokiaPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));

            Assert.assertEquals("Nokia price not $349.00", expectedNokiaPrice, actualNokiaPrice);
            driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
            driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");
            clickOnElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));
            String expectedShoppingCartAdd = "The product has been added to your shopping cart";
            String actualShoppingCartAdd = getTextFromElement(By.xpath("//div[@class='bar-notification success']/p"));
            Assert.assertEquals("not added", expectedShoppingCartAdd, actualShoppingCartAdd);

            clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));

            mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
            clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));

            String expectedTextShoppingCart = "Shopping cart";

            String actualTextShoppingCart = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));

            Assert.assertEquals("not on shopping cart", expectedTextShoppingCart, actualTextShoppingCart);

            WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
            String expectedText1 = "2";
            String actualText2 = text.getAttribute("value");
            Assert.assertEquals("not equal", expectedText1, actualText2);
Thread.sleep(1000);
String expectedTotal = "$698.00";
String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
Assert.assertEquals("not $698.00", expectedTotal, actualTotal);
Thread.sleep(1000);
clickOnElement(By.xpath("//input[@id='termsofservice']"));
clickOnElement(By.xpath("//button[@id='checkout']"));
Thread.sleep(1000);
String expectedWelcome = "Welcome, Please Sign In!";
String actualWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
Assert.assertEquals("Not on sign in page", expectedWelcome, actualWelcome);
Thread.sleep(1000);
clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
String expectedRegister = "Register";

String actualRegister = getTextFromElement(By.xpath("//h1[text()='Register']"));

Assert.assertEquals("Not registered", expectedRegister, actualRegister);
Thread.sleep(1000);

sendTextToElement(By.id("FirstName"),"Sita");

sendTextToElement(By.id("LastName"),"Ram");

sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"), "1");

sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"),"2");

sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"),"1999");

sendTextToElement(By.id("Email"),getRandomEmail());

sendTextToElement(By.id("Password"),"abcd123");

sendTextToElement(By.id("ConfirmPassword"),"abcd123");

clickOnElement(By.id("register-button"));

String expectedRegistration = "Your registration completed";

String actualRegistration = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));

Assert.assertEquals("not registered", expectedRegistration, actualRegistration);

clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

String expectedShoppingCart = "Shopping cart";

String actualShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));

Assert.assertEquals("not on shopping cart", expectedTextShoppingCart, actualTextShoppingCart);
Thread.sleep(1000);
clickOnElement(By.xpath("//input[@id='termsofservice']"));
Thread.sleep(1000);
selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
Thread.sleep((1000));
selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Texas");
sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Islington");
sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "111,Craven Road");
sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "W3 5QG");
sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0239845567");
clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
Thread.sleep(1000);
clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
sendTextToElement(By.xpath("//input[@id='CardholderName']"), "SIta Ram");sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1111122233345");
selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "09");
selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2030");
sendTextToElement(By.xpath("//input[@id='CardCode']"), "456");
clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
String expectedCard = "Credit Card";
String actualCard = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
Assert.assertEquals("Not credit card", expectedCard, actualCard);
String expectedShippingMethod = "2nd Day Air";
String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));Assert.assertEquals("not 2nd day air", expectedShippingMethod, actualShippingMethod);String expectedTotalPrice = "$698.00";
String actualTotalPrice = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));Assert.assertEquals("Price not $698.00", expectedTotalPrice, actualTotalPrice);
clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
String expectedMessage14 = "Thank you";
String actualMessage14 = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
Assert.assertEquals(expectedMessage14,actualMessage14);
String expectedMessage15 = "Your order has been successfully processed!";
String actualMessage15 = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
Assert.assertEquals(expectedMessage15,actualMessage15);clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
String expectedMessage16 = "Welcome to our store";
String actualMessage16 = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));

Assert.assertEquals(expectedMessage16,actualMessage16);
clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
String expectedMessage17 = "https://demo.nopcommerce.com/";
String actualMessage17 = driver.getCurrentUrl();
Assert.assertEquals(expectedMessage17,actualMessage17);

        }
    @After
   public void teatDown(){
        closeBrowser();
    }
    }

