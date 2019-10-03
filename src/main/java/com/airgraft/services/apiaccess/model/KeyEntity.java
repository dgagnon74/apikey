package com.airgraft.services.apiaccess.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "apikey")
public class KeyEntity implements Serializable {
    private static final long serialVersionUID = -2343243243242432341L;

    /**
     * The key
     */
    @Id
    private String id;

    /**
     * Owner of the key
     */
    @Column(name = "clientId")
    private String clientId;

    /**
     * Basic support to suspend a key
     */
    @Column(name = "active")
    private Boolean active = Boolean.TRUE;

    public KeyEntity() {
    }

    public KeyEntity(String clientId) {
        this.clientId = clientId;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}