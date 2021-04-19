package com.icruz.showcard;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CardNumberHorizontalView extends CardNumberTextView{

    public CardNumberHorizontalView(@NonNull Context context) {
        super(context);
        setTextDefault();
    }

    public CardNumberHorizontalView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTextDefault();
    }

    public CardNumberHorizontalView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTextDefault();
    }


    public void setNumHidden(int numHidden) {
        this.numHidden = numHidden;
    }

    public void setTextDefault(){
        setText(new StringBuilder("1234123412341234"));
    }

    @Override
    public void build() {
        int endLenght = numHidden;
        hiddenNumbers(numHidden);
        if (isFormat) {
            setFormat();
            endLenght = numHidden + numHidden / 4;
        }
        String progresNum = getText().toString().trim();
        SpannableString spannableString = new SpannableString(progresNum);
        spannableString.setSpan(new RelativeSizeSpan(FormatConstans.FORMAT_PROPORTION), 0,endLenght, 0);
        spannableString.setSpan(new SuperscriptSpanAdjuster(FormatConstans.FORMAT_RATION), 0, endLenght, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(spannableString);
    }


    @Override
    public void hiddenNumbers(int size) {
        String inText = getText().toString();
        StringBuilder stringBuilder = new StringBuilder();
        int pos = 0;
        for (int i = 0; i < size; i++) {
            stringBuilder.append("*");
            pos = i;
        }
        for (int i = pos + 1; i < inText.length(); i++){
            stringBuilder.append(inText.charAt(i));
        }
        setText(stringBuilder);
    }

    @Override
    public void setFormat() {
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < getText().length(); i++){
            if (i % 4 == 0)
                out.append(" ");
            out.append(getText().charAt(i));
        }
        setText(out);
    }
}
