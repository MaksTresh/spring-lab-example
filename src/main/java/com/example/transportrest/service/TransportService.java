package com.example.transportrest.service;

import com.example.transportrest.entiry.Transport;
import com.example.transportrest.entiry.TransportType;

import java.sql.Timestamp;

public interface TransportService {
    Iterable<Transport> listAll();

    void delete(Long id);

    Transport add(Transport transport);
}
