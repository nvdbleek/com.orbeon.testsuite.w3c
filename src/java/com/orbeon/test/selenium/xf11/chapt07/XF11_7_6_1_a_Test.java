
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

package com.orbeon.test.selenium.xf11.chapt07;

import com.orbeon.test.selenium.BaseWebTest;

/**
 * Tests XForms test suite test 7.6.1.a.xhtml.
 **/
public class XF11_7_6_1_a_Test extends BaseWebTest {

	public void testBooleanFromStringFunction() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 7.6.1.a boolean-from-string() function",
				selenium.getTitle());

		assertEquals("true", selenium.getText("gen-8"));
		assertEquals("true", selenium.getText("gen-11"));
		assertEquals("true", selenium.getText("gen-14"));
		assertEquals("false", selenium.getText("gen-17"));
		assertEquals("false", selenium.getText("gen-20"));
		assertEquals("false", selenium.getText("gen-23"));
		assertEquals("false", selenium.getText("gen-26"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt07/7.6/7.6.1/7.6.1.a.xhtml";
	}
}
