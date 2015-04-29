<%@page import="pshirodkar.edu.neu.coe.domain.Location"%>
<%@page import="pshirodkar.edu.neu.coe.domain.MapResult"%>
<%@ page import="pshirodkar.edu.neu.coe.constants.ReferenceConstants, java.util.*" %>
<%
	List<MapResult> mapList = (List<MapResult>)session.getAttribute(ReferenceConstants.MAPS);
	for (int count = 0; count < mapList.size(); count++) {
		MapResult mapResult = mapList.get(count);
%>
<tr>
	<td>
		<form method="post" action="<%= request.getContextPath()%>/GoogleMaps">
			
			<input type="hidden" name="<%= ReferenceConstants.REQUEST_PARAM_MAP_INDEX%>" value="<%= count%>" />
			
			<table cellspacing="5">
				<tr>
					<td>Description</td>
					<td colspan="3">
						<input type="text" name="description" maxlength="40" />
					</td>
				</tr>
				<tr>
					<td>Street Address</td>
					<td colspan="3">
						<input type="text" name="street_address" maxlength="40" />
					</td>
				</tr>
				<tr>
					<td>City</td>
					<td>
						<input type="text" name="city" maxlength="20" />
					</td>
					<td>State</td>
					<td>
						<input type="text" name="state" maxlength="20" />
					</td>
				</tr>
				<tr>
					<td>Zip Code</td>
					<td>
						<input type="text" name="zip_code" maxlength="10" />
					</td>
					<td colspan="2">
						<input type="submit" value="Add Location to Map" />
					</td>
				</tr>
			</table>
		</form>
		<%
			if (mapResult.getLocations() != null
					&& !mapResult.getLocations().isEmpty()) {
				for (Location location : mapResult.getLocations()) {
					out.println(location.getColorDescriptionLabel());
		%>
					
		<%		}
			}
		%>
	</td>
	<td>
		<img src="<%= mapList.get(count).getMapUrl() %>" />
	</td>
</tr>
<% } %>	