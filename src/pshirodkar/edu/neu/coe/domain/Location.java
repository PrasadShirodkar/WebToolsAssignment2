package pshirodkar.edu.neu.coe.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * This domain object stores all the information related to a location searched
 * in a map.
 * 
 * @author Prasad
 * 
 */
public class Location {

	private String description;

	private String streetAddress;

	private String city;

	private String state;

	private int zipCode;

	private String color;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColorDescriptionLabel() {
		String colorDescriptionLabel = "";

		if (color != null && !color.trim().equals("") && description != null
				&& !description.trim().equals("")) {
			colorDescriptionLabel = color.concat(" - ").concat(description);
		}

		return colorDescriptionLabel;
	}

	public String retrieveLocationParameters() {

		StringBuffer locationParameters = new StringBuffer();

		List<String> locationParametersList = new ArrayList<String>();

		if (description != null && !description.trim().equals("")) {
			locationParametersList.add(description);
		}
		if (streetAddress != null && !streetAddress.trim().equals("")) {
			locationParametersList.add(streetAddress);
		}
		if (city != null && !city.trim().equals("")) {
			locationParametersList.add(city);
		}
		if (state != null && !state.trim().equals("")) {
			locationParametersList.add(state);
		}

		if (zipCode > 0) {
			locationParametersList.add(Integer.toString(zipCode));
		}

		for (int i = 0; i < locationParametersList.size(); i++) {

			if (locationParametersList.get(i) != null
					&& !locationParametersList.get(i).trim().equals("")) {
				locationParameters.append(locationParametersList.get(i));

				if (i < (locationParametersList.size() - 1)) {
					locationParameters.append(",");
				}
			}
		}

		return locationParameters.toString();
	}
}