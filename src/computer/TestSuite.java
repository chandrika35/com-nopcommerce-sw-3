package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Computers ']"));
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
       selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
       String expectedText = "Name: Z to A";
       String actualText = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[text()='Name: Z to A']"));
       Assert.assertEquals("Not sorting the elements in  Z to A order.", expectedText, actualText);
    }
    @Test
    public void  verifyProductAddedToShoppingCartSuccessFully() {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Computers ']"));
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//div[@class='product-name']/h1"));
        Assert.assertEquals("Not on Build your own computer page", expectedText, actualText);
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_2']"), "8GB [+$60.00]");
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        clickOnElement(By.xpath("//label[text()='Vista Premium [+$60.00]']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[text()='$1,475.00']"));

        Assert.assertEquals("not $1,475.00", expectedPrice, actualPrice);

        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1'] "));

        String expectedMessage = "The product has been added to your shopping cart";

        String actualMessage = getTextFromElement(By.xpath("//div[@class='bar-notification success']/p"));

        Assert.assertEquals("Not added successfully", expectedMessage, actualMessage);


        clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));

        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        String expectedTextShoppingCart = "Shopping cart";
        String actualTextShoppingCart = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("not on shopping cart", expectedTextShoppingCart, actualTextShoppingCart);
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//td[@class='subtotal']/span[text()='$2,950.00']"));
        Assert.assertEquals("Total not $2,950.00", expectedTotal, actualTotal);
        clickOnElement(By.xpath("//input[@name='termsofservice']"));


        clickOnElement(By.xpath("//button[@name='checkout']"));

        String expectedWelcome = "Welcome, Please Sign In!";

        String actualWelcome = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));


        Assert.assertEquals("Not on sign in page", expectedWelcome, actualWelcome);

        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        sendTextToElement(By.id("BillingNewAddress_FirstName"), "SIta");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Ram");
        sendTextToElement(By.id("BillingNewAddress_Email"), "sitaram123@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");

        sendTextToElement(By.id("BillingNewAddress_Address1"), "123,Cheniesway");

        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "W3 4HL");

        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "023345667");

        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']"));


        clickOnElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        sendTextToElement(By.id("CardholderName"), "MR NO ONE");
        sendTextToElement(By.id("CardNumber"), "5100 0000 0000 0511");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//li[@class='payment-method']/span[@class='value']"));

        Assert.assertEquals("not credit card", expectedPaymentMethod, actualPaymentMethod);

        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));

        Assert.assertEquals("not next day air", expectedShippingMethod, actualShippingMethod);

        String expectedTotalAmount = "$2,950.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("Total amount is not the same as desired.", expectedTotalAmount, actualTotalAmount);


        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        String expectedtText = "Thank you";

        String actualTextThx = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));


        Assert.assertEquals("Text not displayed", expectedText, actualTextThx);

        String expectedSuccessfullyProcessed = "Your order has been successfully processed!";

        String actualSuccessfullyProcessed = getTextFromElement(By.xpath("//div[@class='section order-completed']/div[@class='title']/strong"));

        Assert.assertEquals("Not processed", expectedSuccessfullyProcessed, actualSuccessfullyProcessed);

        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        String expecteText = "Welcome to our store";

        String actualText1= getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2"));

        Assert.assertEquals("Message is not as required.", expectedText, actualText);

    }

    @After
    public void closeBrowser(){
        driver.close();
    }
}
