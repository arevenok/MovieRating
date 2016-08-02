package by.epam.movierating.controller.listener; /**
 * Created by Владислав on 19.07.2016.
 */
import by.epam.movierating.service.exception.ServiceException;
import by.epam.movierating.service.factory.ServiceFactory;
import by.epam.movierating.service.interfaces.PoolService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionPoolListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public ConnectionPoolListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            PoolService poolService = serviceFactory.getPoolService();
            poolService.init();
        } catch (ServiceException e) {
            sce.getServletContext().setAttribute("initPoolException", true);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            PoolService poolService = serviceFactory.getPoolService();
            poolService.destroy();
        } catch (ServiceException e) {
            throw new ConnectionPoolListenerException("Cannot destroy pool", e);
        }
    }
}