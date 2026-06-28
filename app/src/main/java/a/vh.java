package a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/* JADX INFO: loaded from: classes.dex */
public final class vh implements vi, qb, wb {
    public static final String[] c = {"_data"};
    public static final String[] d = {"_data"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f328a;
    public final ContentResolver b;

    public /* synthetic */ vh(ContentResolver contentResolver, int i) {
        this.f328a = i;
        this.b = contentResolver;
    }

    @Override // a.wb
    public ew a(Uri uri) {
        switch (this.f328a) {
            case 2:
                return new au(this.b, uri, 0);
            case 3:
                return new au(this.b, uri, 1);
            default:
                return new uj(1, uri, this.b);
        }
    }

    @Override // a.vi
    public Cursor b(Uri uri) {
        switch (this.f328a) {
            case 0:
                String lastPathSegment = uri.getLastPathSegment();
                return this.b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, c, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
            default:
                String lastPathSegment2 = uri.getLastPathSegment();
                return this.b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, d, "kind = 1 AND video_id = ?", new String[]{lastPathSegment2}, null);
        }
    }

    @Override // a.qb
    public qa c(qj qjVar) {
        switch (this.f328a) {
        }
        return new wc(this);
    }
}
