package com.fasterxml.jackson.dataformat.yaml.snakeyaml.error;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.dataformat.yaml.JacksonYAMLParseException;

@Deprecated
/* loaded from: classes.dex */
public class YAMLException extends JacksonYAMLParseException {
    private static final long serialVersionUID = 1;

    public YAMLException(JsonParser jsonParser, org.yaml.snakeyaml.error.YAMLException yAMLException) {
        super(jsonParser, yAMLException.getMessage(), yAMLException);
    }

    public static YAMLException from(JsonParser jsonParser, org.yaml.snakeyaml.error.YAMLException yAMLException) {
        return new YAMLException(jsonParser, yAMLException);
    }
}
