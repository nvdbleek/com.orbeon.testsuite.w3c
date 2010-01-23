<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="2.0" 
	xmlns:xftr="http://www.w3c.org/MarkUp/Forms/XForms/Test/Runner"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	>

	<xsl:output method="html" indent="yes" encoding="ISO-8859-1"/>
	
	<xsl:variable name="processor-wait">1000</xsl:variable>
	<xsl:variable name="echo-service-wait">2000</xsl:variable>

	
	<xsl:template match="xftr:test-case">
		<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
			<table cellpadding="1" cellspacing="1" border="1">
			  <tbody>
			    <tr>
			      <td rowspan="1" colspan="3"><xsl:value-of select="xftr:assert-title[1]/@title"/></td>
			    </tr>
			    <tr>
			        <td>setTimeout</td>
			        <td><xsl:value-of select="max(($processor-wait, $echo-service-wait))"/></td>
			        <td></td>
				</tr> 
			    <xsl:apply-templates />
			  </tbody>
			</table>
		</html>
	</xsl:template>
	
	<xsl:template match="xftr:open">
		<tr>
            <td>open</td>
            <td>../../../xforms-test-suite/forms/XForms1.1/Edition1/<xsl:value-of select="@href"/></td>
            <td></td>
         </tr>
	</xsl:template>

	<!-- Don't check title -->
	<xsl:template match="xftr:assert-title[following-sibling::*[1][node-name(.) = xs:QName('xftr:assert-exception')]]" />

	<xsl:template match="xftr:assert-title">
		<xsl:choose>
            <xsl:when test="@title = 'Results from echo.sh'">
            	<tr>
		            <td>waitForTitle</td>
		            <td><xsl:value-of select="@title"/></td>
		            <td><xsl:value-of select="$echo-service-wait"/></td>
         		</tr>	
			</xsl:when>
			<xsl:otherwise>
				<tr>
		            <td>assertTitle</td>
		            <td>Orbeon Forms Example Applications - <xsl:value-of select="@title"/></td>
		            <td></td>
		         </tr>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>	

	<xsl:template match="xftr:assert-exception">
		<tr>
            <td>assertXFormsException</td>
            <td><xsl:value-of select="@type"/></td>
            <td></td>
         </tr>
	</xsl:template>
	
	<xsl:template match="xftr:assert-control-present">
		<tr>
            <td>waitForXFormsControlElementPresent</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="@type"/></td>
         </tr>
	</xsl:template>

	<xsl:template match="xftr:assert-control-not-present">
		<tr>
            <td>waitForXFormsControlElementNotPresent</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="@type"/></td>
         </tr>
	</xsl:template>

	<xsl:template match="xftr:assert-control-valid">
		<tr>
            <td>waitForXFormsControlValid</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="$processor-wait"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:assert-control-invalid">
		<tr>
            <td>waitForXFormsControlInvalid</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="$processor-wait"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:assert-control-readonly">
		<tr>
            <td>waitForXFormsControlReadonly</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="$processor-wait"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:assert-control-readwrite">
		<tr>
            <td>waitForXFormsControlReadwrite</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="$processor-wait"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:assert-control-required">
		<tr>
            <td>waitForXFormsControlRequired</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="$processor-wait"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:assert-control-optional">
		<tr>
            <td>waitForXFormsControlOptional</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="$processor-wait"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:assert-selection-options">
		<tr>
            <td>assertXFormsSelectionOptions</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="@options"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:select-option">
		<tr>
            <td>xFormsSelectOption</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="@option"/></td>
         </tr>		
	</xsl:template>
	
	<xsl:template match="xftr:assert-control-value[boolean(@trim)]">
		<tr>
            <td>waitForCondition</td>
            <td>selenium.getXFormsControlValue("<xsl:value-of select="@locator"/>").replace(/^\s\s*/, '').replace(/\s\s*$/, '') == "<xsl:value-of select="@value"/>"</td>
            <td><xsl:value-of select="$processor-wait"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:assert-control-value">
		<tr>
            <td>waitForXFormsControlValue</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="@value"/></td>
         </tr>		
	</xsl:template>
	
	<xsl:template match="xftr:assert-control-value-contains">
		<tr>
            <td>waitForCondition</td>
            <td>selenium.getXFormsControlValue("<xsl:value-of select="@locator"/>").indexOf("<xsl:value-of select="@value"/>") != -1</td>
            <td><xsl:value-of select="$processor-wait"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:assert-control-value-in-range">
		<tr>
            <td>waitForCondition</td>
            <td>(selenium.getXFormsControlValue("<xsl:value-of select="@locator"/>") &gt;= <xsl:value-of select="@start"/>) &amp;&amp; (selenium.getXFormsControlValue("<xsl:value-of select="@locator"/>") &lt;= <xsl:value-of select="@end"/>)</td>
            <td><xsl:value-of select="$processor-wait"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:type-input">
		<tr>
            <td>xFormsTypeInput</td>
            <td><xsl:value-of select="@locator"/></td>
            <td><xsl:value-of select="@value"/></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:click">
		<tr>
            <td>click</td>
            <td><xsl:value-of select="@locator"/></td>
            <td></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:wait-for-page-to-load">
		<tr>
            <td>waitForPageToLoad</td>
            <td><xsl:value-of select="$echo-service-wait"/></td>
            <td></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:assert-text-present">
		<tr>
            <td>assertTextPresent</td>
            <td><xsl:value-of select="@text"/></td>
            <td></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:fail">
		<tr>
            <td>fail</td>
            <td><xsl:value-of select="@msg"/></td>
            <td></td>
         </tr>		
	</xsl:template>

	<xsl:template match="xftr:*">
		<xsl:message>Element <xsl:value-of select="name(.)"/> not implemented!</xsl:message>		
	</xsl:template>


	<xsl:template match="text()"/>

</xsl:stylesheet>
