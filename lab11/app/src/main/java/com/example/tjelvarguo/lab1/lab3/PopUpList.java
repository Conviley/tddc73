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
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.tjelvarguo.lab1.R;

import java.util.ArrayList;
import java.util.List;

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

    List<String> names;

    Rect listBackgroundRect;

    public PopUpList(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        names = new ArrayList<>();

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
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < names.size(); i++) {
            canvas.drawText(names.get(i), 10f,15f, textPaint);

            Log.d("dee", "onDraw: asdasdasd");
        }
        Log.d("dee", "onDraw: asdasdasd");
        super.onDraw(canvas);
    }

    private void initPaints(){
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.RIGHT);
        textPaint.setColor(Color.BLACK);
        if (textHeight == 0) {
            textHeight = textPaint.getTextSize();
        } else {
            textPaint.setTextSize(textHeight);
        }

        backgroundPaint = new Paint(Paint.UNDERLINE_TEXT_FLAG);
        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setTextSize(textHeight);

        shadowPaint = new Paint(0);
        shadowPaint.setColor(Color.RED);
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

    public void setNames(List<String> names){
        this.names = names;
        invalidate();
        requestLayout();
    }
}
