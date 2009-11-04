
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
 * Tests XForms test suite test 7.8.4.b.xhtml.
 **/
public class XF11_7_8_4_b_Test extends BaseWebTest {

	public void test_7_8_4_b() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 7.8.4.b hmac() function using sha384 and sha512 (non-normative)",
				selenium.getTitle());

		// Test 1
		assertFalse("Failed test 1", isControlNonRelevant("gen-8"));
		assertTrue("Failed test 1", isControlNonRelevant("gen-10"));
		
		// Test 2
		assertFalse("Failed test 2", isControlNonRelevant("gen-15"));
		assertTrue("Failed test 2", isControlNonRelevant("gen-17"));
		
		// Test 3
		assertFalse("Failed test 3", isControlNonRelevant("gen-22"));
		assertTrue("Failed test 3", isControlNonRelevant("gen-24"));
		
		// Test 4
		assertFalse("Failed test 4", isControlNonRelevant("gen-29"));
		assertTrue("Failed test 4", isControlNonRelevant("gen-31"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt07/7.8/7.8.4/7.8.4.b.xhtml";
	}
}
