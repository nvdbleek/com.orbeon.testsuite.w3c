package com.orbeon.test.selenium;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;


/**
 * 
 */
public abstract class BaseWebTest extends SeleneseTestCase {
	public static final String PAGE_LOAD_WAIT = "30000";
	public static final int DEFAULT_TRIGGER_WAIT_TIMEOUT = 5;

    protected Selenium selenium;
    protected String speed = "10";

    /**
     * 
     * @throws Exception
     */
    public void setUp() throws Exception {

        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8080");
        selenium.start();
        selenium.setSpeed(speed);
    }


    public void tearDown() throws Exception {
        selenium.stop();
        selenium = null;
    }

    public abstract String getFormURL();
    
    protected String getBaseURL() {
    	return "http://localhost:8080/orbeon-N20091029";
    }
    
    protected void openFormURL() {
		final String formURL = getFormURL();
        if (formURL == null) {
        	fail("formURL must not be null");
        }
        
        System.out.println("Open: " + formURL);
        selenium.open(formURL);
	}
    
    /**
     * Generates a partial xpath expression that matches an element whose 'class' attribute
     * contains the given CSS className. So to match &lt;div class='foo bar'&gt; you would
     * say "//div[" + containingClass("foo") + "]".
     *
     * @param className CSS class name
     * @return XPath fragment
     */
    protected static String containingClass(String className) {
      return "contains(concat(' ',normalize-space(@class),' '),' " + className + " ')";
    }
    
    public void typeTextIntoInput(String controlId, String text) {
    	selenium.type(controlId + "$xforms-input-1", text);
    }

    
    /**
     * 
     * @param controlId
     * @param expectedValue
     * @param timeoutinSeconds
     * @throws InterruptedException
     */
    protected void waitForVisibleText(String controlId, String expectedValue, int timeoutinSeconds) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= timeoutinSeconds)
                fail("waiting for text ('" + controlId + "') timed out after " + timeoutinSeconds + ", expected value was '" + expectedValue + "'");
            try {
                if (expectedValue.equals(selenium.getText(controlId))) {
                    if (selenium.isVisible(controlId)) {
                        break;
                    }
                }
            } catch (Exception e) {                
            }
            Thread.sleep(1000);
        }

    }

    /**
     * 
     * 
     * @param controlId
     * @param expectedValue
     * @param timeoutinSeconds
     * @throws InterruptedException
     */
    protected void waitForValue(String controlId, String expectedValue, int timeoutinSeconds) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= timeoutinSeconds)
                fail("waiting for value ('" + controlId + "') timed out after " + timeoutinSeconds + ", expected value was '" + expectedValue + "'");
            try {
                if (expectedValue.equals(selenium.getValue(controlId)))
                    break;
            } catch (Exception e) {            
            }
            Thread.sleep(1000);
        }

    }

    /**
     * 
     * 
     * @param controlId
     * @param expectedValue
     * @param timeoutinSeconds
     * @throws InterruptedException
     */
    protected void waitForText(String controlId, String expectedValue, int timeoutinSeconds) throws InterruptedException {
    	for (int second = 0; ; second++) {
    		if (second >= timeoutinSeconds)
    			fail("waiting for value ('" + controlId + "') timed out after " + timeoutinSeconds + ", expected value was '" + expectedValue + "'");
    		try {
    			if (expectedValue.equals(selenium.getText(controlId)))
    				break;
    		} catch (Exception e) {            
    		}
    		Thread.sleep(1000);
    	}
    	
    }
    
    /**
     * 
     * 
     * @param controlId
     * @param expectedValue
     * @param timeoutinSeconds
     * @throws InterruptedException
     */
    protected void waitForClass(String controlId, String expectedClass, int timeoutinSeconds) throws InterruptedException {
    	for (int second = 0; ; second++) {
    		if (second >= timeoutinSeconds)
    			fail("waiting for value ('" + controlId + "') timed out after " + timeoutinSeconds + ", expected class was '" + expectedClass + "'");
    		try {
    			if (selenium.isElementPresent("xpath=//*[@id = '" + controlId + "' and "
						+ containingClass(expectedClass) + "]"))
    				break;
    		} catch (Exception e) {            
    		}
    		Thread.sleep(1000);
    	}
    	
    }
    
    protected void assertInputElementPresent(String controlId) {
    	assertClass(controlId, "xforms-input");
    }
    
    protected String getLabelOfOutput(String controlId) {
    	return selenium.getText(controlId + "$$l");
    }
    
    protected void assertControlIsReadOnly(String controlId) {
    	assertTrue(isControlReadOnly(controlId));
    }


	protected boolean isControlReadOnly(String controlId) {
		return selenium
				.isElementPresent("xpath=//*[@id = '" + controlId + "' and "
						+ containingClass("xforms-readonly") + "]");
	}
	
	protected void assertClass(String controlId, String expectedClass) {
		assertTrue(selenium
				.isElementPresent("xpath=//*[@id = '" + controlId + "' and "
						+ containingClass(expectedClass) + "]"));
	}
	
	protected boolean isControlNonRelevant(String controlId) {
		return selenium
				.isElementPresent("xpath=//*[@id = '" + controlId + "' and "
						+ containingClass("xforms-disabled") + "]");
	}

}
