
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

package com.orbeon.test.selenium.xf11.chapt09;

import com.orbeon.test.selenium.BaseWebTest;

/**
 * Tests XForms test suite test 9.2.3.1.a.xhtml.
 **/
public class XF11_9_2_3_1_a_Test extends BaseWebTest {

	public void test_9_2_3_1_a() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 9.2.3.1.a case element child of the toggle element",
				selenium.getTitle());

		assertClass("inbutton", "xforms-case-selected");
		assertClass("outbutton", "xforms-case-deselected");
		
		selenium.click("inbutton");
		waitForClass("inbutton", "xforms-case-deselected", DEFAULT_TRIGGER_WAIT_TIMEOUT);
		assertClass("outbutton", "xforms-case-selected");
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt09/9.2/9.2.3/9.2.3.1/9.2.3.1.a.xhtml";
	}
}
