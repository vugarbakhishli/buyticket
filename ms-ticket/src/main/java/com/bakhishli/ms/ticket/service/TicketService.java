package com.bakhishli.ms.ticket.service;

import com.bakhishli.ms.ticket.service.dto.TicketRequestDto;
import com.bakhishli.ms.ticket.service.dto.TicketResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    TicketResponseDto getByUuid(String uuid);
    Page<TicketResponseDto> getPagination(Pageable pageable);
    TicketResponseDto create(TicketRequestDto ticketRequestDto);
    TicketResponseDto update(String uuid, TicketRequestDto ticketRequestDto);
    void delete(String uuid);
}
