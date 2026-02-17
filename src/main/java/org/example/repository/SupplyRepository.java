package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Supply;

import java.io.File;
import java.util.List;

public class SupplyRepository {
    private final ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public List<Supply> findAll() throws Exception {
        // Citim din supplies.json
        return mapper.readValue(new File("supplies.json"), new TypeReference<List<Supply>>() {});
    }


}