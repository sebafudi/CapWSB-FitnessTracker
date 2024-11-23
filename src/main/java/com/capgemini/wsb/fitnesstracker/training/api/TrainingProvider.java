package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;

import java.util.List;

public interface TrainingProvider {

    /**
     * Gets all trainings.
     *
     * @return A list of all trainings
     */
    List<Training> findAllTrainings();

    /**
     * Gets all trainings by activity type.
     *
     * @param activityType activity type to be searched for
     * @return A list of all trainings
     */
    List<Training> getTrainingsByActivityType(ActivityType activityType);

    /**
     * This method gets all trainings finished after given date
     *
     * @param afterTime - date (string) in format yyyy-MM-dd
     * @return list of all trainings finished after given date
     */
    List<Training> getTrainingsFinishedAfterTime(String afterTime);

    /**
     * This method gets all trainings of given user.
     *
     * @param userId id of the user
     * @return list of all trainings of the user
     */
    List<Training> getTrainingsByUserId(Long userId);
}
