package com.google.api;

import com.google.api.Distribution;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes2.dex */
public interface DistributionOrBuilder extends MessageLiteOrBuilder {
    long getBucketCounts(int i);

    int getBucketCountsCount();

    List<Long> getBucketCountsList();

    Distribution.BucketOptions getBucketOptions();

    long getCount();

    double getMean();

    Distribution.Range getRange();

    double getSumOfSquaredDeviation();

    boolean hasBucketOptions();

    boolean hasRange();
}
