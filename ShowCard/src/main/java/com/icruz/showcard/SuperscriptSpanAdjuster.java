package com.icruz.showcard;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

class SuperscriptSpanAdjuster extends MetricAffectingSpan {

    double ratio;

    public SuperscriptSpanAdjuster(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public void updateDrawState(TextPaint paint) {
        paint.baselineShift += (int) (paint.ascent() * ratio);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        paint.baselineShift += (int) (paint.ascent() * ratio);
    }

}
