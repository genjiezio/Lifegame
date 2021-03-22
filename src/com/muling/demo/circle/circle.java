package com.muling.demo.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Array;

public class circle extends View {
    Context context;

    float h;

    private int[][] table = (int[][])Array.newInstance(int.class, new int[] { 20, 12 });

    float w;

    public circle(Context paramContext) {
        super(paramContext);
        this.context = paramContext;
    }

    public circle(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.context = paramContext;
    }

    public circle(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        this.context = paramContext;
    }

    @Override
    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(4);
        for (int i = 0;; i++) {
            if (i >= 11) {
                for (i = 0;; i++) {
                    if (i >= 19) {
                        i = 0;
                        label24: while (true) {
                            if (i >= 18)
                                return;
                            for (int j = 0;; j++) {
                                if (j >= 10) {
                                    i++;
                                    continue label24;
                                }
                                if (this.table[i + 1][j + 1] == 0) {
                                    paint.setColor(-1);
                                } else {
                                    paint.setColor(-16777216);
                                }
                                paramCanvas.drawRect(this.w * j + 2, this.h * i + 2, this.w * (j + 1) - 2, this.h * (i + 1) - 2, paint);
                            }
                            break;
                        }
                        break;
                    }
                    paint.setColor(-7829368);
                    paramCanvas.drawLine(false, this.h * i, this.w * 10, this.h * i, paint);
                }
                break;
            }
            paint.setColor(-7829368);
            paramCanvas.drawLine(this.w * i, false, this.w * i, this.h * 18, paint);
        }
    }

    @Override
    protected void onMeasure(int paramInt1, int paramInt2) {
        this.w = (View.MeasureSpec.getSize(paramInt1) / 10);
        this.h = (View.MeasureSpec.getSize(paramInt2) / 18);
        super.onMeasure(paramInt1, paramInt2);
    }

    public void update(int[][] paramArrayOfint) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: aload_1
        //   4: putfield table : [[I
        //   7: aload_0
        //   8: invokevirtual invalidate : ()V
        //   11: aload_0
        //   12: monitorexit
        //   13: return
        //   14: astore_1
        //   15: aload_0
        //   16: monitorexit
        //   17: aload_1
        //   18: athrow
        // Exception table:
        //   from	to	target	type
        //   2	11	14	finally
    }
}
