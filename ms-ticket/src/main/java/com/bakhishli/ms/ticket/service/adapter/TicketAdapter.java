package com.bakhishli.ms.ticket.service.adapter;

import com.bakhishli.ms.ticket.domain.Ticket;
import com.bakhishli.ms.ticket.service.dto.TicketRequestDto;
import com.bakhishli.ms.ticket.service.dto.TicketResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketAdapter {

    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "ticketDate", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "description", source = "ticketRequestDto.description")
    @Mapping(target = "notes", source = "ticketRequestDto.notes")
    @Mapping(target = "priorityType", source = "ticketRequestDto.priorityType")
    @Mapping(target = "ticketStatus", source = "ticketRequestDto.ticketStatus")
    Ticket map(TicketRequestDto ticketRequestDto);

    TicketResponseDto map(Ticket ticket);
}
