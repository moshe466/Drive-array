package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

/* loaded from: classes.dex */
public class JacksonYAMLParseException extends JsonParseException {
    private static final long serialVersionUID = 1;

    public JacksonYAMLParseException(JsonParser jsonParser, String str, Exception exc) {
        super(jsonParser, str, exc);
    }
}
