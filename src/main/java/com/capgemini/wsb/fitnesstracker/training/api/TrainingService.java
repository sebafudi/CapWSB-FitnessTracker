package com.capgemini.wsb.fitnesstracker.training.api;

import java.util.Optional;

public interface TrainingService {

    /**
     * Retrieves a training based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be returned.
     *
     * @param trainingId id of the training to be searched
     * @return An {@link Optional} containing the located Training, or {@link Optional#empty()} if not found
     */
    Optional<Training> getTraining(Long trainingId);

    Training createTraining(Training training);

    Training updateTraining(Long trainingId, Training training);
}
