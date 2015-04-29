package pshirodkar.edu.neu.coe.constants;

/**
 * This class defines the constants referenced in the application.
 * 
 * @author Prasad
 * 
 */
public class ReferenceConstants {

	public static final String GOOGLE_STATIC_MAPS_API_URL = "http://maps.google.com/maps/api/staticmap?";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_CENTER = "center";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_SIZE = "size";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_MARKERS = "markers";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_MARKERS_COLOR = "color:";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_MARKERS_LABEL = "label:";

	public static final String GOOGLE_STATIC_MAPS_API_PARAM_SENSOR = "sensor";

	public static final String GOOGLE_STATIC_MAPS_API_CONSTANT_SIZE = "300x300";

	public static final String MAPS = "MAPS";

	public static final String CHARACTER_AMPERSAND = "&";

	public static final String CHARACTER_COMMA = ",";

	public static final String CHARACTER_PIPE = "|";

	public static final int CHARACTER_ASCII_A = 65;

	public static final String GOOGLE_STATIC_MAPS_API_DEFAULT_URL = GOOGLE_STATIC_MAPS_API_URL
			+ GOOGLE_STATIC_MAPS_API_PARAM_MARKERS
			+ "="
			+ CHARACTER_AMPERSAND
			+ GOOGLE_STATIC_MAPS_API_PARAM_SIZE
			+ "="
			+ GOOGLE_STATIC_MAPS_API_CONSTANT_SIZE
			+ CHARACTER_AMPERSAND
			+ GOOGLE_STATIC_MAPS_API_PARAM_SENSOR
			+ "="
			+ Boolean.FALSE.toString();

	public static final String REQUEST_PARAM_DESCRIPTION = "description";

	public static final String REQUEST_PARAM_STREET_ADDRESS = "street_address";

	public static final String REQUEST_PARAM_CITY = "city";

	public static final String REQUEST_PARAM_STATE = "state";

	public static final String REQUEST_PARAM_ZIP_CODE = "zip_code";

	public static final String REQUEST_PARAM_MAP_INDEX = "MAP_INDEX";

	public static final String[] COLORS = { "blue", "red", "brown", "green",
			"orange", "pink", "red", "silver", "violet", "yellow" };
}