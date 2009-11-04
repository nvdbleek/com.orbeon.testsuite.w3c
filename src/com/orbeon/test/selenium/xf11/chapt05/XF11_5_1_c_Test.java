
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
 * Tests XForms test suite test 5.1.c.xhtml.
 **/
public class XF11_5_1_c_Test extends BaseWebTest {

	public void testValidValues() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 5.1.c supported primitive XML schema types in basic processors",
				selenium.getTitle());

		selenium.click("gen-27");
		waitForText("gen-25·1", "xforms-valid (dateTime)", 5);
		waitForText("gen-25·2", "xforms-valid (time)", 5);
		waitForText("gen-25·3", "xforms-valid (date)", 5);
		waitForText("gen-25·4", "xforms-valid (gYearMonth)", 5);
		waitForText("gen-25·5", "xforms-valid (gYear)", 5);
		waitForText("gen-25·6", "xforms-valid (gMonthDay)", 5);
		waitForText("gen-25·7", "xforms-valid (gDay)", 5);
		waitForText("gen-25·8", "xforms-valid (gMonth)", 5);
		waitForText("gen-25·9", "xforms-valid (string)", 5);
		waitForText("gen-25·10", "xforms-valid (boolean)", 5);
		waitForText("gen-25·11", "xforms-valid (base64Binary)", 5);
		waitForText("gen-25·12", "xforms-valid (decimal)", 5);
		waitForText("gen-25·13", "xforms-valid (anyURI)", 5);
	}
	
	public void testInvalidValues() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 5.1.c supported primitive XML schema types in basic processors",
				selenium.getTitle());
		
		selenium.click("gen-43");
		waitForText("gen-25·1", "XFORMS-INVALID (dateTime)", 5);
		waitForText("gen-25·2", "XFORMS-INVALID (time)", 5);
		waitForText("gen-25·3", "XFORMS-INVALID (date)", 5);
		waitForText("gen-25·4", "XFORMS-INVALID (gYearMonth)", 5);
		waitForText("gen-25·5", "XFORMS-INVALID (gYear)", 5);
		waitForText("gen-25·6", "XFORMS-INVALID (gMonthDay)", 5);
		waitForText("gen-25·7", "XFORMS-INVALID (gDay)", 5);
		waitForText("gen-25·8", "XFORMS-INVALID (gMonth)", 5);
		//waitForText("gen-25·9", "xforms-valid (string)", 5);
		waitForText("gen-25·10", "XFORMS-INVALID (boolean)", 5);
		waitForText("gen-25·11", "XFORMS-INVALID (base64Binary)", 5);
		waitForText("gen-25·12", "XFORMS-INVALID (decimal)", 5);
		waitForText("gen-25·13", "XFORMS-INVALID (anyURI)", 5);
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt05/5.1/5.1.c.xhtml";
	}
}
