<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table >
        <td width="350"><tiles:insertAttribute name="body" /></td>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer" />      </td>
</table>
</body>
</html>