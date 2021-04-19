package com.icruz.showcard;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public abstract class CardNumberTextView extends AppCompatTextView  {

    boolean isFormat = true;
    int numHidden = 12;

    public CardNumberTextView(@NonNull Context context) {
        super(context);
        //build();
    }

    public CardNumberTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        build();
    }

    public CardNumberTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        build();
    }

    public void setFormat(boolean format) {
        isFormat = format;
    }

    abstract public void build();

    abstract public void hiddenNumbers(int size);

    abstract public void setFormat();


    /*public void hiddenNumbers(int hc){
        String inText = getText().toString();
        StringBuilder stringBuilder = new StringBuilder();
        int pos = 0;
        for (int i = 0; i < hc; i++) {
            stringBuilder.append("*");
            pos = i;
        }
        for (int i = pos + 1; i < inText.length(); i++){
            stringBuilder.append(inText.charAt(i));
        }
        setText(stringBuilder);
    }

    public void setFormat(){
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < getText().length(); i++){
            if (i % 4 == 0)
                out.append(" ");
            out.append(getText().charAt(i));
        }
        setText(out);
    }
    */
}
