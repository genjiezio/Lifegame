package com.muling.demo.circle;

import adrt.ADRTLogCatReader;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.lang.reflect.Array;

public class MainActivity extends Activity {
    int[][] biaot = (int[][])Array.newInstance(int.class, new int[] { 20, 12 });

    circle c;

    boolean is_pause = true;

    boolean is_runing = false;

    ImageView iv;

    Thread play;

    int[][] table = (int[][])Array.newInstance(int.class, new int[] { 20, 12 });

    public int life_num(int paramInt1, int paramInt2) {
        int j = 0;
        int i = 0;
        label17: while (true) {
            if (i >= 3)
                return j;
            int k = 0;
            while (true) {
                if (k >= 3) {
                    i++;
                    continue label17;
                }
                int m = j;
                if (this.table[paramInt1 + i - 1][paramInt2 + k - 1] == 1) {
                    m = j;
                    if (i * k != 1)
                        m = j + 1;
                }
                k++;
                j = m;
            }
            break;
        }
    }

    @Override
    protected void onCreate(Bundle paramBundle) {
        ADRTLogCatReader.onContext((Context)this, "com.aide.ui");
        super.onCreate(paramBundle);
        setContentView(2130903040);
        this.iv = (ImageView)findViewById(2131099649);
        this.c = (circle)findViewById(2131099648);
        this.table[1][2] = 1;
        this.table[1][4] = 1;
        this.table[2][5] = 1;
        this.table[3][5] = 1;
        this.table[4][2] = 1;
        this.table[4][5] = 1;
        this.table[5][3] = 1;
        this.table[5][4] = 1;
        this.table[5][5] = 1;
        for (int i = 0;; i++) {
            if (i >= this.table.length) {
                this.c.update(this.table);
                return;
            }
            this.biaot[i] = (int[])this.table[i].clone();
        }
    }

    @Override
    protected void onStop() {
        this.iv.setImageResource(2130837505);
        this.is_pause = true;
        super.onStop();
    }

    public void one_round() {
        // Byte code:
        //   0: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
        //   3: iconst_2
        //   4: newarray int
        //   6: dup
        //   7: iconst_0
        //   8: bipush #18
        //   10: iastore
        //   11: dup
        //   12: iconst_1
        //   13: bipush #10
        //   15: iastore
        //   16: invokestatic newInstance : (Ljava/lang/Class;[I)Ljava/lang/Object;
        //   19: checkcast [[I
        //   22: astore_3
        //   23: iconst_0
        //   24: istore_1
        //   25: iload_1
        //   26: bipush #18
        //   28: if_icmplt -> 40
        //   31: iconst_1
        //   32: istore_1
        //   33: iload_1
        //   34: bipush #19
        //   36: if_icmplt -> 77
        //   39: return
        //   40: iconst_0
        //   41: istore_2
        //   42: iload_2
        //   43: bipush #10
        //   45: if_icmplt -> 55
        //   48: iload_1
        //   49: iconst_1
        //   50: iadd
        //   51: istore_1
        //   52: goto -> 25
        //   55: aload_3
        //   56: iload_1
        //   57: aaload
        //   58: iload_2
        //   59: aload_0
        //   60: iload_1
        //   61: iconst_1
        //   62: iadd
        //   63: iload_2
        //   64: iconst_1
        //   65: iadd
        //   66: invokevirtual life_num : (II)I
        //   69: iastore
        //   70: iload_2
        //   71: iconst_1
        //   72: iadd
        //   73: istore_2
        //   74: goto -> 42
        //   77: iconst_1
        //   78: istore_2
        //   79: iload_2
        //   80: bipush #11
        //   82: if_icmplt -> 92
        //   85: iload_1
        //   86: iconst_1
        //   87: iadd
        //   88: istore_1
        //   89: goto -> 33
        //   92: aload_0
        //   93: getfield table : [[I
        //   96: iload_1
        //   97: aaload
        //   98: iload_2
        //   99: iaload
        //   100: tableswitch default -> 124, 0 -> 169, 1 -> 131
        //   124: iload_2
        //   125: iconst_1
        //   126: iadd
        //   127: istore_2
        //   128: goto -> 79
        //   131: aload_3
        //   132: iload_1
        //   133: iconst_1
        //   134: isub
        //   135: aaload
        //   136: iload_2
        //   137: iconst_1
        //   138: isub
        //   139: iaload
        //   140: iconst_2
        //   141: if_icmplt -> 157
        //   144: aload_3
        //   145: iload_1
        //   146: iconst_1
        //   147: isub
        //   148: aaload
        //   149: iload_2
        //   150: iconst_1
        //   151: isub
        //   152: iaload
        //   153: iconst_3
        //   154: if_icmple -> 166
        //   157: aload_0
        //   158: getfield table : [[I
        //   161: iload_1
        //   162: aaload
        //   163: iload_2
        //   164: iconst_0
        //   165: iastore
        //   166: goto -> 124
        //   169: aload_3
        //   170: iload_1
        //   171: iconst_1
        //   172: isub
        //   173: aaload
        //   174: iload_2
        //   175: iconst_1
        //   176: isub
        //   177: iaload
        //   178: iconst_3
        //   179: if_icmpne -> 124
        //   182: aload_0
        //   183: getfield table : [[I
        //   186: iload_1
        //   187: aaload
        //   188: iload_2
        //   189: iconst_1
        //   190: iastore
        //   191: goto -> 124
    }

    public void playthread() {
        this.play = new Thread(new Runnable(this) {
            private final MainActivity this$0;

            public void run() {
                this.this$0.is_runing = true;
                while (true) {
                    if (!Thread.currentThread().isInterrupted()) {
                        long l = 1000L;
                        try {
                            Thread.sleep(l);
                            if (!this.this$0.is_pause) {
                                this.this$0.one_round();
                                this.this$0.c.update(this.this$0.table);
                            }
                            continue;
                        } catch (InterruptedException interruptedException) {}
                    }
                    this.this$0.is_runing = false;
                    return;
                }
            }
        });
        this.play.start();
    }

    public void replay(View paramView) {
        this.play.interrupt();
        this.is_pause = true;
        for (int i = 0;; i++) {
            if (i >= this.biaot.length) {
                this.iv.setImageResource(2130837505);
                this.c.update(this.table);
                Toast.makeText(getApplicationContext(), "重启", 0).show();
                return;
            }
            this.table[i] = (int[])this.biaot[i].clone();
        }
    }

    public void switchc(View paramView) {
        if (!this.is_pause) {
            this.iv.setImageResource(2130837505);
            this.is_pause = true;
            return;
        }
        this.is_pause = false;
        this.iv.setImageResource(2130837506);
        if (!this.is_runing)
            playthread();
    }
}
