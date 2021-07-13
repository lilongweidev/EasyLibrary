package com.llw.easyutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class EasyView extends View {

    //背景画笔
    private Paint mPaint;
    private int mBgColor;
    private float mBgRadius;
    //文字画笔
    private Paint mTextPaint;
    //文字颜色
    private int mTextColor;
    //文字大小
    private float mTextSize;
    //绘制文字内容
    private String text;

    private int mBgWidth;
    private int mBgHeight;
    private int mTextWidth;
    private int mTextHeight;

    private float mPaddingLeft;
    private float mPaddingRight;
    private float mPaddingTop;
    private float mPaddingBottom;

    public EasyView(Context context) {
        super(context);
        init();
    }

    public EasyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EasyView);
        mBgColor = typedArray.getColor(R.styleable.EasyView_android_color, Color.BLACK);
        mBgRadius = typedArray.getDimension(R.styleable.EasyView_android_radius, 48f);
        text = typedArray.getString(R.styleable.EasyView_android_text) == null ? "" : typedArray.getString(R.styleable.EasyView_android_text);
        mTextColor = typedArray.getColor(R.styleable.EasyView_android_textColor, Color.WHITE);
        mTextSize = typedArray.getDimension(R.styleable.EasyView_android_textSize, 14f);
        mPaddingLeft = getPaddingLeft() == 0 ? 60f : getPaddingLeft();
        mPaddingLeft = getPaddingStart() == 0 ? 60f : getPaddingStart();
        mPaddingRight = getPaddingRight() == 0 ? 60f : getPaddingRight();
        mPaddingRight = getPaddingEnd() == 0 ? 60f : getPaddingEnd();
        mPaddingTop = getPaddingTop() == 0 ? 40f : getPaddingTop();
        mPaddingBottom = getPaddingBottom() == 0 ? 40f : getPaddingBottom();
        typedArray.recycle();
        init();
    }

    public EasyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public EasyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    //初始化
    private void init() {

        //创建背景画笔
        mPaint = new Paint();
        mPaint.setColor(mBgColor);// 设置画笔颜色
        mPaint.setStrokeWidth(6f);// 设置画笔宽度
        mPaint.setStyle(Paint.Style.FILL);//设置画笔模式为填充
        mPaint.setAntiAlias(true);//设置画笔抗锯齿（光滑）

        //创建文字画笔
        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setStyle(Paint.Style.FILL);
        //mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setAntiAlias(true);
    }

    /**
     * 测量
     *
     * @param widthMeasureSpec  宽度测量规格
     * @param heightMeasureSpec 高度测量规格
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 获取宽-测量规则的模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        // 获取高-测量规则的模式和大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        // 设置wrap_content的默认宽 / 高值
        // 默认宽/高的设定并无固定依据,根据需要灵活设置
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        //文字宽高
        mTextWidth = (int) mTextPaint.measureText(text);
        mTextHeight = mTextWidth == 0 ? 0 : (int) (fontMetrics.bottom - fontMetrics.top);

        // 获取绘制背景的高度和宽度（考虑了四个方向的padding值）
        mBgWidth = (int) (mTextWidth + mPaddingLeft + mPaddingRight);
        mBgHeight = (int) (mTextHeight + mPaddingTop + mPaddingBottom);

        int mWidth = mBgWidth;
        int mHeight = mBgHeight;

        // 当模式是AT_MOST（即wrap_content）时设置默认值
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, mHeight);
            // 宽 / 高任意一个模式为AT_MOST（即wrap_content）时，都设置默认值
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, mHeight);
        }
    }


    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        @SuppressLint("DrawAllocation") RectF rectF = new RectF(0, 0,
                mBgWidth, mBgHeight);

        //绘制背景
        canvas.drawRoundRect(rectF, mBgRadius, mBgRadius, mPaint);
        //绘制背景

        //float distanceY = rectF.centerY() + ((fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom);
        //float distanceX = rectF.centerX();
        //绘制文字
        float textX = mPaddingLeft;
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float distanceY = rectF.centerY() + ((fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom);
        //float textY = (mPaddingBottom == 0 ? mPadding + mTextHeight : mPaddingBottom + mTextHeight)/2;
        canvas.drawText(text, textX, distanceY, mTextPaint);

        /*// 获取传入的padding值
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();

        // 获取绘制内容的高度和宽度（考虑了四个方向的padding值）
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;

        @SuppressLint("DrawAllocation") RectF rectF = new RectF(paddingLeft, paddingTop,
                width + paddingRight, height + paddingBottom);

        //绘制背景
        canvas.drawRoundRect(rectF, mRadius, mRadius, mPaint);

        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float distanceY = rectF.centerY() + ((fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom);
        float distanceX = rectF.centerX();
        //绘制文字
        canvas.drawText(text, distanceX, distanceY, mTextPaint);*/

        /*Paint line = new Paint();
        line.setColor(Color.WHITE);
        //辅助线 横向
        canvas.drawLine(0,height/2,width,height/2,line);
        //辅助线 纵向
        canvas.drawLine(width/2,0,width/2,height,line);*/

    }

    /**
     * 设置背景颜色
     * @param color 颜色
     */
    protected void setBgColor(Context context,int color) {
        this.mBgColor = Color.parseColor(context.getResources().getString(color));
        init();
    }
    /**
     * 设置背景颜色
     * @param colorString 颜色
     */
    protected void setBgColor(String colorString) {
        this.mBgColor = Color.parseColor(colorString);
        init();
    }


    protected void setBgRadius(float radius) {
        this.mBgRadius = radius;
    }

    protected void setText(String text) {
        this.text = text;
    }

    protected void setTextSize(float size) {
        this.mTextSize = size;
    }

    protected void setTextColor(String colorString) {
        this.mTextColor = Color.parseColor(colorString);
        init();
    }

    /**
     * 设置文字颜色
     * @param color 颜色
     */
    protected void setTextColor(Context context,int color) {
        this.mTextColor = Color.parseColor(context.getResources().getString(color));
        init();
    }

}
