package a;

import android.content.res.AssetManager;

/* JADX INFO: loaded from: classes.dex */
public final class aw implements qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17a;
    public final AssetManager b;

    public /* synthetic */ aw(AssetManager assetManager, int i) {
        this.f17a = i;
        this.b = assetManager;
    }

    @Override // a.qb
    public final qa c(qj qjVar) {
        switch (this.f17a) {
        }
        return new ax(this.b, this);
    }
}
