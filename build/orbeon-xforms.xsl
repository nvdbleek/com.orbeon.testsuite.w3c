<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xforms="http://www.w3.org/2002/xforms"
	xmlns:xhtml="http://www.w3.org/1999/xhtml">
	
	<xsl:template match="xhtml:link[@rel = 'stylesheet']">
		<xhtml:link rel="stylesheet" href="/apps/xforms-test-suite/TestSuite11.css" type="text/css" />
	</xsl:template>
	
	<xsl:template match="xforms:*[not(@id)]">
		<xsl:copy>
			<xsl:apply-templates select="@*" />
			<xsl:attribute name="id" >gen-<xsl:value-of select="count(preceding::xforms:*) + count(ancestor::xforms:*) + 1"/></xsl:attribute>
			<xsl:apply-templates />
		</xsl:copy>
	</xsl:template>

	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*" />
			<xsl:apply-templates />
		</xsl:copy>
	</xsl:template>
</xsl:stylesheet>