package by.bsuir.movierating.service;

/**
 * Provides a business-logic with the Rating entity.
 *
 * @author Kostevich Vladislav
 * @version 1.0
 */
public interface RatingService {
    /**
     * Returns a value of the rating belonging to the movie and to the user (if exists).
     *
     * @param movieId an id of the movie
     * @param userId an id of the user
     * @return a value of the rating
     */
    int getRatingValueByMovieAndUser(int movieId, int userId);

    /**
     * Adds a new rating to the data storage.
     *
     * @param value a value of the rating
     * @param movieId an id of the movie to which the rating belongs
     * @param userId an id of the user to which the rating belongs
     */
    void addRating(int value, int movieId, int userId);

    /**
     * Deletes an existing rating from the data storage.
     *
     * @param movieId an id of the movie to which the rating belongs
     * @param userId an id of the user to which the rating belongs
     */
    void deleteRating(int movieId, int userId);
}
