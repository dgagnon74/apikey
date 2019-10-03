package com.airgraft.services.apiaccess.controllers;

import com.airgraft.services.apiaccess.model.ApiKeyResponse;
import com.airgraft.services.apiaccess.model.ApiKeyRequest;
import com.airgraft.services.apiaccess.model.KeyEntity;
import com.airgraft.services.apiaccess.repositories.KeyRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping(value = "api/key/v1")
public class KeyController {

    static Logger LOG = LoggerFactory.getLogger(KeyController.class);

    @Autowired
    KeyRepository keyRepository;

    @ApiOperation(value = "Obtain an api key. Api keys are typically created to enable external application to access our API." +
            "This simple implementation has basic support to desactivate a key. " +
            "We can also add capacity to support SLA tier within the key itself or in the service ... " +
            "... but this is out of the scope of this assigment :-) ",
            response = ApiKeyResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the api key information"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource "),
//            This service has no access restriction
            @ApiResponse(code = 400, message = "Your request is not well formed"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiKeyResponse> getLocation(
            @PathVariable(name = "id")
            @ApiParam(value = "The api key", required = true) String keyId) {

        LOG.info("Get Api Key information = " + keyId);
        Optional<KeyEntity> maybeApiKey = keyRepository.findById(keyId);
        if (!maybeApiKey.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ApiKeyResponse apiKey = new ApiKeyResponse(maybeApiKey.get());
        return new ResponseEntity<>(apiKey, HttpStatus.OK);
    }

    @ApiOperation(value = "Request the creation of an API key. ", response = ApiKeyResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the api key information"),
            @ApiResponse(code = 400, message = "Your request is not well formed"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @PostMapping
    public ResponseEntity<ApiKeyResponse> create(@Valid @RequestBody ApiKeyRequest request) {
        LOG.info("Creating an Api Key for = " + request.getClientId());
        KeyEntity keyEntity = keyRepository.save(new KeyEntity(request.getClientId()));
        ApiKeyResponse apiKeyResponse = new ApiKeyResponse(keyEntity);
        return new ResponseEntity<>(apiKeyResponse, HttpStatus.OK);
    }


}
