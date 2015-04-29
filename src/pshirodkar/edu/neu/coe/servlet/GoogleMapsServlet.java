package pshirodkar.edu.neu.coe.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pshirodkar.edu.neu.coe.bo.GoogleMapsBO;
import pshirodkar.edu.neu.coe.constants.ReferenceConstants;
import pshirodkar.edu.neu.coe.domain.Location;
import pshirodkar.edu.neu.coe.domain.MapResult;

/**
 * The purpose of this servlet is to retrieve a location from the Google Maps
 * for the given address.
 * 
 * @author Prasad
 * 
 */
public class GoogleMapsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Get the current session object, create one if necessary
		HttpSession session = req.getSession(true);
		
		GoogleMapsBO googleMapsBO = new GoogleMapsBO();
		
		List<MapResult> mapResultList = googleMapsBO.retrieveGoogleMapsList(session);
		if (mapResultList == null || mapResultList.isEmpty()) {
			mapResultList = googleMapsBO.initializeMapResultList();
			session.setAttribute(ReferenceConstants.MAPS, mapResultList);
		}
		
		Location location = retrieveParameters(req);
		String mapIndex = req.getParameter(ReferenceConstants.REQUEST_PARAM_MAP_INDEX);
		if (mapIndex != null && !mapIndex.trim().equals("")) {
			googleMapsBO.searchLocation(mapResultList, location, Integer.parseInt(mapIndex));
		}
		
		getServletConfig().getServletContext().getRequestDispatcher(
        "/jsp/GoogleMaps.jsp").forward(req,resp);
	}
	
	/**
	 * This method is used to retrieve the request parameters.
	 * 
	 * @param req
	 * @return Location
	 */
	private Location retrieveParameters(HttpServletRequest req) {
		
		Location location = new Location();
		
		if (req.getParameter(ReferenceConstants.REQUEST_PARAM_DESCRIPTION) != null && 
				!req.getParameter(ReferenceConstants.REQUEST_PARAM_DESCRIPTION).trim().equals("")) {
			location.setDescription(req.getParameter(ReferenceConstants.REQUEST_PARAM_DESCRIPTION));
		}
		
		if (req.getParameter(ReferenceConstants.REQUEST_PARAM_STREET_ADDRESS) != null && 
				!req.getParameter(ReferenceConstants.REQUEST_PARAM_STREET_ADDRESS).trim().equals("")) {
			location.setStreetAddress(req.getParameter(ReferenceConstants.REQUEST_PARAM_STREET_ADDRESS));
		}
		
		if (req.getParameter(ReferenceConstants.REQUEST_PARAM_CITY) != null &&
				!req.getParameter(ReferenceConstants.REQUEST_PARAM_CITY).trim().equals("")) {
			location.setCity(req.getParameter(ReferenceConstants.REQUEST_PARAM_CITY));
		}
		
		if (req.getParameter(ReferenceConstants.REQUEST_PARAM_STATE) != null &&
				!req.getParameter(ReferenceConstants.REQUEST_PARAM_STATE).trim().equals("")) {
			location.setState(req.getParameter(ReferenceConstants.REQUEST_PARAM_STATE));
		}
		
		if (req.getParameter(ReferenceConstants.REQUEST_PARAM_ZIP_CODE) != null &&
				!req.getParameter(ReferenceConstants.REQUEST_PARAM_ZIP_CODE).trim().equals("")) {
			location.setZipCode(Integer.parseInt(req.getParameter(ReferenceConstants.REQUEST_PARAM_ZIP_CODE)));
		}
		
		return location;
	}
}