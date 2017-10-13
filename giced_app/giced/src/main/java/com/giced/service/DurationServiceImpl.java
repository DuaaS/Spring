package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.DurationDao;
import com.giced.model.Duration;

@Service
@Component
public class DurationServiceImpl implements DurationService {
	
	@Autowired
	private DurationDao durationDao;

	@Autowired	
    public DurationDao getDurationDao() {
		return durationDao;
	}

	@Autowired
	public void setDurationDao(DurationDao durationDao) {
		this.durationDao = durationDao;
	}

	@Override
    @Transactional
	public void addDuration(Duration duration) {
		durationDao.addDuration(duration);

	}

    @Override
    @Transactional
	public void updateDuration(Duration duration) {
    	durationDao.updateDuration(duration);
	}

    @Override
    @Transactional
    public void removeDuration(String id) {
    	durationDao.removeDuration(id);
	}

    @Override
    @Transactional
	public Duration getDuration(String id) {
		return durationDao.getDuration(id);
	}

    @Override
    @Transactional
	public List<Duration> getDurations(Integer page) {
    	return durationDao.getDurations(page);
	}

    @Override
    @Transactional
	public List<Duration> getAllDurations() {
		return durationDao.getAllDurations();
	}

}
