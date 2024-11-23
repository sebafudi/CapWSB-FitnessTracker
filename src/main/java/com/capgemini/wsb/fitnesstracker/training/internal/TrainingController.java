package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
class TrainingController {

    private final TrainingServiceImpl trainingService;
    private final TrainingMapper trainingMapper;

    /**
     * This method returns all trainings.
     *
     * @return List of all trainings
     */
    @GetMapping
    public ResponseEntity<List<TrainingDto>> getAllTrainings() {
        return new ResponseEntity<>(trainingService.findAllTrainings()
                .stream()
                .map(trainingMapper::toDto)
                .toList(), HttpStatus.OK);
    }

    /**
     * This method creates a new training in the database.
     *
     * @param trainingDto A training that will be created
     * @return Created training
     */
    @PostMapping
    public ResponseEntity<Training> createTraining(@RequestBody TrainingDto trainingDto) {
        Training createdTraining = trainingService.createTraining(trainingMapper.toEntity(trainingDto));
        return new ResponseEntity<>(createdTraining, HttpStatus.CREATED);
    }

    /**
     * This method gets all trainings of given user.
     *
     * @param userId id of the user
     * @return list of all trainings of the user
     */
    @GetMapping("/{userId}")
    public ResponseEntity<List<TrainingDto>> getTrainingsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(trainingService.getTrainingsByUserId(userId).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    /**
     * This method gets all trainings with given activity type
     *
     * @param activityType the activity type to search for
     * @return list of all trainings of given activity type
     */
    @GetMapping("/activityType")
    public ResponseEntity<List<TrainingDto>> getTrainingsByActivityType(@RequestParam ActivityType activityType) {
        return new ResponseEntity<>(trainingService.getTrainingsByActivityType(activityType).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    /**
     * This method gets all trainings finished after given date
     *
     * @param afterTime - date (string) in format yyyy-MM-dd
     * @return list of all trainings finished after given date
     */
    @GetMapping("/finished/{afterTime}")
    public ResponseEntity<List<TrainingDto>> getTrainingsFinishedAfterTime(@PathVariable String afterTime) {
        return new ResponseEntity<>(trainingService.getTrainingsFinishedAfterTime(afterTime).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    /**
     * This method updates given training in the database
     *
     * @param trainingId id of the training to be updated
     * @param trainingDto training data that will be used to override present training
     * @return updated training
     */
    @PutMapping("/{trainingId}")
    public ResponseEntity<TrainingDto> updateTraining(@PathVariable Long trainingId, @RequestBody TrainingDto trainingDto) {
        Training updatedTraining = trainingService.updateTraining(trainingId, trainingMapper.toEntity(trainingDto));
        return new ResponseEntity<>(trainingMapper.toDto(updatedTraining), HttpStatus.OK);
    }
}