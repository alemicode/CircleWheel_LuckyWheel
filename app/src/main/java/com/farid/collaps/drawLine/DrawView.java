package com.farid.collaps.drawLine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();
    View startView;
    View endView;
    View startView2;
    View endView2;
    View startView3;
    View endView3;
    View startView4;
    View endView4;


    public DrawView(Context context, View startView, View endView, View startView2, View endView2, View startView3, View endView3
            , View startView4, View endView4) {
        super(context);
        paint.setColor(Color.YELLOW);
        this.startView = startView;
        this.endView = endView;
        this.startView2 = startView2;
        this.endView2 = endView2;
        this.startView3 = startView3;
        this.endView3 = endView3;
        this.startView4 = startView4;
        this.endView4 = endView4;

    }

    @SuppressLint("NewApi")
    public void onDraw(Canvas canvas) {
        canvas.drawLine(startView.getX() + 25, startView.getY() + 50, endView.getX() + 25, endView.getY(), paint);

        if (startView2 != null) {
            canvas.drawLine(startView2.getX() + 25, startView2.getY() + 50, endView2.getX() + 25, endView2.getY(), paint);
        }
        if (startView3!=null) {
            canvas.drawLine(startView3.getX() + 25, startView3.getY() + 50, endView3.getX() + 25, endView3.getY(), paint);
        }
        if (startView4!=null) {
            canvas.drawLine(startView4.getX() + 25, startView4.getY() + 50, endView4.getX() + 25, endView4.getY(), paint);
        }
    }

}