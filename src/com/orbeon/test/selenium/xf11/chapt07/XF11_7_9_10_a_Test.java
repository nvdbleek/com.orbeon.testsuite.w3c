
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
 * Tests XForms test suite test 7.9.10.a.xhtml.
 **/
public class XF11_7_9_10_a_Test extends BaseWebTest {

	public void test_7_9_10_a() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 7.9.10.a months() function",
				selenium.getTitle());

		assertEquals("14", selenium.getText("gen-8"));
		assertEquals("-19", selenium.getText("gen-13"));
		assertEquals("NaN", selenium.getText("gen-18"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt07/7.9/7.9.10/7.9.10.a.xhtml";
	}
}
