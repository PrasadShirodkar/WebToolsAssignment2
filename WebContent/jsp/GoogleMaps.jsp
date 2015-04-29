<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pshirodkar.edu.neu.coe.constants.ReferenceConstants, java.util.*" %>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Assignment 2 - Google Static Maps API</title>
		<script type="text/javascript" src="scripts/scripts.js"></script>
	</head>
	<body>
		<div align="center">
			<h2>Assignment 2 - Google Static Maps API</h2>
			<div style="width:38%; clear:both;">
				<div style="width:25%; float: left;">
					<form action="<%= request.getContextPath()%>/NewMap" method="post">
						<input type="submit" value="Create New Map" />
					</form>			
				</div>
				<div style="width:25%; float:right;">
					<form action="<%= request.getContextPath()%>/GoogleMapsClearSearchResults" method="post"
						onclick="return confirmClearSearchResults();">
						<input type="submit" value="Clear Search Results" />
					</form>
				</div>
			</div>
			<div align="center" style="width:100%; clear: both;">
				<table align="center" cellspacing="20">
					<jsp:include page="SearchForm.jsp" />
				</table>
			</div>		
		</div>
	</body>
</html>