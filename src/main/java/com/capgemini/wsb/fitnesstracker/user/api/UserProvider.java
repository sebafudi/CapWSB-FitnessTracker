package com.capgemini.wsb.fitnesstracker.user.api;

import java.util.List;
import java.util.Optional;

/**
 * Interface (API) for retrieving operations on {@link User} entities through
 * the
 * API.
 */
public interface UserProvider {

    /**
     * Retrieves a user based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be
     * returned.
     *
     * @param userId id of the user to be searched
     * @return An {@link Optional} containing the located user, or
     *         {@link Optional#empty()} if not found
     */
    Optional<User> getUser(Long userId);

    /**
     * Retrieves list of users based on their email.
     * 
     * @param email email of the user to be searched
     * @return {@link List} containing the located users
     */
    List<User> getUserByEmail(String email);

    /**
     * Retrieves all users.
     *
     * @return An {@link List} containing the all users,
     */
    List<User> findAllUsers();

    /**
     * Retrieves all users older than given birth date.
     *
     * @param birthDate birth date to compare
     * @return list of users older than given birth date
     */
    List<User> findOlderThan(String birthDate);
}
