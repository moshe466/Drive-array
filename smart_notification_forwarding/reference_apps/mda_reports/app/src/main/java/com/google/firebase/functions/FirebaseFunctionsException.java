package com.google.firebase.functions;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseException;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FirebaseFunctionsException extends FirebaseException {

    @NonNull
    private final Code code;

    @Nullable
    private final Object details;

    /* loaded from: classes2.dex */
    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);

        private static final SparseArray<Code> STATUS_LIST = buildStatusList();
        private final int value;

        Code(int i) {
            this.value = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Code a(int i) {
            if (i == 200) {
                return OK;
            }
            if (i == 409) {
                return ABORTED;
            }
            if (i == 429) {
                return RESOURCE_EXHAUSTED;
            }
            if (i == 400) {
                return INVALID_ARGUMENT;
            }
            if (i == 401) {
                return UNAUTHENTICATED;
            }
            if (i == 403) {
                return PERMISSION_DENIED;
            }
            if (i == 404) {
                return NOT_FOUND;
            }
            if (i == 503) {
                return UNAVAILABLE;
            }
            if (i == 504) {
                return DEADLINE_EXCEEDED;
            }
            switch (i) {
                case 499:
                    return CANCELLED;
                case ERROR_VALUE:
                    return INTERNAL;
                case 501:
                    return UNIMPLEMENTED;
                default:
                    return UNKNOWN;
            }
        }

        private static SparseArray<Code> buildStatusList() {
            SparseArray<Code> sparseArray = new SparseArray<>();
            for (Code code : values()) {
                Code code2 = sparseArray.get(code.ordinal());
                if (code2 != null) {
                    throw new IllegalStateException("Code value duplication between " + code2 + "&" + code.name());
                }
                sparseArray.put(code.ordinal(), code);
            }
            return sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseFunctionsException(@NonNull String str, @NonNull Code code, @Nullable Object obj) {
        super(str);
        this.code = code;
        this.details = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseFunctionsException(@NonNull String str, @NonNull Code code, @Nullable Object obj, Throwable th) {
        super(str, th);
        this.code = code;
        this.details = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static FirebaseFunctionsException a(Code code, @Nullable String str, Serializer serializer) {
        Object obj;
        String name = code.name();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("error");
            if (jSONObject.opt("status") instanceof String) {
                code = Code.valueOf(jSONObject.getString("status"));
                name = code.name();
            }
            if ((jSONObject.opt(SettingsJsonConstants.PROMPT_MESSAGE_KEY) instanceof String) && !jSONObject.getString(SettingsJsonConstants.PROMPT_MESSAGE_KEY).isEmpty()) {
                name = jSONObject.getString(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            }
            obj = jSONObject.opt("details");
            if (obj != null) {
                try {
                    obj = serializer.decode(obj);
                } catch (IllegalArgumentException unused) {
                    code = Code.INTERNAL;
                    name = code.name();
                } catch (JSONException unused2) {
                }
            }
        } catch (IllegalArgumentException unused3) {
            obj = null;
        } catch (JSONException unused4) {
            obj = null;
        }
        if (code == Code.OK) {
            return null;
        }
        return new FirebaseFunctionsException(name, code, obj);
    }

    @NonNull
    public Code getCode() {
        return this.code;
    }

    @Nullable
    public Object getDetails() {
        return this.details;
    }
}
