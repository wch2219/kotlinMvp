package com.hg.kotlin.weight

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.kottlinbaselib.utils.DensityUtil
import com.hg.kotlin.R


/**
 * TODO: document your custom view class.
 */
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ExpandableTextView : LinearLayout {


    var attrs: AttributeSet? = null

    constructor(context: Context) : super(context) {

        initView(context!!, null, 0)
        initListener()

    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

        initView(context!!, attributeSet!!, 0)
        initListener()

    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        initView(context!!, attributeSet, defStyleAttr)
        initListener()

    }


    //字体颜色
    private var textColor = Color.BLACK
    //字体大小
    private var textSize = DensityUtil.sp2px(context, 18).toFloat()
    //最大行数
    private var maxLine = -1
    //文字
    private var text = ""
    //默认颜色
    private var defaultTextColor = Color.BLACK
    //默认字体大小
    private var defaultTextSize = DensityUtil.sp2px(context, 16).toFloat()
    //默认行数
    private var defaultLine = 2

    private var imageview: ImageView? = null
    private var textview: TextView? = null

    @SuppressLint("Recycle", "CustomViewStyleable")
    fun initView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        this.orientation = VERTICAL
        this.gravity = Gravity.RIGHT
        this.textview = TextView(context)
        this.textview!!.setLineSpacing(3f, 1f)
        this.addView(textview, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        this.imageview = ImageView(context)
        val padding = DensityUtil.dip2px(getContext(), 2f)
        this.imageview!!.setPadding(0, -1, padding, padding)
        this.imageview?.setImageResource(R.mipmap.icon_jiantdown)
        this
        val llp =
            LinearLayout.LayoutParams(DensityUtil.dip2px(getContext(),15f), DensityUtil.dip2px(getContext(),15f))
        this.addView(imageview, llp)

        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandTextViewStyle)
            textColor = typedArray.getColor(R.styleable.ExpandTextViewStyle_textColor, defaultTextColor)
            textSize = typedArray.getDimension(R.styleable.ExpandTextViewStyle_textSize, defaultTextSize)
            maxLine = typedArray.getInt(R.styleable.ExpandTextViewStyle_maxLine, defaultLine)
            text = typedArray.getString(R.styleable.ExpandTextViewStyle_text)
            setView()
            typedArray.recycle()
        }

    }
    fun setText(text:String){
        this.textview?.text = text
    }
    private fun setView() {
        //字体大小
        this.textview?.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
        this.textview?.setTextColor(this.textColor)
        this.textview?.text = text
        this.textview?.height = textview?.lineHeight!! * maxLine
        this.textview?.ellipsize = TextUtils.TruncateAt.END

        if (textview!!.lineCount > maxLine) {
            imageview?.setImageResource(R.mipmap.icon_jiantdown)
            imageview?.visibility = View.VISIBLE
        } else {
            this.textview?.height = textview?.lineHeight!!
            imageview?.visibility = View.GONE
        }

    }

    var isGo: Boolean = false
    private fun initListener() {
        this.setOnClickListener {
            isGo = !isGo

            if (isGo) {
                imageview?.setImageResource(R.mipmap.icon_jiantup)
                textview?.maxLines = Int.MAX_VALUE
            } else {
                textview?.maxLines = maxLine
                imageview?.setImageResource(R.mipmap.icon_jiantdown)

            }
        }
    }

}
