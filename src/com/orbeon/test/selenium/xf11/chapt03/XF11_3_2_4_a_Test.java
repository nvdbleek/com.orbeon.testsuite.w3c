
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
 * Tests XForms test suite test 3.2.4.a.xhtml.
 **/
public class XF11_3_2_4_a_Test extends BaseWebTest {

	public void test_3_2_4_a() throws Exception {
		openFormURL();
		assertEquals(
				"Orbeon Forms Example Applications - 3.2.4.a node-set binding - nodeset attribute and bind attribute override",
				selenium.getTitle());

		verifyEquals(new String[] {"Audi", "BMW", "Mercedes", "Porsche", "Volkswagen"}, selenium.getSelectOptions("gen-8"));
		
		selenium.addSelection("gen-8", "label=Mercedes");
		verifyEquals(new String[] {"Mercedes"}, selenium.getSelectedLabels("gen-8"));
		selenium.addSelection("gen-8", "label=Audi");
		verifyEquals(new String[] {"Audi", "Mercedes"}, selenium.getSelectedLabels("gen-8"));
	}

	@Override
	public String getFormURL() {
		return getBaseURL()
				+ "/xforms-test-suite/forms/XForms1.1/Edition1/Chapt03/3.2/3.2.4/3.2.4.a.xhtml";
	}
}
