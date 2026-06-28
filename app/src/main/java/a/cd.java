package a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class cd implements fa, fq, qs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f42a;
    public final ByteBuffer b;

    public cd(ByteBuffer byteBuffer, int i) {
        this.f42a = i;
        switch (i) {
            case 1:
                this.b = byteBuffer;
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                break;
            default:
                this.b = byteBuffer;
                break;
        }
    }

    @Override // a.qs
    public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        switch (this.f42a) {
            case 2:
                Long l = (Long) obj;
                messageDigest.update(bArr);
                synchronized (this.b) {
                    this.b.position(0);
                    messageDigest.update(this.b.putLong(l.longValue()).array());
                    break;
                }
                return;
            default:
                Integer num = (Integer) obj;
                if (num == null) {
                    return;
                }
                messageDigest.update(bArr);
                synchronized (this.b) {
                    this.b.position(0);
                    messageDigest.update(this.b.putInt(num.intValue()).array());
                    break;
                }
                return;
        }
    }

    @Override // a.fq
    public int d(byte[] bArr, int i) {
        ByteBuffer byteBuffer = this.b;
        int iMin = Math.min(i, byteBuffer.remaining());
        if (iMin == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, iMin);
        return iMin;
    }

    @Override // a.fq
    public short e() throws fp {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new fp();
    }

    @Override // a.fq
    public int f() {
        return (e() << 8) | e();
    }

    @Override // a.fa
    public Object g() {
        ByteBuffer byteBuffer = this.b;
        byteBuffer.position(0);
        return byteBuffer;
    }

    @Override // a.fq
    public long skip(long j) {
        ByteBuffer byteBuffer = this.b;
        int iMin = (int) Math.min(byteBuffer.remaining(), j);
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }

    public cd(int i) {
        this.f42a = i;
        switch (i) {
            case 3:
                this.b = ByteBuffer.allocate(4);
                break;
            default:
                this.b = ByteBuffer.allocate(8);
                break;
        }
    }

    @Override // a.fa
    public void b() {
    }
}
