package com.mruv.activemqconf.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mruv.activemqconf.domain.model.SystemUser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ListDeserializer extends JsonDeserializer<List<SystemUser>> {

    @Override
    public List<SystemUser> deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        LOG.info(p.getValueAsString());
        return new ArrayList<>();
    }
    private static final Logger LOG = Logger.getLogger(ListDeserializer.class.getName());
}
