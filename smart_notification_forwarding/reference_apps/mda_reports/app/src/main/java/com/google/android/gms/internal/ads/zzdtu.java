package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface zzdtu {
    int getTag();

    double readDouble();

    float readFloat();

    String readString();

    void readStringList(List<String> list);

    <T> T zza(zzdua<T> zzduaVar, zzdrg zzdrgVar);

    <T> void zza(List<T> list, zzdua<T> zzduaVar, zzdrg zzdrgVar);

    <K, V> void zza(Map<K, V> map, zzdsv<K, V> zzdsvVar, zzdrg zzdrgVar);

    long zzayd();

    long zzaye();

    int zzayf();

    long zzayg();

    int zzayh();

    boolean zzayi();

    String zzayj();

    zzdqk zzayk();

    int zzayl();

    int zzaym();

    int zzayn();

    long zzayo();

    int zzayp();

    long zzayq();

    int zzaza();

    boolean zzazb();

    @Deprecated
    <T> T zzb(zzdua<T> zzduaVar, zzdrg zzdrgVar);

    @Deprecated
    <T> void zzb(List<T> list, zzdua<T> zzduaVar, zzdrg zzdrgVar);

    void zzi(List<Double> list);

    void zzj(List<Float> list);

    void zzk(List<Long> list);

    void zzl(List<Long> list);

    void zzm(List<Integer> list);

    void zzn(List<Long> list);

    void zzo(List<Integer> list);

    void zzp(List<Boolean> list);

    void zzq(List<String> list);

    void zzr(List<zzdqk> list);

    void zzs(List<Integer> list);

    void zzt(List<Integer> list);

    void zzu(List<Integer> list);

    void zzv(List<Long> list);

    void zzw(List<Integer> list);

    void zzx(List<Long> list);
}
