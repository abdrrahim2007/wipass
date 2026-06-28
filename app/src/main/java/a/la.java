package a;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.collection.ArrayMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class la extends ContextWrapper {
    public static final kk k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final on f161a;
    public final hp b;
    public final kn c;
    public final kn d;
    public final List e;
    public final ArrayMap f;
    public final hq g;
    public final fb h;
    public final int i;
    public sd j;

    static {
        kk kkVar = new kk();
        kkVar.f147a = qk.f255a;
        k = kkVar;
    }

    public la(Context context, on onVar, tw twVar, kn knVar, kn knVar2, ArrayMap arrayMap, List list, hq hqVar, fb fbVar) {
        super(context.getApplicationContext());
        this.f161a = onVar;
        this.c = knVar;
        this.d = knVar2;
        this.e = list;
        this.f = arrayMap;
        this.g = hqVar;
        this.h = fbVar;
        this.i = 4;
        this.b = new hp(twVar);
    }

    public final ru a() {
        return (ru) this.b.get();
    }
}
