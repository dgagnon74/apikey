package com.airgraft.services.apiaccess.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(description = "Key Creation Request. Typically sent following a client action to get a key for its own uses ")
public class ApiKeyRequest {

    @ApiModelProperty(notes = "The ID of the client owner of the key")
    @NotEmpty(message = "Please provide a clientId")
    private String clientId;

    @ApiModelProperty(notes = "The requested SLA")
    private String requestedSlaId;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRequestedSlaId() {
        return requestedSlaId;
    }

    public void setRequestedSlaId(String requestedSlaId) {
        this.requestedSlaId = requestedSlaId;
    }
}
