package com.kodilla.project.service;

import com.kodilla.project.domain.Group;
import com.kodilla.project.repository.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupDbService {
    @Autowired
    private GroupDao groupDao;

    public List<Group> getGroups() {
        return groupDao.findAll();
    }

    public Optional<Group> getGroup(final Long id) {
        return groupDao.findById(id);
    }

    public Group saveGroup(final Group group) {
        return groupDao.save(group);
    }

    public void deleteGroup(final Long id) {
        groupDao.deleteById(id);
    }
}
