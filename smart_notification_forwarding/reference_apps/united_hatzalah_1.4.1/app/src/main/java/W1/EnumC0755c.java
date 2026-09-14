package w1;

import com.google.firebase.encoders.proto.ProtoEnum;

/* renamed from: w1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC0755c implements ProtoEnum {
    REASON_UNKNOWN(0),
    MESSAGE_TOO_OLD(1),
    CACHE_FULL(2),
    PAYLOAD_TOO_BIG(3),
    MAX_RETRIES_REACHED(4),
    INVALID_PAYLOD(5),
    SERVER_ERROR(6);


    /* renamed from: a, reason: collision with root package name */
    public final int f6718a;

    EnumC0755c(int i) {
        this.f6718a = i;
    }

    @Override // com.google.firebase.encoders.proto.ProtoEnum
    public final int getNumber() {
        return this.f6718a;
    }
}
