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
import android.view.ViewGroup;

import java.nio.file.Path;

public class EasyView extends View {

    //背景画笔
    private Paint mPaint;
    private int mColor;
    private float mRadius;
    //文字画笔
    private Paint mTextPaint;
    //文字颜色
    private int mTextColor;
    //文字大小
    private float mTextSize;
    //绘制文字内容
    private String text;

    public EasyView(Context context) {
        super(context);
        init();
    }

    public EasyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.EasyView);
        mColor = typedArray.getColor(R.styleable.EasyView_android_color, Color.BLACK);
        mRadius = typedArray.getDimension(R.styleable.EasyView_android_radius, 20f);
        text = typedArray.getString(R.styleable.EasyView_android_text);
        mTextColor = typedArray.getColor(R.styleable.EasyView_android_textColor, Color.WHITE);
        mTextSize = typedArray.getDimension(R.styleable.EasyView_android_textSize, 14f);
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
        mPaint.setColor(mColor);// 设置画笔颜色
        mPaint.setStrokeWidth(6f);// 设置画笔宽度
        mPaint.setStyle(Paint.Style.FILL);//设置画笔模式为填充
        mPaint.setAntiAlias(true);//设置画笔抗锯齿（光滑）

        //创建文字画笔
        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
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
        // 类似TextView,ImageView等针对wrap_content均在onMeasure()对设置默认宽 / 高值有特殊处理,具体读者可以自行查看
        int mWidth = 500;
        int mHeight = 160;

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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 获取传入的padding值
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
        canvas.drawText(text, distanceX, distanceY, mTextPaint);

        Paint line = new Paint();
        line.setColor(Color.WHITE);
        //辅助线 横向
        canvas.drawLine(0,height/2,width,height/2,line);
        //辅助线 纵向
        canvas.drawLine(width/2,0,width/2,height,line);

    }
}
