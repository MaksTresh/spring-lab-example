package com.example.transportrest.entiry;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String raceName;
    private Timestamp date;

    @Enumerated(EnumType.ORDINAL)
    private TransportType transportType;

    public Transport() {
    }

    public Transport(String raceName, Timestamp date, TransportType transportType) {
        this.raceName = raceName;
        this.date = date;
        this.transportType = transportType;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Long getId() {
        return id;
    }

    public String getRaceName() {
        return raceName;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }
}
