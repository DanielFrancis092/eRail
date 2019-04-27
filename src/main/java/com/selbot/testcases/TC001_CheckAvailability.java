package com.selbot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selbot.pages.erailPage;
import com.selbot.testng.api.base.Annotations;

public class TC001_CheckAvailability extends Annotations{
	
	@BeforeTest
	public void setData() {
		testcaseName = "TC001_CreateLead";
		testcaseDec = "Login, Create Lead and Verify";
		author = "Sarath";
		category = "smoke";
		//excelFileName = "TC001";
	}

	@Test//(dataProvider="fetchData") 
	public void seatAvalability() {
		new erailPage()
		.selectFromStation("MAS")
		.selectToStation("SBC")
		.clickTrainsOnlyOnDate()
		.getTrainAvailability("shatabdi exp");
	}
	
}






