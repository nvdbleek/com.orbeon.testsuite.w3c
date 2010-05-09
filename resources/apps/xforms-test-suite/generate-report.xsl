<xsl:stylesheet version="2.0"
                xmlns:html="http://www.w3.org/1999/xhtml"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xf="http://www.w3.org/2002/xforms"
                xmlns:ev="http://www.w3.org/2001/xml-events"
                xmlns:ts="http://www.w3c.org/MarkUp/Forms/XForms/Test/11"
                xmlns:saxon="http://saxon.sf.net/"
                exclude-result-prefixes="html ev xsl xf">

    <!-- Copyright 2008 Lars Windauer, Joern Turner -->
    <xsl:param name="rootDir">Results/useragents</xsl:param>
    <xsl:param name="useragent" select="'Chiba'"/>

    <xsl:variable name="config" select="/*"/>

    <xsl:output method="xhtml" omit-xml-declaration="yes" indent="yes"/>

    <xsl:template match="/results">
        <html>
            <head>
                <title>XForms TestSuite Results (Edition 1)</title>
                <style type="text/css">

                    table{
	                    width:80%;
	                    margin-left:auto;
	                    margin-right:auto;
                    }

                    .true{font-weight:bold;}
                    .passed {background:green;}
                    .failed {background:red;}
                    .unknown{background:#f5f5f5;}
                    
                </style>
            </head>
            <body>
            	<div>Overview:</div>
            	<table border="1">
            		<tr>
            			<td>passed</td>
            			<td>failed</td>
            		</tr>
            		<tr>
            			<td><xsl:value-of select="count(file[@pass='true'])"/></td>
            			<td><xsl:value-of select="count(file[@pass='false'])"/></td>
            		</tr>
            	</table>
							
                <div>Details:</div>
                <table border="1">
                	<tr>
                         <td>Test Case</td>
                         <td>Description</td>
                         <td>Date</td>
                     </tr>
                     <xsl:for-each select="test">
                         <!-- <tr>
                             <xsl:variable name="headerCols" select="6 + count($config//config)"/>
                             <td colspan="{$headerCols}" style="background:#ccc;">
                                 <xsl:value-of select="@chapterTitle"/>
                             </td>
                         </tr> -->
                         

                         <tr class="{if (@pass='true') then 'passed' else 'failed'}">
                             <td>
                                 <xsl:value-of select="substring-before(@name, ' ')"/>
                             </td>
                             <td>
                                 <xsl:value-of select="substring-after(@name, ' ')"/>
                             </td>
                             <td>
                                 
                             </td>
                         </tr>
                     </xsl:for-each>
                  </table>
                <p/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="*|@*">
        <xsl:copy>
            <xsl:apply-templates select="*|@*"/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="text()"/>

</xsl:stylesheet>

