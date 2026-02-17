package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.MissionEvent;

import java.io.File;
import java.util.List;

public class MissionEventRepository {
    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public List<MissionEvent> findAll() throws Exception {
        // Citim din events.json
        return mapper.readValue(new File("events.json"), new TypeReference<List<MissionEvent>>() {});
    }


}