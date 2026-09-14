package y6;

import com.opentok.android.i;

/* loaded from: classes.dex */
public class a extends i {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y6.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0336a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15925a;

        static {
            int[] iArr = new int[i.b.values().length];
            f15925a = iArr;
            try {
                iArr[i.b.InvalidSessionId.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15925a[i.b.AuthorizationFailure.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15925a[i.b.UnknownPublisherInstance.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15925a[i.b.UnknownSubscriberInstance.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15925a[i.b.SessionInvalidSignalType.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15925a[i.b.SessionSignalDataTooLong.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15925a[i.b.SessionSignalTypeTooLong.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15925a[i.b.ConnectionFailed.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15925a[i.b.SessionDisconnected.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15925a[i.b.VideoCaptureFailed.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15925a[i.b.CameraFailed.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f15925a[i.b.VideoRenderFailed.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f15925a[i.b.SessionNullOrInvalidParameter.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f15925a[i.b.SessionIllegalState.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public a(i.a aVar, int i10) {
        super(aVar, i10, d(i10));
    }

    public static String d(int i10) {
        switch (C0336a.f15925a[i.b.fromTypeCode(i10).ordinal()]) {
            case 1:
                return "Unable to connect: an invalid session ID was provided.";
            case 2:
                return "Authorization Failure - Invalid credentials were provided.";
            case 3:
                return "Cannot unpublish: An unknown Publisher instance was passed into Session.unpublish().";
            case 4:
                return "Cannot unsubscribe: An unknown Subscriber instance was passed into Session.unsubscribe().";
            case 5:
                return "Invalid signal type.";
            case 6:
                return "Signal data too long.";
            case 7:
                return "Signal type too long.";
            case 8:
                return "Unable to connect to the session: check the network connection.";
            case 9:
                return "Cannot publish: the client is not connected to the OpenTok session.";
            case 10:
                return "Video capture has failed";
            case 11:
                return "The camera of the device has failed. ";
            case 12:
                return "Video render has failed";
            case 13:
                return "Token null or invalid parameter.";
            case 14:
                return "Unable to connect to a session that is already connected or unable to subscribe to a stream that is no longer in the session.";
            default:
                return "(null description)";
        }
    }
}
