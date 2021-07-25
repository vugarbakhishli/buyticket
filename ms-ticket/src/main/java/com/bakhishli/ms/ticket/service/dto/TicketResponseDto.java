package com.bakhishli.ms.ticket.service.dto;

import com.bakhishli.ms.ticket.domain.enums.PriorityType;
import com.bakhishli.ms.ticket.domain.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {

    private String uuid;
    private String description;

    private String notes;

    private String assignee;

    private Date ticketDate;

    private PriorityType priorityType;

    private TicketStatus ticketStatus;
}
