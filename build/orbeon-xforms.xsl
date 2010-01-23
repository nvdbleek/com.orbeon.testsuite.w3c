<?xml version="1.0" encoding="UTF-8"?>
<!-- 
Copyright (c) 2010, Nick Van den Bleeken
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this
      list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice, 
      this list of conditions and the following disclaimer in the documentation 
      and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 -->
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xforms="http://www.w3.org/2002/xforms"
	xmlns:xhtml="http://www.w3.org/1999/xhtml">

	<xsl:template match="xhtml:link[@rel = 'stylesheet']">
		<xhtml:link rel="stylesheet" href="/apps/xforms-test-suite/TestSuite11.css"
			type="text/css" />
	</xsl:template>

	<xsl:template match="xforms:*[not(@id) and 
		exists(index-of(('input', 'secret', 'textarea', 'output', 'upload', 'range', 'trigger', 'submit', 'select', 'select1'), local-name(.)))]">
		<xsl:copy>
			<xsl:apply-templates select="@*" />
			<xsl:attribute name="id"><xsl:value-of select="concat('xf-', local-name(.) ,'-', count(preceding::xforms:*[local-name(.) = local-name(current())]) + 1)"/></xsl:attribute>
			<xsl:apply-templates />
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="xforms:group[not(@id)]">
		<xsl:copy>
			<xsl:apply-templates select="@*" />
			<xsl:attribute name="id">xf-group-<xsl:value-of select="count(preceding::xforms:group) + count(ancestor::xforms:group) + 1"/></xsl:attribute>
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