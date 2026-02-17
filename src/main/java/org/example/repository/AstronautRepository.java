package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Astronaut;

import java.io.File;
import java.util.List;

public class AstronautRepository {
    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public List<Astronaut> findAll() throws Exception {
        // Citim din astronauts.json
        return mapper.readValue(new File("astronauts.json"), new TypeReference<List<Astronaut>>() {});
    }


}