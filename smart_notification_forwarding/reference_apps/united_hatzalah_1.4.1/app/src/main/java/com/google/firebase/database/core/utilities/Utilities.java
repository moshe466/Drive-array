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
import com.google.firebase.sessions.settings.RemoteSettings;
import e0.a;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public class Utilities {
    private static final char[] HEX_CHARACTERS = "0123456789abcdef".toCharArray();

    /* JADX WARN: Multi-variable type inference failed */
    public static <C> C castOrNull(Object obj, Class<C> cls) {
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        return null;
    }

    public static int compareInts(int i, int i3) {
        if (i < i3) {
            return -1;
        }
        return i == i3 ? 0 : 1;
    }

    public static int compareLongs(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    public static String doubleToHashString(double d2) {
        StringBuilder sb = new StringBuilder(16);
        long doubleToLongBits = Double.doubleToLongBits(d2);
        for (int i = 7; i >= 0; i--) {
            int i3 = (int) ((doubleToLongBits >>> (i * 8)) & 255);
            char[] cArr = HEX_CHARACTERS;
            sb.append(cArr[(i3 >> 4) & 15]);
            sb.append(cArr[i3 & 15]);
        }
        return sb.toString();
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj2 != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    private static String extractPathString(String str) {
        int indexOf = str.indexOf("//");
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 2);
            int indexOf2 = substring.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
            if (indexOf2 != -1) {
                int indexOf3 = substring.indexOf("?");
                if (indexOf3 != -1) {
                    return substring.substring(indexOf2 + 1, indexOf3);
                }
                return substring.substring(indexOf2 + 1);
            }
            return "";
        }
        throw new DatabaseException("Firebase Database URL is missing URL scheme");
    }

    public static <C> C getOrNull(Object obj, String str, Class<C> cls) {
        Object obj2;
        if (obj == null || (obj2 = ((Map) castOrNull(obj, Map.class)).get(str)) == null) {
            return null;
        }
        return (C) castOrNull(obj2, cls);
    }

    public static void hardAssert(boolean z3, String str) {
    }

    public static ParsedUrl parseUrl(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (scheme != null) {
                String host = parse.getHost();
                if (host != null) {
                    String queryParameter = parse.getQueryParameter("ns");
                    boolean z3 = false;
                    if (queryParameter == null) {
                        queryParameter = host.split("\\.", -1)[0].toLowerCase(Locale.US);
                    }
                    RepoInfo repoInfo = new RepoInfo();
                    repoInfo.host = host.toLowerCase(Locale.US);
                    int port = parse.getPort();
                    if (port != -1) {
                        if (scheme.equals("https") || scheme.equals("wss")) {
                            z3 = true;
                        }
                        repoInfo.secure = z3;
                        repoInfo.host += TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + port;
                    } else {
                        repoInfo.secure = true;
                    }
                    repoInfo.internalHost = repoInfo.host;
                    repoInfo.namespace = queryParameter;
                    String replace = extractPathString(str).replace("+", StringUtils.SPACE);
                    Validation.validateRootPathString(replace);
                    ParsedUrl parsedUrl = new ParsedUrl();
                    parsedUrl.path = new Path(replace);
                    parsedUrl.repoInfo = repoInfo;
                    return parsedUrl;
                }
                throw new IllegalArgumentException("Database URL does not specify a valid host");
            }
            throw new IllegalArgumentException("Database URL does not specify a URL scheme");
        } catch (Exception e4) {
            throw new DatabaseException(a.d("Invalid Firebase Database url specified: ", str), e4);
        }
    }

    public static String sha1HexDigest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e4);
        }
    }

    public static String stringHashV2Representation(String str) {
        String str2;
        if (str.indexOf(92) != -1) {
            str2 = str.replace("\\", "\\\\");
        } else {
            str2 = str;
        }
        if (str.indexOf(34) != -1) {
            str2 = str2.replace("\"", "\\\"");
        }
        return "\"" + str2 + '\"';
    }

    public static Integer tryParseInt(String str) {
        boolean z3;
        if (str.length() > 11 || str.length() == 0) {
            return null;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            z3 = true;
            if (str.length() == 1) {
                return null;
            }
            i = 1;
        } else {
            z3 = false;
        }
        long j2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            j2 = (j2 * 10) + (charAt - '0');
            i++;
        }
        if (z3) {
            long j3 = -j2;
            if (j3 < -2147483648L) {
                return null;
            }
            return Integer.valueOf((int) j3);
        }
        if (j2 > 2147483647L) {
            return null;
        }
        return Integer.valueOf((int) j2);
    }

    public static Pair<Task<Void>, DatabaseReference.CompletionListener> wrapOnComplete(DatabaseReference.CompletionListener completionListener) {
        if (completionListener == null) {
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
        return new Pair<>(null, completionListener);
    }

    public static void hardAssert(boolean z3) {
        hardAssert(z3, "");
    }
}
