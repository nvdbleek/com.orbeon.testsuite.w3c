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


// Input controls
Selenium.prototype.doXFormsTypeInput = function(locator, value) {
	selenium.doType(locator + "$xforms-input-1", value);
};

Selenium.prototype.doXFormsTypeSecret = function(locator, value) {
	selenium.doType(locator, value);
};

Selenium.prototype.doXFormsTypeTextArea = function(locator, value) {
	selenium.doType(locator, value);
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

Selenium.prototype.getCurrentNrOfXFormsMessages = function() {
	var win = selenium.browserbot.getUserWindow();
    var recordedAlerts = win.ORBEON.xforms.Globals.recordedAlerts;
	return recordedAlerts.length;
};

Selenium.prototype.isXFormsMessages = function(messages) {
	var win = selenium.browserbot.getUserWindow();
    var recordedAlerts = win.ORBEON.xforms.Globals.recordedAlerts;
    var messagesArray = messages.split(',');
    if (recordedAlerts.length != messagesArray.length) {
    	return false;
    }
    
    for(var i = 0; i < messagesArray.length; ++i)
    {
    	var found = false;
    	var message = user_extensions_trim(messagesArray[i]);
    	for (var j = 0; j < recordedAlerts.length; ++j) {
    		if (user_extensions_trim(recordedAlerts[j]) === message) {
    			found = true;
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
	var recordedAlerts = win.ORBEON.xforms.Globals.recordedAlerts;
	return recordedAlerts.length > 0 ? user_extensions_trim(recordedAlerts[0]) : null;
};

Selenium.prototype.doCloseXFormsMessage = function() {
	var win = selenium.browserbot.getUserWindow();
	for (var formIndex = 0; formIndex < win.document.forms.length; formIndex++) {
		var form = win.document.forms[formIndex];
		if (win.ORBEON.util.Dom.hasClass(form, "xforms-form")) {
			var formID = win.document.forms[formIndex].id;
			var formMessagePanel = win.ORBEON.xforms.Globals.formMessagePanel[formID];
			try {
				formMessagePanel.hide();
			}
			catch(e) 
			{ 
				// silently catch NPE
				//FIXME: messages displayed before xform-ready result in een NPE, due to a null subscriber on hide event
			}
			break;
		}
	}
};

Selenium.prototype.doCloseAllXFormsMessages = function() {
	var win = selenium.browserbot.getUserWindow();
	for (var formIndex = 0; formIndex < win.document.forms.length; formIndex++) {
		var form = win.document.forms[formIndex];
		if (win.ORBEON.util.Dom.hasClass(form, "xforms-form")) {
			var formID = win.document.forms[formIndex].id;
			var formMessagePanel = win.ORBEON.xforms.Globals.formMessagePanel[formID];
			while(win.ORBEON.xforms.Globals.recordedAlerts.length > 0) {
				try {
					formMessagePanel.hide();
				}
				catch(e) 
				{ 
					// silently catch NPE
					//FIXME: messages displayed before xform-ready result in een NPE, due to a null subscriber on hide event
				}
			}
			break;
		}
	}
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
