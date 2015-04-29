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
import pshirodkar.edu.neu.coe.domain.MapResult;

/**
 * The purpose of this servlet is to clear all the searched Google maps. 
 * 
 * @author Prasad
 *
 */
public class GoogleMapsClearSearchResultsServlet extends HttpServlet {

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
		List<MapResult> mapList = googleMapsBO.retrieveGoogleMapsList(session);
		
		if (mapList == null || mapList.isEmpty()) {
			mapList = googleMapsBO.initializeMapResultList();
			session.setAttribute(ReferenceConstants.MAPS, mapList);
		} else {
			mapList.clear();
			mapList.add(new MapResult());
		}
				
		getServletConfig().getServletContext().getRequestDispatcher(
        "/jsp/GoogleMaps.jsp").forward(req,resp);
	}
}