package com.bakhishli.ms.ticket.repository.elasticsearch;

import com.bakhishli.ms.ticket.domain.elasticsearch.TicketElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketElasticsearchRepository extends ElasticsearchRepository<TicketElasticsearch, String> {

}
