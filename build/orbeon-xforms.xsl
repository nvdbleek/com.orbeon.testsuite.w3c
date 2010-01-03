<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xforms="http://www.w3.org/2002/xforms"
	xmlns:xhtml="http://www.w3.org/1999/xhtml">
	
	<xsl:template match="/">
		<html>
			<head>
				<title><xsl:value-of select=""/></title>
				<link rel="stylesheet" type="text/css" href="../../selenium-core/core/selenium.css" />
		        <script language="JavaScript" type="text/javascript" src="../../selenium-core/core/scripts/selenium-browserdetect.js"></script>
			</head>
			<body>
				<table id="suiteTable" cellpadding="1" cellspacing="1" border="1" class="selenium">
					<tbody>
						<tr><a href="Appendix/B/B.1/b.1.a.html">b.1.a Prepend Element Copy</a></tr>
					</tbody>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>