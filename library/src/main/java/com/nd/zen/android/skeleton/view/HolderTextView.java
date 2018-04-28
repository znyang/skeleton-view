package com.nd.zen.android.skeleton.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION_CODES;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author zen. date: 2018/4/25 0025
 */
public class HolderTextView extends TextView {

    private float placeholderLineHeight;
    private float singleLineWidth;
    private float linesToDraw = 1f;
    private int baseLineSpacing;

    private Paint placeholderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public HolderTextView(Context context) {
        this(context, null);
    }

    public HolderTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HolderTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = VERSION_CODES.LOLLIPOP)
    public HolderTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        baseLineSpacing = Utils.dp2Px(context, 4);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        calculatePlaceholderValues();

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int desiredWidth = Math.round(singleLineWidth) + getCompoundPaddingLeft() + getCompoundPaddingRight();

        int width = desiredWidth;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        }

        double linesCount = Math.ceil(linesToDraw);
        double lineSpacing = (linesCount - 1) * baseLineSpacing;
        int padding = getCompoundPaddingTop() + getCompoundPaddingBottom();
        int desiredHeight = (int) Math.round(linesCount * placeholderLineHeight + padding + lineSpacing);

        int height = 0;
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }

        setMeasuredDimension(width, height);

        calculatePlaceholderValues();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (linesToDraw == 1f) {
            drawLine(canvas, getCompoundPaddingTop(), singleLineWidth);
        } else {
            for (int i = 0; i < (int) linesToDraw; i++) {
                if (i == 0) {
                    drawLine(canvas, getCompoundPaddingTop(), singleLineWidth);
                } else {
                    drawLine(
                            canvas,
                            getCompoundPaddingTop() + (placeholderLineHeight + baseLineSpacing) * i,
                            singleLineWidth
                    );
                }
            }

            float lastLine = linesToDraw - (int) linesToDraw;

            if (lastLine > 0f) {
                drawLine(
                        canvas,
                        getCompoundPaddingTop() + (placeholderLineHeight + baseLineSpacing) * (int) linesToDraw,
                        singleLineWidth * lastLine
                );
            }
        }
    }

    void drawLine(Canvas canvas, float top, float width) {
        float left = getCompoundPaddingLeft();
        float right = left + width;
        float bottom = top + placeholderLineHeight;
        float cornerRadius = 0;
        canvas.drawRoundRect(
                new RectF(left, top, right, bottom),
                cornerRadius, cornerRadius, placeholderPaint
        );
    }

    void calculatePlaceholderValues() {
        loadPlaceholderColor();
        loadPlaceholderLineHeight();

        float availableWidth = getMeasuredWidth();
        if (availableWidth == 0) {
            availableWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        }

        singleLineWidth = Math.max((availableWidth - (getCompoundPaddingLeft() + getCompoundPaddingRight())), 1);
    }

    void loadPlaceholderColor() {
        placeholderPaint.setColor((getCurrentTextColor() & 0x00FFFFFF) | 0x33000000);
    }

    void loadPlaceholderLineHeight() {
        placeholderLineHeight = getTextSize();
    }

    public float getLinesToDraw() {
        return linesToDraw;
    }

    public void setLinesToDraw(float linesToDraw) {
        this.linesToDraw = linesToDraw;
    }
}
