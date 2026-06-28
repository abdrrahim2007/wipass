package a;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class hp implements lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f121a;
    public final Object b;

    public /* synthetic */ hp(Object obj) {
        this.b = obj;
    }

    public gc a() {
        if (((gc) this.f121a) == null) {
            synchronized (this) {
                try {
                    if (((gc) this.f121a) == null) {
                        File cacheDir = ((ga) ((fb) this.b).b).b.getCacheDir();
                        gk gkVar = null;
                        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
                        if (file != null && (file.isDirectory() || file.mkdirs())) {
                            gkVar = new gk(file);
                        }
                        this.f121a = gkVar;
                    }
                    if (((gc) this.f121a) == null) {
                        this.f121a = new ee(19);
                    }
                } finally {
                }
            }
        }
        return (gc) this.f121a;
    }

    @Override // a.lg
    public Object get() {
        if (this.f121a == null) {
            synchronized (this) {
                try {
                    if (this.f121a == null) {
                        Object obj = ((lg) this.b).get();
                        mk.f(obj, "Argument must not be null");
                        this.f121a = obj;
                    }
                } finally {
                }
            }
        }
        return this.f121a;
    }
}
