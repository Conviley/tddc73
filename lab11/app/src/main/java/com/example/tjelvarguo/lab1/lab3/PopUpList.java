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

    Paint backgroundPaint;
    Paint textPaint;

    float textHeight;

    List<String> names = new ArrayList<>();

    public  PopUpList(Context context) {
        super(context);
        initPaints();
    }

    public PopUpList(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.PopUpList,
                0, 0);

        initPaints();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < names.size(); i++) {
            canvas.drawText(names.get(i), 0,100*i + 50, textPaint);
        }
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(840, names.size() * 100 );
    }

    private void initPaints(){
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(50f);

        if (textHeight == 0) {
            textHeight = textPaint.getTextSize();
        } else {
            textPaint.setTextSize(textHeight);
        }

        backgroundPaint = new Paint(Paint.UNDERLINE_TEXT_FLAG);
        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setTextSize(textHeight);
    }

    private void redDraw() {
        invalidate();
        requestLayout();
    }

    public void setNames(List<String> names){
        this.names = names;
        redDraw();
    }

    public void clearNames() {
        this.names.clear();
        redDraw();
    }
}
