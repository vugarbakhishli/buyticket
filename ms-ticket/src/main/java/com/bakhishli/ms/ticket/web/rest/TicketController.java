package com.bakhishli.ms.ticket.web.rest;

import com.bakhishli.ms.ticket.service.TicketService;
import com.bakhishli.ms.ticket.service.dto.TicketRequestDto;
import com.bakhishli.ms.ticket.service.dto.TicketResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{uuid}")
    public ResponseEntity<TicketResponseDto> getByUuid(@PathVariable String uuid){
        log.info("Getting ticket by id: {}", uuid);
        return ResponseEntity.ok(ticketService.getByUuid(uuid));
    }

    @GetMapping
    public ResponseEntity<Page<TicketResponseDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(ticketService.getPagination(pageable));
    }

    @PostMapping
    public ResponseEntity<TicketResponseDto> create(@RequestBody @Validated TicketRequestDto ticketRequestDto){
        log.info("Creating branch: {}", ticketRequestDto);
        return ResponseEntity.status(CREATED).body(ticketService.create(ticketRequestDto));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<TicketResponseDto> update(@PathVariable String uuid, @RequestBody @Validated
            TicketRequestDto requestDto){
        log.info("Updating branch: {}", requestDto);
        return ResponseEntity.ok(ticketService.update(uuid, requestDto));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable String uuid){
        ticketService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

}
