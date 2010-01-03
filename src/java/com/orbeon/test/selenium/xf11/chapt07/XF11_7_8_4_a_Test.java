
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
 * Tests XForms test suite test 7.8.4.a.xhtml.
 **/
public class XF11_7_8_4_a_Test extends BaseWebTest {

	public void test_7_8_4_a() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 7.8.4.a hmac() function using sha1, md5, and sha256",
				selenium.getTitle());

		// Test 1
		assertFalse(isControlNonRelevant("gen-8"));
		assertTrue(isControlNonRelevant("gen-10"));
		
		// Test 2
		assertFalse(isControlNonRelevant("gen-15"));
		assertTrue(isControlNonRelevant("gen-17"));
		
		// Test 3
		assertFalse(isControlNonRelevant("gen-22"));
		assertTrue(isControlNonRelevant("gen-24"));
		
		// Test 4
		assertFalse(isControlNonRelevant("gen-29"));
		assertTrue(isControlNonRelevant("gen-31"));
		
		// Test 5
		assertFalse(isControlNonRelevant("gen-36"));
		assertTrue(isControlNonRelevant("gen-38"));
		
		// Test 6
		assertFalse(isControlNonRelevant("gen-43"));
		assertTrue(isControlNonRelevant("gen-45"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt07/7.8/7.8.4/7.8.4.a.xhtml";
	}
}
