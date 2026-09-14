package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes2.dex */
public interface AuthProviderOrBuilder extends MessageLiteOrBuilder {
    String getAudiences();

    ByteString getAudiencesBytes();

    String getAuthorizationUrl();

    ByteString getAuthorizationUrlBytes();

    String getId();

    ByteString getIdBytes();

    String getIssuer();

    ByteString getIssuerBytes();

    String getJwksUri();

    ByteString getJwksUriBytes();
}
