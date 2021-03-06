package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.CodeProperties;
import com.api.CodePropertiesLookup;
import com.dataprovider.DataProviderClass;


public class TestCSV extends Assert {
	
	@Test(dataProvider="getDataFromCSV",dataProviderClass=DataProviderClass.class)
	public void testCaseCsvIso(String isoCode,String numCode,String fdigit,String name) {
		CodeProperties prop = CodePropertiesLookup.getCodeProperties(isoCode);
		assertEquals(prop.getSymbol(), isoCode);
		assertEquals(prop.getCurrencyCode(), numCode);
		assertEquals(prop.getFractionDigits(), Integer.parseInt(fdigit));
		assertEquals(prop.getCurrencyName(), name);
		
	}
	
	@Test(dataProvider="getDataFromCSV",dataProviderClass=DataProviderClass.class)
	public void testCaseCsvNum(String isoCode,String numCode,String fdigit,String name) {
		CodeProperties prop = CodePropertiesLookup.getCodeProperties(numCode);
		assertEquals(prop.getSymbol(), isoCode);
		assertEquals(prop.getCurrencyCode(), numCode);
		assertEquals(prop.getFractionDigits(), Integer.parseInt(fdigit));
		assertEquals(prop.getCurrencyName(), name);
		
	}

}
