//Copyright (c) 2010, Nick Van den Bleeken
//All rights reserved.
//
//Redistribution and use in source and binary forms, with or without modification, 
//are permitted provided that the following conditions are met:
//
//    * Redistributions of source code must retain the above copyright notice, this
//      list of conditions and the following disclaimer.
//    * Redistributions in binary form must reproduce the above copyright notice, 
//      this list of conditions and the following disclaimer in the documentation 
//      and/or other materials provided with the distribution.
//
//THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
//EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 
//OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
//SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
//INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
//PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
//INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
//STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
//OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

Selenium.prototype.getXFormsControlValue = function(locator) {
	var win = selenium.browserbot.getUserWindow();
    return win.ORBEON.xforms.Document.getValue(locator);
};

Selenium.prototype.isXFormsControlInvalid = function(locator) {
	return selenium.isClassPresentOnElement(locator, "xforms-invalid");
};


// Input controls
Selenium.prototype.doXFormsTypeInput = function(locator, value) {
	selenium.doType(locator + "$xforms-input-1", value);
};

Selenium.prototype.isXFormsControlElementPresent = function(locator, controlType) {
	return selenium.isClassPresentOnElement(locator, "xforms-" + controlType) 
		&& !selenium.isClassPresentOnElement(locator, "xforms-disabled")
		&& !selenium.isClassPresentOnElement(locator, "xforms-disabled-subsequent");
};


// Select controls
Selenium.prototype.getXFormsSelectionOptions = function(locator) {
	return selenium.getSelectOptions(locator).join(',');
};

Selenium.prototype.doXFormsSelectOption = function(locator, label) {
	selenium.doSelect(locator, "label=" + label);
};

// Misc

Selenium.prototype.isClassPresentOnElement = function(locator, expectedClass) {
	return selenium.isElementPresent("xpath=//*[@id = '" + locator + "' and "
		+ containingClassSelector(expectedClass) + "]");
};

Selenium.prototype.isXFormsException = function(exception) {
	return selenium.getTitle() === "Orbeon Forms - An Error has Occurred";
};

Selenium.prototype.getEval = function(expr) {
	try 
	{
    	return eval(expr);
    } 
	catch (e) 
	{
    	throw new SeleniumError(e.message);
    }
};

function containingClassSelector(className) {
    return "contains(concat(' ',normalize-space(@class),' '),' " + className + " ')";
}

