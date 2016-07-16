package by.epam.movierating.service.factory;

import by.epam.movierating.service.impl.*;
import by.epam.movierating.service.interfaces.*;

/**
 * Created by Владислав on 15.07.2016.
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final SiteService siteService = new SiteServiceImpl();
    private final CommentService commentService = new CommentServiceImpl();
    private final CountryService countryService = new CountryServiceImpl();
    private final GenreService genreService = new GenreServiceImpl();
    private final MovieService movieService = new MovieServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public SiteService getSiteService() {
        return siteService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public GenreService getGenreService() {
        return genreService;
    }

    public MovieService getMovieService() {
        return movieService;
    }
}