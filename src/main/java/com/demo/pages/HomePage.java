package com.demo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
private WebDriver driver;
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	
	public List<Double> getAllItemPrices(){
		List<WebElement> allPriceElements = driver.findElements(By.xpath("//div[contains(@class,\"inventory_item_price\") and contains(text(),'$') ]"));
		List<Double> allItemPrices = new ArrayList<>();
		for (WebElement priceElement: allPriceElements) {
			double price = Double.parseDouble(priceElement.getText().replace("$", ""));
			allItemPrices.add(price);
		}
		return allItemPrices;
	} 
	
	public WebElement cartButtonForIteWithPrice(Double price) {
		String priceElement = "//div[text()='" + price + "']/following-sibling::button";
		return (driver.findElement(By.xpath(priceElement)));
	}
	

}
