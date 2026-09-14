package io.fabric.sdk.android.services.persistence;

/* loaded from: classes2.dex */
public interface SerializationStrategy<T> {
    T deserialize(String str);

    String serialize(T t);
}
