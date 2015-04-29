<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Google Maps Home</title>
</head>
<body>
	<div align="center">
		<h1>Assignment 2: Google Static Maps API</h1>
		<h2><a href="<%= request.getContextPath()%>/GoogleMaps">Search Locations using Google Maps</a></h2>
		<img src="http://maps.google.com/maps/api/staticmap?markers=&size=300x300&sensor=false" title="Google Static Maps" />
	</div>	
</body>
</html>