package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.GroupDto;
import com.kodilla.project.exception.NotFoundException;
import com.kodilla.project.mapper.GroupMapper;
import com.kodilla.project.service.GroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class GroupController {
    @Autowired
    private GroupDbService service;

    @Autowired
    private GroupMapper groupMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/groups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(service.getGroups());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/groups/{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) throws NotFoundException {
        return groupMapper.mapToGroupDto(service.getGroup(groupId).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/groups/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {
        service.deleteGroup(groupId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/groups")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(service.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/groups", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        service.saveGroup(groupMapper.mapToGroup(groupDto));
    }
}
