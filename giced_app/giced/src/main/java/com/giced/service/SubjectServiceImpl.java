package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.SubjectDao;
import com.giced.model.Subject;

@Service
@Component
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;

	@Autowired	
    public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	@Autowired
	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	@Override
    @Transactional
	public void addSubject(Subject subject) {
    	subjectDao.addSubject(subject);

	}

    @Override
    @Transactional
	public void updateSubject(Subject subject) {
    	subjectDao.updateSubject(subject);
	}

    @Override
    @Transactional
    public void removeSubject(String id) {
    	subjectDao.removeSubject(id);
	}

    @Override
    @Transactional
	public Subject getSubject(String id) {
		return subjectDao.getSubject(id);
	}

    @Override
    @Transactional
	public List<Subject> getSubjects(Integer page) {
    	return subjectDao.getSubjects(page);
	}

    @Override
    @Transactional
	public List<Subject> getAllSubjects() {
		return subjectDao.getAllSubjects();
	}

}
