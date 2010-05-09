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

Selenium.prototype.isXFormsInitialized = function(locator) {
	var win = selenium.browserbot.getUserWindow();
	return true; //win.ORBEON.xforms.Globals.topLevelListenerRegistered;
};

Selenium.prototype.isXFormsControlInvalid = function(locator) {
	return selenium.isClassPresentOnElement(locator, "xforms-invalid");
};

Selenium.prototype.isXFormsControlReadonly = function(locator) {
	return selenium.isClassPresentOnElement(locator, "xforms-readonly");
};

Selenium.prototype.isXFormsControlReadwrite = function(locator) {
	return !selenium.isClassPresentOnElement(locator, "xforms-readonly");
};

Selenium.prototype.isXFormsControlRequired = function(locator) {
	return selenium.isClassPresentOnElement(locator, "xforms-required");
};

Selenium.prototype.isXFormsControlOptional = function(locator) {
	return !selenium.isClassPresentOnElement(locator, "xforms-required");
};


// Input controls
Selenium.prototype.doXFormsTypeInput = function(locator, value) {
	selenium.doType(locator + "$xforms-input-1", value);
	return Selenium.decorateFunctionWithTimeout(function() {
		var win = selenium.browserbot.getUserWindow();
	    return (win.ORBEON == undefined) || !(win.ORBEON.xforms.Globals.requestInProgress || win.ORBEON.xforms.Globals.eventQueue.length > 0);
	  }, 5000);
};

Selenium.prototype.doXFormsTypeSecret = function(locator, value) {
	selenium.doType(locator, value);
	return Selenium.decorateFunctionWithTimeout(function() {
		var win = selenium.browserbot.getUserWindow();
	    return (win.ORBEON == undefined) || !(win.ORBEON.xforms.Globals.requestInProgress || win.ORBEON.xforms.Globals.eventQueue.length > 0);
	  }, 5000);
};

Selenium.prototype.doXFormsTypeTextArea = function(locator, value) {
	selenium.doType(locator, value);
	return Selenium.decorateFunctionWithTimeout(function() {
		var win = selenium.browserbot.getUserWindow();
	    return (win.ORBEON == undefined) || !(win.ORBEON.xforms.Globals.requestInProgress || win.ORBEON.xforms.Globals.eventQueue.length > 0);
	  }, 5000);
};

Selenium.prototype.isXFormsControlElementPresent = function(locator, controlType) {
	//alert("1 " + selenium.isElementPresent("xpath=//*[@id = '" + locator + "']"));
	//alert("2 " + selenium.isElementPresent("xpath=//*[@id = '" + locator + "']/ancestor::span"));
	//alert("3 " + selenium.isElementPresent("xpath=//*[@id = '" + locator + "']/ancestor::*[contains(concat(' ',normalize-space(@class),' '),'xforms-case-deselected')]"));
	return selenium.isClassPresentOnElement(locator, "xforms-" + controlType) 
		&& !selenium.isClassPresentOnElement(locator, "xforms-disabled")
		&& !selenium.isClassPresentOnElement(locator, "xforms-disabled-subsequent")
		&& !selenium.isClassPresentOnElement(locator, "xforms-case-deselected")
		&& !selenium.isElementPresent("xpath=//*[@id = '" + locator + "']/ancestor::*[contains(concat(' ',normalize-space(@class),' '),'xforms-case-deselected')]");
};

Selenium.prototype.doXFormsClick = function(locator) {
	selenium.doClick(locator);
	return Selenium.decorateFunctionWithTimeout(function() {
		var win = selenium.browserbot.getUserWindow();
	    return (win.ORBEON == undefined) || !(win.ORBEON.xforms.Globals.requestInProgress || win.ORBEON.xforms.Globals.eventQueue.length > 0);
	  }, 5000);
};


// Select controls
Selenium.prototype.getXFormsSelectionOptions = function(locator) {
	return selenium.getSelectOptions(locator).join(',');
};

Selenium.prototype.doXFormsSelectOption = function(locator, label) {
	selenium.doSelect(locator, "label=" + label);
	return Selenium.decorateFunctionWithTimeout(function() {
		var win = selenium.browserbot.getUserWindow();
	    return (win.ORBEON == undefined) || !(win.ORBEON.xforms.Globals.requestInProgress || win.ORBEON.xforms.Globals.eventQueue.length > 0);
	  }, 5000);
};

// Misc

Selenium.prototype.isClassPresentOnElement = function(locator, expectedClass) {
	return selenium.isElementPresent("xpath=//*[@id = '" + locator + "' and "
		+ containingClassSelector(expectedClass) + "]");
};

Selenium.prototype.isXFormsException = function(exception) {
	return selenium.getTitle() === "Orbeon Forms - An Error has Occurred";
};

Selenium.prototype.isNoXFormsMessageVisible = function() {
	var win = selenium.browserbot.getUserWindow();
	var dialogEl = win.ORBEON.util.Dom.getElementById("xforms-message-dialog");
	return (dialogEl == null || dialogEl.parentNode.style.visibility !== "visible");
};

Selenium.prototype.isXFormsMessages = function(messages) {
	var win = selenium.browserbot.getUserWindow();
	
	var messagesArray = messages.split(',');
	
	var dialogEl = win.ORBEON.util.Dom.getElementById("xforms-message-dialog");
	if (dialogEl == null || dialogEl.parentNode.style.visibility !== "visible") {
		return false; // Dialog isn't visible
	}
    
	var bdEl = win.ORBEON.util.Dom.getChildElementByClass(dialogEl, "bd");
	while(dialogEl.parentNode.style.visibility === "visible") {
		var msg = user_extensions_trim(win.ORBEON.util.Dom.getStringValue(bdEl));
		
		var found = false;
		for (var i = 0; i < messagesArray.length; ++i) {
    		if (user_extensions_trim(messagesArray[i]) === msg) {
    			messagesArray.splice(i, 1);
    			found = true;
    			
    			// Close message dialog
    			win.ORBEON.util.Dom.getElementByTagName(dialogEl, "button").click()
    			
    			break;
    		}
    	}
		
		if (!found) {
			return false;
		}
	}
	
    return true;
};

Selenium.prototype.getXFormsMessage = function() {
	var win = selenium.browserbot.getUserWindow();

	var dialogEl = win.ORBEON.util.Dom.getElementById("xforms-message-dialog");
	if (dialogEl == null || dialogEl.parentNode.style.visibility !== "visible") {
		return null; // Dialog isn't visible
	}
	
	// Retrieve message
	var msg = user_extensions_trim(win.ORBEON.util.Dom.getStringValue(win.ORBEON.util.Dom.getChildElementByClass(dialogEl, "bd")));
	
	// Close message dialog
	win.ORBEON.util.Dom.getElementByTagName(dialogEl, "button").click()
	
	return msg;
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

function user_extensions_trim(s)
{
	var l=0; var r=s.length -1;
	while(l < s.length && (s[l] == ' ' || s[l] == '\n' || s[l] == '\r' || s[l] == '\t')){	l++; }
	while(r > l && (s[r] == ' ' || s[r] == '\n' || s[r] == '\r' || s[r] == '\t')) {	r-=1;	}
	return s.substring(l, r+1);
}
