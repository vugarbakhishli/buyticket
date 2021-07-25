package com.bakhishli.ms.ticket.service.dto;

import com.bakhishli.ms.ticket.domain.enums.PriorityType;
import com.bakhishli.ms.ticket.domain.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDto {

    @NotBlank
    private String description;

    @NotBlank
    private String notes;

    private String assignee;

    @NotBlank
    private Date ticketDate;

    @NotNull
    private PriorityType priorityType;

    @NotNull
    private TicketStatus ticketStatus;
}
