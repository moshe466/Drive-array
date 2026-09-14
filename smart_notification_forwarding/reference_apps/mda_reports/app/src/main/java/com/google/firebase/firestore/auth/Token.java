package com.google.firebase.firestore.auth;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Token {
    private final User user;

    @Nullable
    private final String value;

    public Token(@Nullable String str, User user) {
        this.value = str;
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    @Nullable
    public String getValue() {
        return this.value;
    }
}
