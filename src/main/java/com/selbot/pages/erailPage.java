package com.selbot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selbot.testng.api.base.Annotations;

public class erailPage extends Annotations{
	
	public erailPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="txtStationFrom") WebElement fromStation;
	@FindBy(how=How.ID,using="txtStationTo") WebElement toStation;
	@FindBy(how=How.ID,using="chkSelectDateOnly") WebElement trainsOnlyOnDate;
	@FindBy(how=How.XPATH,using="//table[@class='DataTable TrainList']") WebElement trainResultTable;

	public erailPage selectFromStation(String data) {
		clearTypeAndClickTab(fromStation, data);
		return this;
	}
	
	public erailPage selectToStation(String data) {
		clearTypeAndClickTab(toStation, data);
		return this;
	}
	
	public erailPage clickTrainsOnlyOnDate() {
		if(verifySelected(trainsOnlyOnDate))
			click(trainsOnlyOnDate);
		return this;
	}
	
	public void getTrainAvailability(String trainName)
	{
		List<WebElement> rowElements = trainResultTable.findElements(By.tagName("tr"));
		for (WebElement eachRowElement : rowElements) {
			List<WebElement> columnElements = eachRowElement.findElements(By.tagName("td"));
			if(columnElements.get(1).getText().equalsIgnoreCase(trainName)) {
			for (WebElement eachColumnElements : columnElements) 
				System.out.print(eachColumnElements.getText()+" ");
			break;
			}
		}
	}
	

}
