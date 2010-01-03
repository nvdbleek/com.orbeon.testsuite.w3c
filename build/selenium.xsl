<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="2.0" xmlns:xhtml="http://www.w3.org/1999/xhtml"
	xmlns:ev="http://www.w3.org/2001/xml-events" xmlns:xf="http://www.w3.org/2002/xforms" xmlns:xfts="http://www.w3c.org/MarkUp/Forms/XForms/Test/11"
	xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	exclude-result-prefixes="xsl ev">


	<xsl:output method="html" indent="yes" name="html" />


	<xsl:template match="/xfts:testSuite/xfts:specChapter[1]">
		<html>
			<head>
				<title><xsl:value-of select="concat(@chapterName, @chapterTitle)"/></title>
				<link rel="stylesheet" type="text/css" href="../../selenium-core/core/selenium.css" />
		        <script language="JavaScript" type="text/javascript" src="../../selenium-core/core/scripts/selenium-browserdetect.js"></script>
			</head>
			<body>
				<table id="suiteTable" cellpadding="1" cellspacing="1" border="1" class="selenium">
					<tbody>
						<tr><td><b><xsl:value-of select="concat(@chapterName, @chapterTitle)"/></b></td></tr>
						<xsl:for-each select="xfts:testCase">
							<tr><td><a href="{substring-before(substring-after(xfts:testCaseLink, '../../'), '.xhtml')}.html"><xsl:value-of select="concat(xfts:testCaseName, ' ', xfts:testCaseDescription)"/></a></td></tr>
						</xsl:for-each>
					</tbody>
				</table>
			</body>
		</html>
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="xfts:testCase">
		<xsl:result-document href="{substring-before(substring-after(xfts:testCaseLink, '../../'), '.xhtml')}.html" format="html">
			<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
				<table cellpadding="1" cellspacing="1" border="1">
				  <tbody>
				    <tr>
				      <td rowspan="1" colspan="3"><xsl:value-of select="concat(xfts:testCaseName, ' ', xfts:testCaseDescription)"/></td>
				    </tr>
				    <tr>
				    	<td>open</td>
						<td>../../../xforms-test-suite/forms/XForms1.1/Edition1/<xsl:value-of select="substring-after(xfts:testCaseLink, '../../')"/></td>
						<td></td>
				    </tr>
				    <tr>
				    	<td>assertTitle</td>
						<td>Orbeon Forms Example Applications - <xsl:value-of select="concat(lower-case(xfts:testCaseName), ' ', xfts:testCaseDescription)"/></td>
						<td></td>
				    </tr>
				    <tr>
				    	<td>fail</td>
						<td>Test not implemented yet!</td>
						<td></td>
				    </tr>
				  </tbody>
				</table>
			</html>
		</xsl:result-document>
	</xsl:template>

	<xsl:template match="text()"/>

</xsl:stylesheet>
