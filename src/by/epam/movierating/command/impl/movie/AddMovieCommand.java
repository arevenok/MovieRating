package by.epam.movierating.command.impl.movie;

import by.epam.movierating.command.Command;
import by.epam.movierating.command.util.LanguageUtil;
import by.epam.movierating.command.util.QueryUtil;
import by.epam.movierating.domain.Movie;
import by.epam.movierating.service.exception.ServiceException;
import by.epam.movierating.service.factory.ServiceFactory;
import by.epam.movierating.service.interfaces.MovieService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Владислав on 07.08.2016.
 */
public class AddMovieCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String userStatus = (session == null) ? null : (String) session.getAttribute("userStatus");
        if(userStatus == null || !userStatus.equals("admin")){
            response.sendRedirect("/Controller?command=login&cause=timeout");
            return;
        }

        QueryUtil.saveCurrentQueryToSession(request);
        String languageId = LanguageUtil.getLanguageId(request);
        request.setAttribute("selectedLanguage", languageId);

        String movieFormName = request.getParameter("movieFormName");
        String movieFormYear = request.getParameter("movieFormYear");
        String movieFormTagline= request.getParameter("movieFormTagline");
        String movieFormBudget = request.getParameter("movieFormBudget");
        String movieFormPremiere = request.getParameter("movieFormPremiere");
        String movieFormLasting = request.getParameter("movieFormLasting");
        String movieFormAnnotation = request.getParameter("movieFormAnnotation");
        String movieFormImage = request.getParameter("movieFormImage");
        if(movieFormName != null && movieFormYear != null && movieFormTagline != null && movieFormBudget != null
                && movieFormPremiere != null && movieFormLasting != null && movieFormAnnotation != null && movieFormImage != null){
            try {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                MovieService movieService = serviceFactory.getMovieService();
                movieService.addMovie(movieFormName, Integer.parseInt(movieFormYear), movieFormTagline,
                        Integer.parseInt(movieFormBudget), movieFormPremiere, Integer.parseInt(movieFormLasting),
                        movieFormAnnotation, movieFormImage);
                response.sendRedirect("/Controller?command=movies");
                return;
            } catch (ServiceException e) {
                request.setAttribute("serviceError", true);
                request.setAttribute("movieFormName", movieFormName);
                request.setAttribute("movieFormYear", movieFormYear);
                request.setAttribute("movieFormTagline", movieFormTagline);
                request.setAttribute("movieFormBudget", movieFormBudget);
                request.setAttribute("movieFormPremiere", movieFormPremiere);
                request.setAttribute("movieFormLasting", movieFormLasting);
                request.setAttribute("movieFormAnnotation", movieFormAnnotation);
                request.setAttribute("movieFormImage", movieFormImage);
            }
        }

        request.getRequestDispatcher("WEB-INF/jsp/movie/add-movie-form.jsp").forward(request, response);
    }
}
