package Infra.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends GeneralPage {

    @FindBy(id = "file-upload")
    private WebElement fileUploadInput;

    @FindBy(name = "search")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='product-item'][1]")
    private WebElement productElement;

    @FindBy(xpath = "//button[contains(text(),'Upload')]")
    private WebElement uploadButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void uploadProductImage() {

        String absoluteFilePath = "C:\\Users\\UserName\\Documents\\product_image.jpg";
        wait.until(ExpectedConditions.visibilityOf(fileUploadInput));

        fileUploadInput.sendKeys(absoluteFilePath);
        System.out.println("Uploaded file from: " + absoluteFilePath);

        wait.until(ExpectedConditions.elementToBeClickable(uploadButton)).click();
    }

    public void doSomethingWithProduct() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productElement)).click();
            System.out.println("Product selected: " + productElement.getText());
        } catch (Exception e) {
            System.out.println("Product not found");
        }
    }

    public void processProduct(String productName) {
        searchInput.clear();
        searchInput.sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}
