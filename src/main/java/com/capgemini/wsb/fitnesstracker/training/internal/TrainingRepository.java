package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Date;

interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findTrainingsByActivityType(ActivityType activityType);
    List<Training> findTrainingsByEndTimeAfter(Date date);
    List<Training> findTrainingsByUserId(long userId);
}