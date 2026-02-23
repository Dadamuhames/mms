package com.uzum.mms.mapper;

import com.uzum.mms.dto.request.TerminalRequest;
import com.uzum.mms.dto.response.TerminalResponse;
import com.uzum.mms.entity.TerminalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TerminalMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "terminalStatus",constant = "ACTIVE")
    TerminalEntity toEntity(TerminalRequest terminalRequest);

    TerminalResponse toResponse(TerminalEntity terminal);
}
