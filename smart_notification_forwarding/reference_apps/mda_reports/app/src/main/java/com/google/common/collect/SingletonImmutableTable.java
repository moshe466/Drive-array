package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import java.util.Map;

@GwtCompatible
/* loaded from: classes2.dex */
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    final R a;
    final C b;
    final V c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonImmutableTable(Table.Cell<R, C, V> cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonImmutableTable(R r, C c, V v) {
        this.a = (R) Preconditions.checkNotNull(r);
        this.b = (C) Preconditions.checkNotNull(c);
        this.c = (V) Preconditions.checkNotNull(v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public ImmutableSet<Table.Cell<R, C, V>> b() {
        return ImmutableSet.of(ImmutableTable.a(this.a, this.b, this.c));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public ImmutableCollection<V> c() {
        return ImmutableSet.of(this.c);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        return containsColumn(c) ? ImmutableMap.of(this.a, (Object) this.c) : ImmutableMap.of();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return column((SingletonImmutableTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.b, ImmutableMap.of(this.a, (Object) this.c));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.a, ImmutableMap.of(this.b, (Object) this.c));
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return 1;
    }
}
