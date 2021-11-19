package com.example.transportrest.repository;

import com.example.transportrest.entiry.Transport;
import com.example.transportrest.entiry.TransportType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface TransportRepo extends PagingAndSortingRepository<Transport, Long> {

    @RestResource(rel = "race-name-contains", path="race-name")
    Page<Transport> findByRaceNameContaining(@Param("query") String query, Pageable page);

    @RestResource(rel = "transport-type", path="transport-type")
    Page<Transport> getByTransportType(@Param("query") TransportType transportType, Pageable pageable);
}
