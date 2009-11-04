
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

package com.orbeon.test.selenium.xf11.chapt03;

import com.orbeon.test.selenium.BaseWebTest;

/**
 * Tests XForms test suite test 3.3.2.g.xhtml.
 **/
public class XF11_3_3_2_g_Test extends BaseWebTest {

	public void test_3_3_2_g() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms - An Error has Occurred",
				selenium.getTitle());
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt03/3.3/3.3.2/3.3.2.g.xhtml";
	}
}
