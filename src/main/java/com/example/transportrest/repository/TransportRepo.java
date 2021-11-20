package com.example.transportrest.repository;

import com.example.transportrest.entiry.Transport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface TransportRepo extends CrudRepository<Transport, Long> {
}
