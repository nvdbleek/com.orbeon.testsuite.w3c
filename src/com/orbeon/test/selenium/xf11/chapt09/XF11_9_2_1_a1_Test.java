
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
 * Tests XForms test suite test 9.2.1.a1.xhtml.
 **/
public class XF11_9_2_1_a1_Test extends BaseWebTest {

	public void test_9_2_1_a1() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 9.2.1.a1 switch element",
				selenium.getTitle());

		waitForClass("gen-9", "xforms-case-selected", DEFAULT_TRIGGER_WAIT_TIMEOUT);
		waitForClass("edit", "xforms-case-deselected", DEFAULT_TRIGGER_WAIT_TIMEOUT);
		
		selenium.click("xpath=//button[text() = 'Case In']");
		waitForClass("gen-9", "xforms-case-deselected-subsequent", DEFAULT_TRIGGER_WAIT_TIMEOUT);
		waitForClass("edit", "xforms-case-selected", DEFAULT_TRIGGER_WAIT_TIMEOUT);
		
		selenium.click("xpath=//button[text() = 'Case Out']");
		waitForClass("gen-9", "xforms-case-selected", DEFAULT_TRIGGER_WAIT_TIMEOUT);
		waitForClass("edit", "xforms-case-deselected-subsequent", DEFAULT_TRIGGER_WAIT_TIMEOUT);
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt09/9.2/9.2.1/9.2.1.a1.xhtml";
	}
}
