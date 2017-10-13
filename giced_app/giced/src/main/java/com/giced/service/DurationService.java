package com.giced.service;

import java.util.List;

import com.giced.model.Duration;



public interface DurationService {

	void addDuration(Duration duration);

    void updateDuration(Duration duration);

    void removeDuration(String id);

    Duration getDuration(String id);

    List<Duration> getDurations(Integer page);

    List<Duration> getAllDurations();
}
