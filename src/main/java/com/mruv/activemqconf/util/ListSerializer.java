package com.mruv.activemqconf.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mruv.activemqconf.domain.model.SystemUser;
import java.io.IOException;
import java.util.List;

public class ListSerializer extends JsonSerializer<List<SystemUser>> {

    @Override
    public void serialize(List<SystemUser> value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeString(new ObjectMapper().writeValueAsString(value));
    }

}
