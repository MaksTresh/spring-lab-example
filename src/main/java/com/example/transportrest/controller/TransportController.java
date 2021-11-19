package com.example.transportrest.controller;

import com.example.transportrest.repository.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transports")
public class TransportController {
    @Autowired
    private TransportRepo transportRepo;
}
