/**
 * Copyright (C) 2009 Orbeon, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * The full text of the license is available at http://www.gnu.org/copyleft/lesser.html
 */

package com.orbeon.test.selenium.xf11.chapt02;

import com.orbeon.test.selenium.BaseWebTest;

/**
 * Tests XForms test suite test 2.3.a.xhtml.
 **/
public class XF11_2_3_a_Test extends BaseWebTest {

	public void testCreditCard() throws Exception {
		openFormURL();

		assertEquals(
				"Orbeon Forms Example Applications - 2.3.a Example: Value Constraints",
				selenium.getTitle());
		verifyEquals("Cash Credit", selenium.getText("gen-14"));
		assertInputElementPresent("gen-22");
		assertInputElementPresent("gen-24");

		typeTextIntoInput("gen-22", "4012888888881881");
		typeTextIntoInput("gen-24", "2001-08");

		selenium.click("gen-26");
		selenium.waitForPageToLoad(PAGE_LOAD_WAIT);
		assertEquals("Results from echo.sh", selenium.getTitle());
		assertTrue(selenium.isTextPresent("<method>cc</method>"));
		assertTrue(selenium.isTextPresent("<number>4012888888881881</number>"));
		assertTrue(selenium.isTextPresent("<expiry>2001-08</expiry>"));
	}

	public void testCreditCardInvalidExpiration() throws Exception {
		openFormURL();

		assertEquals(
				"Orbeon Forms Example Applications - 2.3.a Example: Value Constraints",
				selenium.getTitle());
		verifyEquals("Cash Credit", selenium.getText("gen-14"));
		assertInputElementPresent("gen-22");
		assertInputElementPresent("gen-24");

		typeTextIntoInput("gen-24", "2001");

		selenium.click("gen-26");

		waitForClass("gen-24", "xforms-invalid", DEFAULT_TRIGGER_WAIT_TIMEOUT);

	}

	public void testCash() throws Exception {
		openFormURL();

		assertEquals(
				"Orbeon Forms Example Applications - 2.3.a Example: Value Constraints",
				selenium.getTitle());

		verifyEquals("Cash Credit", selenium.getText("gen-14"));
		assertInputElementPresent("gen-22");
		assertInputElementPresent("gen-24");

		selenium.select("gen-14", "label=Cash");

		verifyFalse(selenium.isElementPresent("gen-22"));
		verifyFalse(selenium.isElementPresent("gen-24"));

		selenium.click("gen-26");
		selenium.waitForPageToLoad(PAGE_LOAD_WAIT);
		assertEquals("Results from echo.sh", selenium.getTitle());
		assertTrue(selenium.isTextPresent("method=\"cash\">"));
		verifyFalse(selenium.isTextPresent("<number"));
		verifyFalse(selenium.isTextPresent("<expiry"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt02/2.3.a.xhtml";
	}
}
