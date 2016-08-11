package by.epam.movierating.dao.impl.mysql;

import by.epam.movierating.dao.interfaces.MovieCountryDAO;
import by.epam.movierating.dao.exception.DAOException;
import by.epam.movierating.dao.pool.mysql.MySQLConnectionPool;
import by.epam.movierating.dao.pool.mysql.MySQLConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Владислав on 19.06.2016.
 */
public class MySQLMovieCountryDAO implements MovieCountryDAO {
    private static final String ADD_MOVIE_TO_COUNTRY_QUERY = "INSERT INTO movie_country " +
            "(movie_id, country_id) VALUES (?, ?)";
    private static final String DELETE_MOVIE_FORM_COUNTRY_QUERY = "DELETE FROM movie_country WHERE movie_id = ? AND country_id = ?";

    @Override
    public void addMovieToCountry(int movieId, int countryId) throws DAOException {
        MySQLConnectionPool mySQLConnectionPool = MySQLConnectionPool.getInstance();
        Connection connection = null;
        try {
            connection = mySQLConnectionPool.getConnection();
        } catch (InterruptedException | MySQLConnectionPoolException e) {
            throw new DAOException("Cannot get a connection from Connection Pool", e);
        }

        try {
            PreparedStatement statement = connection.prepareStatement(ADD_MOVIE_TO_COUNTRY_QUERY);
            statement.setInt(1, movieId);
            statement.setInt(2, countryId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Exception in DAO layer when adding movie to country", e);
        } finally {
            try {
                mySQLConnectionPool.freeConnection(connection);
            } catch (SQLException | MySQLConnectionPoolException e) {
                throw new DAOException("Cannot free a connection from Connection Pool", e);
            }
        }
    }

    @Override
    public void deleteMovieFromCountry(int movieId, int countryId) throws DAOException {
        MySQLConnectionPool mySQLConnectionPool = MySQLConnectionPool.getInstance();
        Connection connection = null;
        try {
            connection = mySQLConnectionPool.getConnection();
        } catch (InterruptedException | MySQLConnectionPoolException e) {
            throw new DAOException("Cannot get a connection from Connection Pool", e);
        }

        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_MOVIE_FORM_COUNTRY_QUERY);
            statement.setInt(1, movieId);
            statement.setInt(2, countryId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Exception in DAO layer when deleting movie from country", e);
        } finally {
            try {
                mySQLConnectionPool.freeConnection(connection);
            } catch (SQLException | MySQLConnectionPoolException e) {
                throw new DAOException("Cannot free a connection from Connection Pool", e);
            }
        }
    }
}
