package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import bb.b0;
import bb.i0;
import java.util.Map;
import n9.v0;

/* loaded from: classes.dex */
public final class j implements c {

    /* renamed from: a, reason: collision with root package name */
    private final k9.h f11366a;

    /* renamed from: b, reason: collision with root package name */
    private final la.b f11367b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<la.e, pa.g<?>> f11368c;

    /* renamed from: d, reason: collision with root package name */
    private final l8.h f11369d;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<i0> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i0 b() {
            return j.this.f11366a.o(j.this.f()).s();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(k9.h hVar, la.b bVar, Map<la.e, ? extends pa.g<?>> map) {
        l8.h a10;
        y8.k.e(hVar, "builtIns");
        y8.k.e(bVar, "fqName");
        y8.k.e(map, "allValueArguments");
        this.f11366a = hVar;
        this.f11367b = bVar;
        this.f11368c = map;
        a10 = l8.j.a(kotlin.b.PUBLICATION, new a());
        this.f11369d = a10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<la.e, pa.g<?>> a() {
        return this.f11368c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public b0 b() {
        Object value = this.f11369d.getValue();
        y8.k.d(value, "pyright 2010-2017 JetBrains s.r.o.\n *\n * Licensed under the Apache License, Version 2.0 (the \"License\");\n * you may not use this file except in compliance with the License.\n * You may obtain a copy of the License at\n *\n * http://www.apache.org/licenses/LICENSE-2.0\n *\n * Unless required by applicable law or agreed to in writing, software\n * distributed under the License is distributed on an \"AS IS\" BASIS,\n * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n * See the License for the specific language governing permissions and\n * limitations under the License.\n */\n\npackage org.jetbrains.kotlin.descriptors.annotations\n\nimport org.jetbrains.kotlin.builtins.KotlinBuiltIns\nimport org.jetbrains.kotlin.descriptors.SourceElement\nimport org.jetbrains.kotlin.name.FqName\nimport org.jetbrains.kotlin.name.Name\nimport org.jetbrains.kotlin.resolve.constants.ConstantValue\nimport org.jetbrains.kotlin.types.KotlinType\nimport kotlin.LazyThreadSafetyMode.PUBLICATION\n\nclass BuiltInAnnotationDescriptor(\n        private val builtIns: KotlinBuiltIns,\n        override val fqName: FqName,\n        override val allValueArguments: Map<Name, ConstantValue<*>>\n) : AnnotationDescriptor {\n    override val type: KotlinType by lazy(PUBLICATION) {\n        builtIns.getBuiltInClassByFqName(fqName).defaultType\n    }");
        return (b0) value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public la.b f() {
        return this.f11367b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public v0 k() {
        v0 v0Var = v0.f12324a;
        y8.k.d(v0Var, "NO_SOURCE");
        return v0Var;
    }
}
