package com.example.kottlinbaselib.holder
import android.util.SparseArray
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
class CommonViewHolder(itemView: View, var commonClickListener: OnItemCommonClickListener? = null) : RecyclerView.ViewHolder(itemView),InterfaceViewHolder<CommonViewHolder>{

    // SparseArray 比 HashMap 更省内存，在某些条件下性能更好，只能存储 key 为 int 类型的数据，
    // 用来存放 View 以减少 findViewById 的次数
    private var viewSparseArray: SparseArray<View>
    var onItemCommonClickListener:OnItemCommonClickListener?=null
        set
    init {
        itemView.setOnClickListener(this)
        itemView.setOnLongClickListener(this)
        viewSparseArray = SparseArray()
    }

    /**
     * 根据 ID 来获取 View
     *
     * @param viewId viewID
     * @param <T>    泛型
     * @return 将结果强转为 View 或 View 的子类型
    </T> */
    override fun <T : View> getView(viewId: Int): T {
        // 先从缓存中找，找打的话则直接返回
        // 如果找不到则 findViewById ，再把结果存入缓存中
        var view: View? = viewSparseArray.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            viewSparseArray.put(viewId, view)
        }
        return view as T
    }

   override fun setText(viewId: Int, text: CharSequence): CommonViewHolder {
        val tv = getView<TextView>(viewId)
        tv.text = text
        return this
    }

   override fun setViewVisibility(viewId: Int, visibility: Int): CommonViewHolder {
        getView<View>(viewId).visibility = visibility
        return this
    }

   override fun setImageResource(viewId: Int, resourceId: Int): CommonViewHolder {
        val imageView = getView<ImageView>(viewId)
       imageView.setImageResource(resourceId)
        return this
    }

   override fun setTextColor(viewId: Int, textColor: Int): CommonViewHolder {
        var view = getView<TextView>(viewId)
       view.setTextColor(textColor)
        return this
    }

   override fun setBackGroundRes(viewId: Int, @DrawableRes resourceId: Int): CommonViewHolder {
        val view = getView<View>(viewId)
        view.setBackgroundResource(resourceId)

        return this
    }

   override fun setCheckBox(viewId: Int, ischeck: Boolean): CommonViewHolder {
        val checkBox = getView<CheckBox>(viewId)

        checkBox.isChecked = ischeck

        return this
    }


    interface OnItemCommonClickListener {

        fun onItemClickListener(position: Int)

        fun onItemLongClickListener(position: Int)

    }

    /**
     * 关于事件的
     */
   override fun setOnClickListener(viewId: Int, listener: View.OnClickListener): CommonViewHolder {
        val view = getView<View>(viewId)
        view.setOnClickListener(listener)
        return this
    }

    /**
     * 关于事件的
     */
    override fun setOnLongClickListener(viewId: Int, listener: View.OnLongClickListener): CommonViewHolder {
        val view = getView<View>(viewId)
        view.setOnLongClickListener(listener)
        return this
    }



    override fun onClick(v: View) {
        if (commonClickListener != null) {
            commonClickListener!!.onItemClickListener(adapterPosition)
        }
    }

    override fun onLongClick(v: View): Boolean {
        if (commonClickListener != null) {
            commonClickListener!!.onItemLongClickListener(adapterPosition)
        }
        return false
    }



}