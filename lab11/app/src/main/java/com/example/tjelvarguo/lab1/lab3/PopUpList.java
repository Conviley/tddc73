package com.example.tjelvarguo.lab1.lab3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.example.tjelvarguo.lab1.R;

/**
 * Created by Tjelvar Guo on 2018-11-19.
 */

public class PopUpList extends View {

    boolean alternateRows;
    EditText editText;

    Paint backgroundPaint;
    Paint shadowPaint;
    Paint dividerPaint;
    Paint textPaint;

    float textHeight;

    Rect listBackgroundRect;

    public PopUpList(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.editText = editText;



        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.PopUpList,
                0, 0);

        try {
            alternateRows = a.getBoolean(R.styleable.PopUpList_alternatingRowColors, false);
        } finally {
            a.recycle();
        }

        initPaints();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the shadow
        Rect listBackground = new Rect(0,0, canvas.getWidth(), canvas.getHeight());
        canvas.drawRect(listBackground, shadowPaint);
    }

    private void initPaints(){
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        if (textHeight == 0) {
            textHeight = textPaint.getTextSize();
        } else {
            textPaint.setTextSize(textHeight);
        }

        backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setTextSize(textHeight);

        shadowPaint = new Paint(0);
        shadowPaint.setColor(0xff101010);
        shadowPaint.setMaskFilter(new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL));
    }

    public boolean getAlternatingRows(){
        return alternateRows;
    }

    public void setAlternatingRows(boolean alternateRows) {
        this.alternateRows = alternateRows;
        invalidate();
        requestLayout();
    }
}
