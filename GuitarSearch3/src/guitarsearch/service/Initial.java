package guitarsearch.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import guitarsearch.dao.InventoryDao;
import guitarsearch.domain.DataAccess;
import guitarsearch.domain.Guitar;

/**
 * Application Lifecycle Listener implementation class Initial
 *
 */
@WebListener
public class Initial implements ServletContextListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public Initial() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	InventoryDao inv = DataAccess.createInventoryDao();
    	List<Guitar> guitars = inv.getAllGuitars();
    	ServletContext application = sce.getServletContext();
    	application.setAttribute("Guitars", guitars);
    }
	
}
