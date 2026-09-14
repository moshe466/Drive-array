package org.apache.tika.metadata.filter;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.tika.config.Field;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.Param;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class CaptureGroupMetadataFilter extends MetadataFilter implements Initializable {
    private Pattern regex;
    private String regexString;
    private String sourceField;
    private String targetField;

    @Override // org.apache.tika.config.Initializable
    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
        if (!StringUtils.isBlank(this.sourceField)) {
            if (!StringUtils.isBlank(this.targetField)) {
                return;
            } else {
                throw new TikaConfigException("Must specify a 'targetField'");
            }
        }
        throw new TikaConfigException("Must specify a 'sourceField'");
    }

    @Override // org.apache.tika.metadata.filter.MetadataFilter
    public void filter(Metadata metadata) {
        String str = metadata.get(this.sourceField);
        if (!StringUtils.isBlank(str)) {
            Matcher matcher = this.regex.matcher(str);
            if (matcher.find()) {
                metadata.set(this.targetField, matcher.group(1));
            }
        }
    }

    public String getRegex() {
        return this.regexString;
    }

    public String getSourceField() {
        return this.sourceField;
    }

    public String getTargetField() {
        return this.targetField;
    }

    @Override // org.apache.tika.config.Initializable
    public void initialize(Map<String, Param> map) {
        try {
            this.regex = Pattern.compile(this.regexString);
        } catch (PatternSyntaxException e4) {
            throw new TikaConfigException("Couldn't parse regex", e4);
        }
    }

    @Field
    public void setRegex(String str) {
        this.regexString = str;
    }

    @Field
    public void setSourceField(String str) {
        this.sourceField = str;
    }

    @Field
    public void setTargetField(String str) {
        this.targetField = str;
    }
}
