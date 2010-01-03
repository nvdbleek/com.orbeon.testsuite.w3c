package com.orbeon.test.selenium.xf11.chapt02;

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

import com.orbeon.test.selenium.BaseWebTest;

/**
 * Tests XForms test suite test 2.1.a.xhtml.
 **/
public class XF11_2_1_a_Test extends BaseWebTest {

	public void testCreditCard() throws Exception {
		openFormURL();

		assertEquals(
				"Orbeon Forms Example Applications - 2.1.a Introductory Example No. 1",
				selenium.getTitle());

		verifyEquals("Cash Credit", selenium.getText("gen-8"));
		assertInputElementPresent("gen-17");
		assertInputElementPresent("gen-19");

		typeTextIntoInput("gen-17", "4012888888881881");
		typeTextIntoInput("gen-19", "2001-08");

		selenium.click("gen-21");
		selenium.waitForPageToLoad(PAGE_LOAD_WAIT);
		assertEquals("Results from echo.sh", selenium.getTitle());
		assertTrue(selenium.isTextPresent("<method>cc</method>"));
		assertTrue(selenium.isTextPresent("<number>4012888888881881</number>"));
		assertTrue(selenium.isTextPresent("<expiry>2001-08</expiry>"));
	}

	public void testCash() throws Exception {
		openFormURL();

		assertEquals(
				"Orbeon Forms Example Applications - 2.1.a Introductory Example No. 1",
				selenium.getTitle());

		verifyEquals("Cash Credit", selenium.getText("gen-8"));
		assertInputElementPresent("gen-17");
		assertInputElementPresent("gen-19");

		selenium.select("gen-8", "label=Cash");
		selenium.click("gen-21");
		selenium.waitForPageToLoad(PAGE_LOAD_WAIT);
		assertEquals("Results from echo.sh", selenium.getTitle());
		assertTrue(selenium.isTextPresent("<method>cash</method>"));
		assertTrue(selenium.isTextPresent("<number/>"));
		assertTrue(selenium.isTextPresent("<expiry/>"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt02/2.1.a.xhtml";
	}
}
