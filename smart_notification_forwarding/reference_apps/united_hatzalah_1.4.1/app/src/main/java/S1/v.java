package s1;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final long f6325a;

    public v(long j2) {
        this.f6325a = j2;
    }

    public static v a(BufferedReader bufferedReader) {
        JsonReader jsonReader = new JsonReader(bufferedReader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        return new v(Long.parseLong(jsonReader.nextString()));
                    }
                    return new v(jsonReader.nextLong());
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof v) && this.f6325a == ((v) obj).f6325a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f6325a;
        return ((int) ((j2 >>> 32) ^ j2)) ^ 1000003;
    }

    public final String toString() {
        return e0.a.g(new StringBuilder("LogResponse{nextRequestWaitMillis="), this.f6325a, "}");
    }
}
