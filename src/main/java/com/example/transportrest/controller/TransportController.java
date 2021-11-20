package com.example.transportrest.controller;

import com.example.transportrest.entiry.Transport;
import com.example.transportrest.repository.TransportRepo;
import com.example.transportrest.service.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/transports")
public class TransportController {
    private static Logger logger = LoggerFactory.getLogger(TransportController.class);

    @Autowired
    private TransportService transportService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse(HttpServletRequest request) {
        logger.info("[" + request.getRemoteAddr() + "]" + " GET / [200]");
        return ResponseEntity.ok(transportService.listAll());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Transport transport, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) {
        if (userDetails == null) {
            logger.info("[" + request.getRemoteAddr() + "]" + " POST  / [403]");
            throw new ForbiddenException();
        }

        logger.info("[" + request.getRemoteAddr() + "]" + " POST / [200]");
        return ResponseEntity.ok(transportService.add(transport));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) {
        if (userDetails == null) {
            logger.info("[" + request.getRemoteAddr() + "]" + " DELETE / [403]");
            throw new ForbiddenException();
        }

        logger.info("[" + request.getRemoteAddr() + "]" + " DELETE / [200]");
        transportService.delete(id);
    }
}
