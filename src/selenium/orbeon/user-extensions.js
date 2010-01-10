
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


function containingClassSelector(className) {
    return "contains(concat(' ',normalize-space(@class),' '),' " + className + " ')";
}

