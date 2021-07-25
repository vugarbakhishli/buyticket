package com.bakhishli.ms.ticket.domain;

import com.bakhishli.ms.ticket.domain.enums.PriorityType;
import com.bakhishli.ms.ticket.domain.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Ticket.TABLE_NAME)
@EqualsAndHashCode(callSuper = true)
public class Ticket extends AbstractAuditingEntity {
    public static final String TABLE_NAME = "tickets";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String uuid;

    @NotBlank
    @Column(nullable = false, length = 500)
    private String description;

    @NotBlank
    @Column(name = "ticket_note", length = 4000)
    private String notes;

    @NotNull
    @Column(nullable = false)
    private String assignee;

    @NotNull
    @Column(name = "ticket_date", nullable = false)
    private Date ticketDate;

    @NotNull
    @Column(name = "priority_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PriorityType priorityType;

    @NotNull
    @Column(name = "ticket_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
