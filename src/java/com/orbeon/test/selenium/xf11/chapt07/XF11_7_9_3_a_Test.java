
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

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.orbeon.test.selenium.BaseWebTest;

/**
 * Tests XForms test suite test 7.9.3.a.xhtml.
 **/
public class XF11_7_9_3_a_Test extends BaseWebTest {

	public void test_7_9_3_a() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 7.9.3.a now() function",
				selenium.getTitle());

		final String dateStr = selenium.getText("gen-7");
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Zulu"));
		final long time = dateFormat.parse(dateStr).getTime();
		assertTrue("Validate time", Math.abs(System.currentTimeMillis() - time) < 5*60*1000); // Check if now() returned a time in 5 minute interval of the current time
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt07/7.9/7.9.3/7.9.3.a.xhtml";
	}
}
