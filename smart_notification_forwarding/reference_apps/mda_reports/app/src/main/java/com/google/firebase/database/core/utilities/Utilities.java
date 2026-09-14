package com.google.firebase.database.core.utilities;

import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.RepoInfo;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public class Utilities {
    private static final char[] HEX_CHARACTERS = "0123456789abcdef".toCharArray();

    /* JADX WARN: Multi-variable type inference failed */
    public static <C> C castOrNull(Object obj, Class<C> cls) {
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        return null;
    }

    public static int compareInts(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compareLongs(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static String doubleToHashString(double d) {
        StringBuilder sb = new StringBuilder(16);
        long doubleToLongBits = Double.doubleToLongBits(d);
        for (int i = 7; i >= 0; i--) {
            int i2 = (int) ((doubleToLongBits >>> (i * 8)) & 255);
            sb.append(HEX_CHARACTERS[(i2 >> 4) & 15]);
            sb.append(HEX_CHARACTERS[i2 & 15]);
        }
        return sb.toString();
    }

    private static String extractPathString(String str) {
        int indexOf = str.indexOf("//");
        if (indexOf == -1) {
            throw new DatabaseException("Firebase Database URL is missing URL scheme");
        }
        String substring = str.substring(indexOf + 2);
        int indexOf2 = substring.indexOf("/");
        if (indexOf2 == -1) {
            return "";
        }
        int indexOf3 = substring.indexOf("?");
        int i = indexOf2 + 1;
        return indexOf3 != -1 ? substring.substring(i, indexOf3) : substring.substring(i);
    }

    public static <C> C getOrNull(Object obj, String str, Class<C> cls) {
        Object obj2;
        if (obj == null || (obj2 = ((Map) castOrNull(obj, Map.class)).get(str)) == null) {
            return null;
        }
        return (C) castOrNull(obj2, cls);
    }

    public static void hardAssert(boolean z) {
        hardAssert(z, "");
    }

    public static void hardAssert(boolean z, String str) {
        if (z) {
            return;
        }
        throw new AssertionError("hardAssert failed: " + str);
    }

    public static ParsedUrl parseUrl(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (scheme == null) {
                throw new IllegalArgumentException("Database URL does not specify a URL scheme");
            }
            String host = parse.getHost();
            if (host == null) {
                throw new IllegalArgumentException("Database URL does not specify a valid host");
            }
            RepoInfo repoInfo = new RepoInfo();
            repoInfo.host = host.toLowerCase();
            int port = parse.getPort();
            boolean z = true;
            if (port != -1) {
                if (!scheme.equals("https") && !scheme.equals("wss")) {
                    z = false;
                }
                repoInfo.secure = z;
                repoInfo.host += ":" + port;
            } else {
                repoInfo.secure = true;
            }
            String queryParameter = parse.getQueryParameter("ns");
            if (queryParameter == null) {
                queryParameter = host.split("\\.", -1)[0].toLowerCase();
            }
            repoInfo.namespace = queryParameter;
            repoInfo.internalHost = repoInfo.host;
            String replace = extractPathString(str).replace("+", " ");
            Validation.validateRootPathString(replace);
            ParsedUrl parsedUrl = new ParsedUrl();
            parsedUrl.path = new Path(replace);
            parsedUrl.repoInfo = repoInfo;
            return parsedUrl;
        } catch (Exception e) {
            throw new DatabaseException("Invalid Firebase Database url specified: " + str, e);
        }
    }

    public static String sha1HexDigest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(CommonUtils.SHA1_INSTANCE);
            messageDigest.update(str.getBytes(HttpRequest.CHARSET_UTF8));
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e);
        }
    }

    public static String stringHashV2Representation(String str) {
        String replace = str.indexOf(92) != -1 ? str.replace("\\", "\\\\") : str;
        if (str.indexOf(34) != -1) {
            replace = replace.replace("\"", "\\\"");
        }
        return Typography.quote + replace + Typography.quote;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
    
        if (r2 > 2147483647L) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer tryParseInt(java.lang.String r8) {
        /*
            int r0 = r8.length()
            r1 = 0
            r2 = 11
            if (r0 > r2) goto L5d
            int r0 = r8.length()
            if (r0 != 0) goto L10
            goto L5d
        L10:
            r0 = 0
            char r2 = r8.charAt(r0)
            r3 = 45
            r4 = 1
            if (r2 != r3) goto L23
            int r0 = r8.length()
            if (r0 != r4) goto L21
            return r1
        L21:
            r0 = 1
            goto L24
        L23:
            r4 = 0
        L24:
            r2 = 0
        L26:
            int r5 = r8.length()
            if (r0 >= r5) goto L45
            char r5 = r8.charAt(r0)
            r6 = 48
            if (r5 < r6) goto L44
            r6 = 57
            if (r5 <= r6) goto L39
            goto L44
        L39:
            r6 = 10
            long r2 = r2 * r6
            int r5 = r5 + (-48)
            long r5 = (long) r5
            long r2 = r2 + r5
            int r0 = r0 + 1
            goto L26
        L44:
            return r1
        L45:
            if (r4 == 0) goto L56
            long r2 = -r2
            r4 = -2147483648(0xffffffff80000000, double:NaN)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L50
            return r1
        L50:
            int r8 = (int) r2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            return r8
        L56:
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L50
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.utilities.Utilities.tryParseInt(java.lang.String):java.lang.Integer");
    }

    public static Pair<Task<Void>, DatabaseReference.CompletionListener> wrapOnComplete(DatabaseReference.CompletionListener completionListener) {
        if (completionListener != null) {
            return new Pair<>(null, completionListener);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        return new Pair<>(taskCompletionSource.getTask(), new DatabaseReference.CompletionListener() { // from class: com.google.firebase.database.core.utilities.Utilities.1
            @Override // com.google.firebase.database.DatabaseReference.CompletionListener
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    TaskCompletionSource.this.setException(databaseError.toException());
                } else {
                    TaskCompletionSource.this.setResult(null);
                }
            }
        });
    }
}
