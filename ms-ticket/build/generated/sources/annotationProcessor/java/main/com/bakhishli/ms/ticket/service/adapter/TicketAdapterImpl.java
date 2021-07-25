package com.bakhishli.ms.ticket.service.adapter;

import com.bakhishli.ms.ticket.domain.Ticket;
import com.bakhishli.ms.ticket.service.dto.TicketRequestDto;
import com.bakhishli.ms.ticket.service.dto.TicketResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-24T21:51:07+0400",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class TicketAdapterImpl implements TicketAdapter {

    @Override
    public Ticket map(TicketRequestDto ticketRequestDto) {
        if ( ticketRequestDto == null ) {
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setDescription( ticketRequestDto.getDescription() );
        ticket.setNotes( ticketRequestDto.getNotes() );
        ticket.setPriorityType( ticketRequestDto.getPriorityType() );
        ticket.setTicketStatus( ticketRequestDto.getTicketStatus() );

        return ticket;
    }

    @Override
    public TicketResponseDto map(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }

        TicketResponseDto ticketResponseDto = new TicketResponseDto();

        ticketResponseDto.setUuid( ticket.getUuid() );
        ticketResponseDto.setDescription( ticket.getDescription() );
        ticketResponseDto.setNotes( ticket.getNotes() );
        ticketResponseDto.setAssignee( ticket.getAssignee() );
        ticketResponseDto.setTicketDate( ticket.getTicketDate() );
        ticketResponseDto.setPriorityType( ticket.getPriorityType() );
        ticketResponseDto.setTicketStatus( ticket.getTicketStatus() );

        return ticketResponseDto;
    }
}
