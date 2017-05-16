package com.examples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestRemoveCharacter {

	@BeforeTest
	public void setup(){

	}

	@Test (dataProvider = "data")
	public void restRemoveCharApproach1(String strBefore, Character c, String strAfterExpected, boolean flag){

		String strAfterActual ;

		if (strBefore == null || strBefore.equals(""))
			strAfterActual = strBefore;
		else
			strAfterActual = strBefore.replace(Character.toString(c), "");

		
		Assert.assertTrue(strAfterExpected.equals(strAfterActual)) ;
	}

	@Test (dataProvider = "data")
	public void restRemoveCharApproach2(String strBefore, Character c, String strAfterExpected, boolean flag){

		String strAfterActual ;

		if (strBefore == null || strBefore.equals(""))
			strAfterActual = strBefore;
		else{

			StringBuffer tmp = new StringBuffer();

			for (int i=0; i< strBefore.length(); i++ ){

				char x = strBefore.charAt(i);
				if (x != c)
					tmp.append(x);

			}

			strAfterActual = tmp.toString();
		}

		Assert.assertTrue(strAfterExpected.equals(strAfterActual)) ;
	}


	@DataProvider 
	public Object[][] data(){

		Object[][] data = new Object[3][4];

		//Positive Test Case
		data[0][0] ="notebook";
		data[0][1] = new Character ('o');
		data[0][2] = "ntebk";
		data[0][3] = true;

		//Negative Test Case
		data[1][0] ="computer";
		data[1][1] = new Character ('z');
		data[1][2] = "computer";
		data[1][3] = true;
		
		//Negative Test Case
		data[2][0] = "";
		data[2][1] = new Character ('r');
		data[2][2] = "";
		data[2][3] = true;

		return data;

	}

	@AfterTest
	public void tearDown(){

	}

}
