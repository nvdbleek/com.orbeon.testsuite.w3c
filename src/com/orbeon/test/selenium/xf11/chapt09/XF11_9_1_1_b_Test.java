
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
 * Tests XForms test suite test 9.1.1.b.xhtml.
 **/
public class XF11_9_1_1_b_Test extends BaseWebTest {

	public void test_9_1_1_b() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 9.1.1.b label element in a group element",
				selenium.getTitle());

		assertTrue("Street Name input control under Shipping Address", selenium.isElementPresent("xpath=//*[@id = 'gen-7']//*[@id = 'gen-9']"));
		assertTrue("Street City input control under Shipping Address", selenium.isElementPresent("xpath=//*[@id = 'gen-7']//*[@id = 'gen-11']"));
		
		assertTrue("Street Day input control under Shipping Date", selenium.isElementPresent("xpath=//*[@id = 'gen-13']//*[@id = 'gen-15']"));
		assertTrue("Street Month input control under Shipping Date", selenium.isElementPresent("xpath=//*[@id = 'gen-13']//*[@id = 'gen-17']"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt09/9.1/9.1.1/9.1.1.b.xhtml";
	}
}
