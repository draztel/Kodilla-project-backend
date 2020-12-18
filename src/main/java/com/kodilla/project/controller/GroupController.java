package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET, value = "/groups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/groups/{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) {
        return new GroupDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/groups/{groupId}")
    public void deleteGroup(@PathVariable Long groupId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/groups")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return new GroupDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/groups", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {

    }
}
