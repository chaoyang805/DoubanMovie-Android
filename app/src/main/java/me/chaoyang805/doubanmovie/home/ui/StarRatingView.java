package me.chaoyang805.doubanmovie.home.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Locale;

import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.utils.ScreenUtils;

/**
 * Created by chaoyang805 on 16/10/18.
 */

public class StarRatingView extends View {

    @ColorInt
    private static final int DEFAULT_STAR_COLOR = 0xFFFFAD0B;
    @ColorInt
    private static final int DEFAULT_STAR_BG_COLOR = Color.TRANSPARENT;
    public static final float DEFAULT_RATING_SCORE = 0f;
    private static final int MINIUM_WIDTH_DP = 20;
    private static final int MINIUM_HEIGHT_DP = 40;
    private static final float MAX_SCORE = 10.0f;
    private static final float DEFAULT_TEXT_SPACING = 5.0f;
    private static final float DEAULT_TEXT_SIZE = 20.0f;

    // the popup color of the star
    @ColorInt
    private int mStarColor;

    // background color of the star
    @ColorInt
    private int mStarBgColor;

    private float mRatingScore = DEFAULT_RATING_SCORE;

    private PorterDuffXfermode mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private Path mPath = new Path();
    private RectF mBoundsRect = new RectF();
    private Bitmap mBitmap;
    private Canvas mCanvas;

    public StarRatingView(Context context) {
        this(context, null);
    }

    public StarRatingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StarRatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StarRatingView);
        mStarColor = ta.getColor(R.styleable.StarRatingView_starColor, DEFAULT_STAR_COLOR);
        mStarBgColor = ta.getColor(R.styleable.StarRatingView_starBgColor, DEFAULT_STAR_BG_COLOR);
        mRatingScore = ta.getFloat(R.styleable.StarRatingView_ratingScore, DEFAULT_RATING_SCORE);
        ta.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(width, height);

        mBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    private int measureWidth(int widthMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int result;
        if (widthSpecMode == MeasureSpec.EXACTLY) {
            result = widthSpecSize;
        } else {
            result = ScreenUtils.dp2px(getContext(), MINIUM_WIDTH_DP);
            if (widthSpecMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, widthSpecSize);
            }
        }
        return result;
    }

    public void setRatingScore(float ratingScore) {
        mRatingScore = ratingScore;
        postInvalidate();
    }

    public float getRatingScore() {
        return mRatingScore;
    }

    private int measureHeight(int heightMeasureSpec) {
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        int result;
        if (heightSpecMode == MeasureSpec.EXACTLY) {
            result = heightSpecSize;
        } else {
            result = ScreenUtils.dp2px(getContext(), MINIUM_HEIGHT_DP);
            if (heightSpecMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, heightSpecSize);
            }
        }
        return result;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawStar(canvas);
        drawText(canvas);
    }

    private void drawText(Canvas canvas) {

        String text = String.format(Locale.SIMPLIFIED_CHINESE, "%1.1f", mRatingScore);

        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(mStarColor);
        textPaint.setTextSize(DEAULT_TEXT_SIZE);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        final float x = getMeasuredWidth() / 2;
        final float y = getMeasuredHeight() - textPaint.getFontMetrics().bottom - DEFAULT_TEXT_SPACING;
        canvas.drawText(text, x, y, textPaint);

    }

    private void drawStar(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(mStarBgColor);
        paint.setStyle(Paint.Style.FILL);
        mCanvas.drawPath(getStarPath(), paint);

        paint.setXfermode(mPorterDuffXfermode);

        mPath.computeBounds(mBoundsRect, true);
        final float ratio = mRatingScore / MAX_SCORE;
        mBoundsRect.right = ratio * mBoundsRect.width();
        paint.setColor(mStarColor);
        mCanvas.drawRect(mBoundsRect, paint);
        canvas.drawBitmap(mBitmap, 0, 0, null);


    }

    private Path getStarPath() {
        mPath.reset();

        mPath.moveTo(0, 8.64f);
        mPath.lineTo(5.94f, 14.43f);
        mPath.lineTo(4.54f, 22.61f);
        mPath.lineTo(11.89f, 18.75f);
        mPath.lineTo(19.24f, 22.61f);
        mPath.lineTo(17.83f, 14.43f);
        mPath.lineTo(23.78f, 8.64f);
        mPath.lineTo(15.56f, 7.44f);
        mPath.lineTo(11.89f, 0f);
        mPath.lineTo(8.21f, 7.44f);
        mPath.close();
        Matrix matrix = new Matrix();
        final float starWidth = 23.78f;
        final float starHeight = 22.61f;
        final float widthScale = getMeasuredWidth() / starWidth;
        final float heightScale = getMeasuredHeight() / starHeight;
        final float scale = Math.min(widthScale, heightScale);
        matrix.setScale(scale, scale);
        mPath.transform(matrix);
        return mPath;
    }

}
