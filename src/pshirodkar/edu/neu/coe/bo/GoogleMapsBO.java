package pshirodkar.edu.neu.coe.bo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import pshirodkar.edu.neu.coe.constants.ReferenceConstants;
import pshirodkar.edu.neu.coe.domain.Location;
import pshirodkar.edu.neu.coe.domain.MapResult;

/**
 * This business object is used to retrieve the location from the Google Maps
 * API for a given address.
 * 
 * @author Prasad
 * 
 */
public class GoogleMapsBO {

	/**
	 * This method stores the new location in the appropriate map.
	 * 
	 * @param mapResultList
	 * @param location
	 * @param mapIndex
	 */
	public void searchLocation(List<MapResult> mapResultList,
			Location location, int mapIndex) {

		MapResult mapResult = mapResultList.get(mapIndex);
		mapResult.addLocation(location);
	}

	/**
	 * This method constructs the url for a map including all the locations
	 * searched in the map.
	 * 
	 * @param mapResult
	 * @return String representing Google Static Maps API URL with the required
	 *         parameters.
	 */
	public String constructMapUrl(MapResult mapResult) {

		StringBuffer markersParam = new StringBuffer();
		markersParam.append(constructMarkersParameters(mapResult));

		StringBuffer sizeParam = new StringBuffer();
		sizeParam
				.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_SIZE
						+ "="
						+ ReferenceConstants.GOOGLE_STATIC_MAPS_API_CONSTANT_SIZE);

		StringBuffer sensorParam = new StringBuffer();
		sensorParam
				.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_SENSOR
						+ "=" + Boolean.FALSE.toString());

		StringBuffer url = new StringBuffer();

		url.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_URL);
		url.append(markersParam);

		url.append(ReferenceConstants.CHARACTER_AMPERSAND);
		url.append(sizeParam);

		url.append(ReferenceConstants.CHARACTER_AMPERSAND);
		url.append(sensorParam);

		return url.toString();
	}

	/**
	 * This method constructs the parameters required for markers. 
	 * 
	 * @param mapResult
	 * @return
	 */
	private String constructMarkersParameters(MapResult mapResult) {

		StringBuffer markersParam = new StringBuffer();

		if (mapResult.getLocations() != null
				&& !mapResult.getLocations().isEmpty()) {
			
			for (int i = 0; i < mapResult.getLocations().size(); i++) {

				markersParam
						.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_MARKERS
								+ "=");

				markersParam
						.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_MARKERS_COLOR);
				markersParam.append(ReferenceConstants.COLORS[i]);
				markersParam.append(ReferenceConstants.CHARACTER_PIPE);
				
				mapResult.getLocations().get(i).setColor(ReferenceConstants.COLORS[i]);
				
				markersParam
						.append(ReferenceConstants.GOOGLE_STATIC_MAPS_API_PARAM_MARKERS_LABEL);
				markersParam
						.append((char) (ReferenceConstants.CHARACTER_ASCII_A + i));
				markersParam.append(ReferenceConstants.CHARACTER_PIPE);

				markersParam.append(mapResult.getLocations().get(i)
						.retrieveLocationParameters());

				if (i < (mapResult.getLocations().size() - 1)) {
					markersParam.append(ReferenceConstants.CHARACTER_AMPERSAND);
				}
			}
		}

		return markersParam.toString();
	}

	/**
	 * This method retrieves the Google Maps list from the session.
	 * 
	 * @param session
	 * @return
	 */
	public List<MapResult> retrieveGoogleMapsList(HttpSession session) {

		List<MapResult> mapResultList = (List<MapResult>) session
				.getAttribute(ReferenceConstants.MAPS);
		return mapResultList;
	}

	/**
	 * This method initializes the List of MapResult objects.
	 * 
	 * @return
	 */
	public List<MapResult> initializeMapResultList() {

		List<MapResult> mapResultList = new ArrayList<MapResult>();
		MapResult mapResult = new MapResult();
		mapResultList.add(mapResult);
		return mapResultList;
	}
}