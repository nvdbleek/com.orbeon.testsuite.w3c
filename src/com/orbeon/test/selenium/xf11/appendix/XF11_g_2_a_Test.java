

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

package com.orbeon.test.selenium.xf11.appendix;

import com.orbeon.test.selenium.BaseWebTest;

/**
 * Tests XForms test suite test g.2.a.xhtml.  
 **/
public class XF11_g_2_a_Test extends BaseWebTest {
    
	public void test_g_2_a() throws Exception {
        openFormURL();        
        assertEquals("Orbeon Forms Example Applications - g.2.a value pseudo-element (non-normative)", selenium.getTitle());
    
        fail("Test not yet implemented");
    }
    
    @Override
	public String getFormURL() {
    	return getBaseURL() + "/xforms-test-suite/forms/XForms1.1/Edition1/Appendix/G/G.2/g.2.a.xhtml"; 
    }
}
    