package com.example.transportrest.service;

import com.example.transportrest.entiry.Transport;
import com.example.transportrest.entiry.TransportType;
import com.example.transportrest.repository.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class TransportServiceImpl implements TransportService {
    @Autowired
    private TransportRepo transportRepo;

    @Override
    public Iterable<Transport> listAll() {
        return transportRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        transportRepo.deleteById(id);
    }

    @Override
    public Transport add(Transport transport) {
        return transportRepo.save(transport);
    }
}
