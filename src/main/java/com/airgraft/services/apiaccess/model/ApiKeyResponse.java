package com.airgraft.services.apiaccess.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Api Key Response containing Key related information ")
public class ApiKeyResponse {

    @ApiModelProperty(notes = "The key itself")
    private String keyId;
    @ApiModelProperty(notes = "Is this key active ?")
    private Boolean active;

    public ApiKeyResponse() {
    }

    public ApiKeyResponse(KeyEntity keyEntity) {
        this.keyId = keyEntity.getId();
        this.active = keyEntity.getActive();
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
