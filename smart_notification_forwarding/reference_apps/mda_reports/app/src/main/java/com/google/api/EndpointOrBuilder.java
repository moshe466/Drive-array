package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface EndpointOrBuilder extends MessageLiteOrBuilder {
    String getAliases(int i);

    ByteString getAliasesBytes(int i);

    int getAliasesCount();

    List<String> getAliasesList();

    boolean getAllowCors();

    String getApis(int i);

    ByteString getApisBytes(int i);

    int getApisCount();

    List<String> getApisList();

    String getFeatures(int i);

    ByteString getFeaturesBytes(int i);

    int getFeaturesCount();

    List<String> getFeaturesList();

    String getName();

    ByteString getNameBytes();

    String getTarget();

    ByteString getTargetBytes();
}
