package com.example.tjelvarguo.lab1.lab3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Tjelvar Guo on 2018-12-05.
 */

public class NameRow extends View {

    private Paint textPaint;
    private Paint linePaint;
    private String name;

    public NameRow(Context context) {
        super(context);
        initPaints();
    }

    public NameRow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaints();
    }

    public NameRow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    public NameRow(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaints();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawText(name, 0,  70, textPaint);
        canvas.drawLine(0,100,840,100,linePaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(840,  100 );
    }


    private void initPaints(){
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(50);

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setTextAlign(Paint.Align.LEFT);
        linePaint.setColor(Color.BLACK);

    }

    public void setName(String name) {
        this.name = name;
        invalidate();
        requestLayout();
    }

}
