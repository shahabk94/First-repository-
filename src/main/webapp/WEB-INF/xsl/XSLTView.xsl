<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0">
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <body>
                <div align="center">
                <h2>Summary</h2>
          <p><xsl:value-of select="//summary-headline"/></p>        
        <table border="1">
        <tr bgcolor="#9acd32">
        <th>Attribution</th>
        </tr>
        <xsl:for-each select="//attribution">
        <tr>
        <td><xsl:value-of select="."/></td>
        </tr>
    </xsl:for-each>
    </table>
            </div>
            </body>
        </html>
    </xsl:template>  
</xsl:stylesheet>