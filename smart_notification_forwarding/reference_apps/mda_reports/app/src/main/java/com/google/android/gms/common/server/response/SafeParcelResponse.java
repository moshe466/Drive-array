package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
@KeepForSdk
@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();
    private final String mClassName;

    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int zalf;

    @SafeParcelable.Field(getter = "getFieldMappingDictionary", id = 3)
    private final zak zapz;

    @SafeParcelable.Field(getter = "getParcel", id = 2)
    private final Parcel zarb;
    private final int zarc;
    private int zard;
    private int zare;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public SafeParcelResponse(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) zak zakVar) {
        this.zalf = i;
        this.zarb = (Parcel) Preconditions.checkNotNull(parcel);
        this.zarc = 2;
        this.zapz = zakVar;
        zak zakVar2 = this.zapz;
        this.mClassName = zakVar2 == null ? null : zakVar2.zact();
        this.zard = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zak zakVar, String str) {
        this.zalf = 1;
        this.zarb = Parcel.obtain();
        safeParcelable.writeToParcel(this.zarb, 0);
        this.zarc = 1;
        this.zapz = (zak) Preconditions.checkNotNull(zakVar);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zard = 2;
    }

    public SafeParcelResponse(zak zakVar, String str) {
        this.zalf = 1;
        this.zarb = Parcel.obtain();
        this.zarc = 0;
        this.zapz = (zak) Preconditions.checkNotNull(zakVar);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zard = 0;
    }

    @KeepForSdk
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        zak zakVar = new zak(t.getClass());
        zaa(zakVar, t);
        zakVar.zacs();
        zakVar.zacr();
        return new SafeParcelResponse(t, zakVar, canonicalName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void zaa(zak zakVar, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (zakVar.zaa(cls)) {
            return;
        }
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        zakVar.zaa(cls, fieldMappings);
        Iterator<String> it = fieldMappings.keySet().iterator();
        while (it.hasNext()) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(it.next());
            Class<? extends FastJsonResponse> cls2 = field.g;
            if (cls2 != null) {
                try {
                    zaa(zakVar, cls2.newInstance());
                } catch (IllegalAccessException e) {
                    String valueOf = String.valueOf(field.g.getCanonicalName());
                    throw new IllegalStateException(valueOf.length() != 0 ? "Could not access object of type ".concat(valueOf) : new String("Could not access object of type "), e);
                } catch (InstantiationException e2) {
                    String valueOf2 = String.valueOf(field.g.getCanonicalName());
                    throw new IllegalStateException(valueOf2.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf2) : new String("Could not instantiate an object of type "), e2);
                }
            }
        }
    }

    private static void zaa(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(JsonUtils.escapeString(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.encode((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0071. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:75:0x0190. Please report as an issue. */
    private final void zaa(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        Object createBigInteger;
        String escapeString;
        String str;
        Object valueOf;
        Object a;
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().getSafeParcelableFieldId(), entry);
        }
        sb.append('{');
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                String str2 = (String) entry2.getKey();
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str2);
                sb.append("\":");
                if (field.zacn()) {
                    int i = field.c;
                    switch (i) {
                        case 0:
                            valueOf = Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader));
                            a = FastJsonResponse.a(field, valueOf);
                            zab(sb, field, a);
                            break;
                        case 1:
                            valueOf = SafeParcelReader.createBigInteger(parcel, readHeader);
                            a = FastJsonResponse.a(field, valueOf);
                            zab(sb, field, a);
                            break;
                        case 2:
                            valueOf = Long.valueOf(SafeParcelReader.readLong(parcel, readHeader));
                            a = FastJsonResponse.a(field, valueOf);
                            zab(sb, field, a);
                            break;
                        case 3:
                            valueOf = Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader));
                            a = FastJsonResponse.a(field, valueOf);
                            zab(sb, field, a);
                            break;
                        case 4:
                            valueOf = Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader));
                            a = FastJsonResponse.a(field, valueOf);
                            zab(sb, field, a);
                            break;
                        case 5:
                            valueOf = SafeParcelReader.createBigDecimal(parcel, readHeader);
                            a = FastJsonResponse.a(field, valueOf);
                            zab(sb, field, a);
                            break;
                        case 6:
                            valueOf = Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader));
                            a = FastJsonResponse.a(field, valueOf);
                            zab(sb, field, a);
                            break;
                        case 7:
                            valueOf = SafeParcelReader.createString(parcel, readHeader);
                            a = FastJsonResponse.a(field, valueOf);
                            zab(sb, field, a);
                            break;
                        case 8:
                        case 9:
                            a = FastJsonResponse.a(field, SafeParcelReader.createByteArray(parcel, readHeader));
                            zab(sb, field, a);
                            break;
                        case 10:
                            Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                            HashMap hashMap = new HashMap();
                            for (String str3 : createBundle.keySet()) {
                                hashMap.put(str3, createBundle.getString(str3));
                            }
                            a = FastJsonResponse.a(field, hashMap);
                            zab(sb, field, a);
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else {
                    if (field.d) {
                        sb.append("[");
                        switch (field.c) {
                            case 0:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createIntArray(parcel, readHeader));
                                break;
                            case 1:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBigIntegerArray(parcel, readHeader));
                                break;
                            case 2:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createLongArray(parcel, readHeader));
                                break;
                            case 3:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createFloatArray(parcel, readHeader));
                                break;
                            case 4:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createDoubleArray(parcel, readHeader));
                                break;
                            case 5:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBigDecimalArray(parcel, readHeader));
                                break;
                            case 6:
                                ArrayUtils.writeArray(sb, SafeParcelReader.createBooleanArray(parcel, readHeader));
                                break;
                            case 7:
                                ArrayUtils.writeStringArray(sb, SafeParcelReader.createStringArray(parcel, readHeader));
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                                int length = createParcelArray.length;
                                for (int i2 = 0; i2 < length; i2++) {
                                    if (i2 > 0) {
                                        sb.append(",");
                                    }
                                    createParcelArray[i2].setDataPosition(0);
                                    zaa(sb, field.zacq(), createParcelArray[i2]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        str = "]";
                    } else {
                        switch (field.c) {
                            case 0:
                                sb.append(SafeParcelReader.readInt(parcel, readHeader));
                                break;
                            case 1:
                                createBigInteger = SafeParcelReader.createBigInteger(parcel, readHeader);
                                sb.append(createBigInteger);
                                break;
                            case 2:
                                sb.append(SafeParcelReader.readLong(parcel, readHeader));
                                break;
                            case 3:
                                sb.append(SafeParcelReader.readFloat(parcel, readHeader));
                                break;
                            case 4:
                                sb.append(SafeParcelReader.readDouble(parcel, readHeader));
                                break;
                            case 5:
                                createBigInteger = SafeParcelReader.createBigDecimal(parcel, readHeader);
                                sb.append(createBigInteger);
                                break;
                            case 6:
                                sb.append(SafeParcelReader.readBoolean(parcel, readHeader));
                                break;
                            case 7:
                                String createString = SafeParcelReader.createString(parcel, readHeader);
                                sb.append("\"");
                                escapeString = JsonUtils.escapeString(createString);
                                sb.append(escapeString);
                                sb.append("\"");
                                break;
                            case 8:
                                byte[] createByteArray = SafeParcelReader.createByteArray(parcel, readHeader);
                                sb.append("\"");
                                escapeString = Base64Utils.encode(createByteArray);
                                sb.append(escapeString);
                                sb.append("\"");
                                break;
                            case 9:
                                byte[] createByteArray2 = SafeParcelReader.createByteArray(parcel, readHeader);
                                sb.append("\"");
                                escapeString = Base64Utils.encodeUrlSafe(createByteArray2);
                                sb.append(escapeString);
                                sb.append("\"");
                                break;
                            case 10:
                                Bundle createBundle2 = SafeParcelReader.createBundle(parcel, readHeader);
                                Set<String> keySet = createBundle2.keySet();
                                keySet.size();
                                sb.append("{");
                                boolean z2 = true;
                                for (String str4 : keySet) {
                                    if (!z2) {
                                        sb.append(",");
                                    }
                                    sb.append("\"");
                                    sb.append(str4);
                                    sb.append("\"");
                                    sb.append(":");
                                    sb.append("\"");
                                    sb.append(JsonUtils.escapeString(createBundle2.getString(str4)));
                                    sb.append("\"");
                                    z2 = false;
                                }
                                str = "}";
                                break;
                            case 11:
                                Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                                createParcel.setDataPosition(0);
                                zaa(sb, field.zacq(), createParcel);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                    sb.append(str);
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(validateObjectHeader);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }

    private final void zab(FastJsonResponse.Field<?, ?> field) {
        if (!(field.f != -1)) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.zarb;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i = this.zard;
        if (i == 0) {
            this.zare = SafeParcelWriter.beginObjectHeader(parcel);
            this.zard = 1;
        } else if (i != 1) {
            if (i == 2) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
            throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
        }
    }

    private final void zab(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (!field.b) {
            zaa(sb, field.a, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            zaa(sb, field.a, arrayList.get(i));
        }
        sb.append("]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0005, code lost:
    
        if (r0 != 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.os.Parcel zacu() {
        /*
            r2 = this;
            int r0 = r2.zard
            if (r0 == 0) goto L8
            r1 = 1
            if (r0 == r1) goto L10
            goto L1a
        L8:
            android.os.Parcel r0 = r2.zarb
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(r0)
            r2.zare = r0
        L10:
            android.os.Parcel r0 = r2.zarb
            int r1 = r2.zare
            com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(r0, r1)
            r0 = 2
            r2.zard = r0
        L1a:
            android.os.Parcel r0 = r2.zarb
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.zacu():android.os.Parcel");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, double d) {
        zab(field);
        SafeParcelWriter.writeDouble(this.zarb, field.getSafeParcelableFieldId(), d);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, float f) {
        zab(field);
        SafeParcelWriter.writeFloat(this.zarb, field.getSafeParcelableFieldId(), f);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
        zab(field);
        SafeParcelWriter.writeInt(this.zarb, field.getSafeParcelableFieldId(), i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, long j) {
        zab(field);
        SafeParcelWriter.writeLong(this.zarb, field.getSafeParcelableFieldId(), j);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        zab(field);
        SafeParcelWriter.writeString(this.zarb, field.getSafeParcelableFieldId(), str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        zab(field);
        SafeParcelWriter.writeBigDecimal(this.zarb, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        zab(field);
        SafeParcelWriter.writeBigInteger(this.zarb, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        zab(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeStringArray(this.zarb, field.getSafeParcelableFieldId(), strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        zab(field);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        SafeParcelWriter.writeBundle(this.zarb, field.getSafeParcelableFieldId(), bundle, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        zab(field);
        SafeParcelWriter.writeBoolean(this.zarb, field.getSafeParcelableFieldId(), z);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected void a(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        zab(field);
        SafeParcelWriter.writeByteArray(this.zarb, field.getSafeParcelableFieldId(), bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        zab(field);
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            T t = arrayList.get(i);
            i++;
            arrayList2.add(((SafeParcelResponse) t).zacu());
        }
        SafeParcelWriter.writeParcelList(this.zarb, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        zab(field);
        SafeParcelWriter.writeParcel(this.zarb, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).zacu(), true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void b(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        zab(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zarb, field.getSafeParcelableFieldId(), iArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void c(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        zab(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zarb, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void d(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        zab(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = arrayList.get(i).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zarb, field.getSafeParcelableFieldId(), jArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void e(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        zab(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = arrayList.get(i).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zarb, field.getSafeParcelableFieldId(), fArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void f(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        zab(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = arrayList.get(i).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zarb, field.getSafeParcelableFieldId(), dArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void g(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        zab(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zarb, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zak zakVar = this.zapz;
        if (zakVar == null) {
            return null;
        }
        return zakVar.zai(this.mClassName);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void h(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        zab(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = arrayList.get(i).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zarb, field.getSafeParcelableFieldId(), zArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        Preconditions.checkNotNull(this.zapz, "Cannot convert to JSON on client side.");
        Parcel zacu = zacu();
        zacu.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zaa(sb, this.zapz.zai(this.mClassName), zacu);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zak zakVar;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zalf);
        SafeParcelWriter.writeParcel(parcel, 2, zacu(), false);
        int i2 = this.zarc;
        if (i2 == 0) {
            zakVar = null;
        } else {
            if (i2 != 1 && i2 != 2) {
                StringBuilder sb = new StringBuilder(34);
                sb.append("Invalid creation type: ");
                sb.append(i2);
                throw new IllegalStateException(sb.toString());
            }
            zakVar = this.zapz;
        }
        SafeParcelWriter.writeParcelable(parcel, 3, zakVar, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
