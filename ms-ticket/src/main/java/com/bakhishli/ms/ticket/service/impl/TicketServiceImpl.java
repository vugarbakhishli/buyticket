package com.bakhishli.ms.ticket.service.impl;

import com.bakhishli.ms.ticket.domain.Ticket;
import com.bakhishli.ms.ticket.domain.elasticsearch.TicketElasticsearch;
import com.bakhishli.ms.ticket.repository.TicketRepository;
import com.bakhishli.ms.ticket.repository.elasticsearch.TicketElasticsearchRepository;
import com.bakhishli.ms.ticket.service.TicketService;
import com.bakhishli.ms.ticket.service.adapter.TicketAdapter;
import com.bakhishli.ms.ticket.service.dto.TicketRequestDto;
import com.bakhishli.ms.ticket.service.dto.TicketResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketElasticsearchRepository ticketElasticsearchRepository;
    private final TicketAdapter ticketAdapter;

    @Override
    @Transactional
    public TicketResponseDto create(TicketRequestDto ticketRequestDto) {
        //Ticket ticket = new Ticket();
        // TODO: Verify from AccountController
        //ticket.setAssignee();
//
//        ticket.setDescription(ticketRequestDto.getDescription());
//        ticket.setNotes(ticketRequestDto.getNotes());
//        ticket.setTicketDate(ticketRequestDto.getTicketDate());
//        ticket.setTicketStatus(ticketRequestDto.getTicketStatus());
//        ticket.setPriorityType(ticketRequestDto.getPriorityType());
//        ticket = ticketRepository.save(ticket);
        Ticket ticket = ticketAdapter.map(ticketRequestDto);
        ticket = ticketRepository.save(ticket);

        TicketElasticsearch ticketElasticsearch = TicketElasticsearch.builder()
                                                .description(ticket.getDescription())
                                                .notes(ticket.getNotes())
                                                .ticketStatus(ticket.getTicketStatus())
                                                .priorityType(ticket.getPriorityType())
                                                .id(ticket.getUuid())
                                                .ticketDate(ticket.getTicketDate())
                                                .build();

        ticketElasticsearchRepository.save(ticketElasticsearch);
        return ticketAdapter.map(ticket);
    }

    @Override
    public TicketResponseDto update(String id, TicketRequestDto ticketRequestDto) {
        return null;
    }

    @Override
    public TicketResponseDto getByUuid(String uuid) {
        return null;
    }

    @Override
    public Page<TicketResponseDto> getPagination(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }
}
