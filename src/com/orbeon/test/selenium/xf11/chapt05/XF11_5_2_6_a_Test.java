
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
 * Tests XForms test suite test 5.2.6.a.xhtml.
 **/
public class XF11_5_2_6_a_Test extends BaseWebTest {

	public void testValidEMailAddresses() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 5.2.6.a email datatype",
				selenium.getTitle());

		selenium.click("gen-12");
		assertEquals("You entered a valid email", selenium.getAlert()); // Doesn't work, we need yui alert... to check
		
		selenium.click("gen-15");
		assertEquals("You entered a valid email", selenium.getAlert()); // Doesn't work, we need yui alert... to check
	}

	public void testInvalidEMailAddresses() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 5.2.6.a email datatype",
				selenium.getTitle());
		
		selenium.click("gen-18");
		assertEquals("You entered a invalid email", selenium.getAlert()); // Doesn't work, we need yui alert... to check
		
		selenium.click("gen-21");
		assertEquals("You entered a invalid email", selenium.getAlert()); // Doesn't work, we need yui alert... to check
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt05/5.2/5.2.6/5.2.6.a.xhtml";
	}
}
