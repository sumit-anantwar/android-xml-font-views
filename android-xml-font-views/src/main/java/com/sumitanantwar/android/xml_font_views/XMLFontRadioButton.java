package com.sumitanantwar.android.xml_font_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

/**
 * Created by Sumit Anantwar on 12/17/16.
 */

public class XMLFontRadioButton extends AppCompatRadioButton
{
    private final Context mContext;

    private String mFontFile;

    // Designated Initializers
    public XMLFontRadioButton(Context context)
    {
        this(context, null);
    }

    public XMLFontRadioButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mContext = context;
        initWithAttributes(attrs, 0);
    }

    public XMLFontRadioButton(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initWithAttributes(attrs, defStyleAttr);
    }

    // Common Initializer
    private void initWithAttributes(AttributeSet attrs, int defStyleAttr)
    {
        final TypedArray attributes = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.XMLFontRadioButton, defStyleAttr, 0);

        String fontFilename = attributes.getString(R.styleable.XMLFontRadioButton_font_file);
        if (fontFilename != null) setFontFile(fontFilename);

        attributes.recycle();
    }

    public void setFontFile(String filename)
    {
        mFontFile = filename;

        setTypeface(FontManager.getTypeFaceForFont(mContext, filename));
    }

    public String getFontFile()
    {
        return mFontFile;
    }
}
