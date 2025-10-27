<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>
<head>
    <title>Grocery Store Inventory</title>
    <style>
        body {
            background: linear-gradient(135deg, #b7f77d, #56ab2f);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            text-align: center;
            color: #333;
            padding: 40px;
        }
        h1 {
            color: #1b5e20;
            text-shadow: 1px 1px 2px #aaa;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background-color: #f9f9f9;
            box-shadow: 0 4px 10px rgba(0,0,0,0.2);
            border-radius: 12px;
            overflow: hidden;
        }
        th {
            background-color: #2e8b57;
            color: white;
            padding: 12px;
            text-transform: uppercase;
        }
        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        tr:nth-child(even) {
            background-color: #e6f4ea;
        }
        tr:hover {
            background-color: #c8f7c5;
            transform: scale(1.01);
            transition: 0.3s;
        }
    </style>
</head>
<body>
    <h1>Grocery Items List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Item Name</th>
            <th>Category</th>
            <th>Price (Rs)</th>
            <th>Stock</th>
        </tr>
        <xsl:for-each select="groceries/item">
            <tr>
                <td><xsl:value-of select="id"/></td>
                <td><xsl:value-of select="name"/></td>
                <td><xsl:value-of select="category"/></td>
                <td><xsl:value-of select="price"/></td>
                <td><xsl:value-of select="stock"/></td>
            </tr>
        </xsl:for-each>
    </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
