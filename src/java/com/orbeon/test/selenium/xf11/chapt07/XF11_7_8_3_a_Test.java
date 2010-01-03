
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
 * Tests XForms test suite test 7.8.3.a.xhtml.
 **/
public class XF11_7_8_3_a_Test extends BaseWebTest {

	public void testDigestFunction() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 7.8.3.a digest() function using sha1, md5, and sha256",
				selenium.getTitle());

		// Test 1
		assertFalse(isControlNonRelevant("gen-9"));
		assertTrue(isControlNonRelevant("gen-11"));
		
		// Test 2
		assertFalse(isControlNonRelevant("gen-17"));
		assertTrue(isControlNonRelevant("gen-19"));
		
		// Test 3
		assertFalse(isControlNonRelevant("gen-25"));
		assertTrue(isControlNonRelevant("gen-27"));
		
		// Test 4
		assertFalse(isControlNonRelevant("gen-33"));
		assertTrue(isControlNonRelevant("gen-35"));
		
		// Test 5
		assertFalse(isControlNonRelevant("gen-41"));
		assertTrue(isControlNonRelevant("gen-43"));
		
		// Test 6
		assertFalse(isControlNonRelevant("gen-49"));
		assertTrue(isControlNonRelevant("gen-51"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt07/7.8/7.8.3/7.8.3.a.xhtml";
	}
}
