package com.kodilla.project.mapper;

import com.kodilla.project.domain.Group;
import com.kodilla.project.domain.dto.GroupDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(
                groupDto.getId(),
                groupDto.getName()
        );
    }

    public GroupDto mapToGroupDto(final Group group) {
        return new GroupDto(
                group.getId(),
                group.getName()
        );
    }

    public List<Group> mapToGroupList(final List<GroupDto> groupDtoList) {
        return groupDtoList.stream()
                .map(this::mapToGroup)
                .collect(Collectors.toList());
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groupList) {
        return groupList.stream()
                .map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }
}
