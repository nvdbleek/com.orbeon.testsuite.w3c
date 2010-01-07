<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="2.0" xmlns:ev="http://www.w3.org/2001/xml-events" xmlns:xf="http://www.w3.org/2002/xforms" xmlns:xfts="http://www.w3c.org/MarkUp/Forms/XForms/Test/11"
	xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	exclude-result-prefixes="xsl ev xfts">
	
	<xsl:output method="xml" indent="yes" name="xml"/>

	<xsl:template match="/xfts:testSuite/xfts:specChapter[1]">
		<suite name="concat(@chapterName, @chapterTitle)">
			<test-case href="{substring-before(substring-after(xfts:testCaseLink, '../../'), '.xhtml')}.xml"/>
		</suite>
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="xfts:testCase">
		<xsl:result-document href="{substring-before(substring-after(xfts:testCaseLink, '../../'), '.xhtml')}.xml" format="xml">
			<test-case xmlns="http://www.w3c.org/MarkUp/Forms/XForms/Test/Runner" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.w3c.org/MarkUp/Forms/XForms/Test/Runner {substring-after(replace(substring-after(xfts:testCaseLink, '../../'), '[^/]+', '..'), '../')}/test-case.xsd">
				<open href="{substring-after(xfts:testCaseLink, '../../')}" />
				<assert-title title="{lower-case(xfts:testCaseName)} {xfts:testCaseDescription}" />
				<fail msg="Test not implemented yet!" />
			</test-case>
		</xsl:result-document>
	</xsl:template>

	<xsl:template match="text()"/>

</xsl:stylesheet>
