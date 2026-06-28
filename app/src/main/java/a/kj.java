package a;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class kj implements tf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f146a = 1;
    public final js b;
    public final Object c;

    public kj(tf tfVar, js jsVar) {
        mk.h(jsVar, "transformer");
        this.c = tfVar;
        this.b = jsVar;
    }

    @Override // a.tf
    public final Iterator iterator() {
        switch (this.f146a) {
            case 0:
                return new ix(this);
            default:
                return new vr(this);
        }
    }

    public kj(tk tkVar, js jsVar) {
        mk.h(jsVar, "getNextValue");
        this.c = tkVar;
        this.b = jsVar;
    }
}
