package pshirodkar.edu.neu.coe.domain;

import java.util.ArrayList;
import java.util.List;

import pshirodkar.edu.neu.coe.bo.GoogleMapsBO;
import pshirodkar.edu.neu.coe.constants.ReferenceConstants;

/**
 * This domain object contains the complete functionality
 * for storing the map related information. It also stores
 * all the locations stored in the map.
 * 
 * @author Prasad
 *
 */
public class MapResult {
	
	private List<Location> locations = new ArrayList<Location>();

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	public void addLocation(Location location) {
		locations.add(location);
	}
	
	public void removeLocation(Location location) {
		locations.remove(location);
	}
	
	/**
	 * This method returns the pipe character (|) separated
	 * location parameters.
	 * 
	 * @return String
	 */
	public String getLocationParameters() {
		
		StringBuffer mapUrl = new StringBuffer();
		
		for (int i = 0; i < locations.size(); i++) {
			
			mapUrl.append(locations.get(i).retrieveLocationParameters());
			
			if (i < (locations.size() - 1)) {
				mapUrl.append(ReferenceConstants.CHARACTER_PIPE);
			}
		}
		
		return mapUrl.toString();
	}
	
	/**
	 * This method returns the URL for the map
	 * including all the locations searched in the map.
	 * 
	 * @return
	 */
	public String getMapUrl() {
		
		return new GoogleMapsBO().constructMapUrl(this);
	}
}