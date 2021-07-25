package com.bakhishli.ms.ticket.domain.elasticsearch;

import com.bakhishli.ms.ticket.domain.AbstractAuditingEntity;
import com.bakhishli.ms.ticket.domain.enums.PriorityType;
import com.bakhishli.ms.ticket.domain.enums.TicketStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "ms_ticket-elasticsearch")
public class TicketElasticsearch extends AbstractAuditingEntity {

    @Id
    private String id;

    private String description;
    private String notes;
    private String assignee;
    private Date ticketDate;
    private PriorityType priorityType;
    private TicketStatus ticketStatus;
}
