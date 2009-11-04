
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
 * Tests XForms test suite test 3.3.2.f.xhtml.
 **/
public class XF11_3_3_2_f_Test extends BaseWebTest {

	public void test_3_3_2_f() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 3.3.2.f instance with inline data, resource attribute, and src attribute (non-normative)",
				selenium.getTitle());

		verifyEquals("Suzie", selenium.getText("gen-12"));
		verifyEquals("7", selenium.getText("gen-15"));
		verifyEquals("elementary school", selenium.getText("gen-18"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt03/3.3/3.3.2/3.3.2.f.xhtml";
	}
}
