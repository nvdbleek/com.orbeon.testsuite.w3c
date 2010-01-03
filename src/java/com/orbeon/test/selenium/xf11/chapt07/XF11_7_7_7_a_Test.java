
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
 * Tests XForms test suite test 7.7.7.a.xhtml.
 **/
public class XF11_7_7_7_a_Test extends BaseWebTest {

	public void testRandom() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 7.7.7.a random() function",
				selenium.getTitle());

		{
			final double r = Double.parseDouble(selenium.getText("gen-8"));
			assertTrue("random value out of range [0, 1[, value is " + r, r >= 0 && r < 1);
		}
		
		{
			final double r = Double.parseDouble(selenium.getText("gen-11"));
			assertTrue("random value out of range [0, 1[, value is " + r, r >= 0 && r < 1);
		}
		
		{
			final double r = Double.parseDouble(selenium.getText("gen-14"));
			assertTrue("random value out of range [0, 1[, value is " + r, r >= 0 && r < 1);
		}
		
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt07/7.7/7.7.7/7.7.7.a.xhtml";
	}
}
