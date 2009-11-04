
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

package com.orbeon.test.selenium.xf11.chapt05;

import com.orbeon.test.selenium.BaseWebTest;

/**
 * Tests XForms test suite test 5.1.e.xhtml.
 **/
public class XF11_5_1_e_Test extends BaseWebTest {

	public void testValidValues() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 5.1.e built-in primitive type via xsi:type",
				selenium.getTitle());

		selenium.click("gen-11");
		waitForText("gen-9", "xforms-valid (date)", 5);
	}
	
	public void testInvalidValues() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 5.1.e built-in primitive type via xsi:type",
				selenium.getTitle());
		
		selenium.click("gen-15");
		waitForText("gen-9", "XFORMS-INVALID (date)", 5);
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt05/5.1/5.1.e.xhtml";
	}
}
