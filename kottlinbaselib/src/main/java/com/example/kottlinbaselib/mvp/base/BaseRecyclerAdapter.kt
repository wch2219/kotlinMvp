package com.example.kottlinbaselib.mvp.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kottlinbaselib.holder.CommonViewHolder

abstract class BaseRecyclerAdapter<T>:RecyclerView.Adapter<CommonViewHolder>() {


     var layoutInflater: LayoutInflater?=null

     var dataList: ArrayList<T>?=null

    protected var layoutId: Int = 0
    protected var mContext: Context?=null

    fun BaseRecyclerAdapter(context: Context, dataList: ArrayList<T>, layoutId: Int) {
        this.layoutInflater = LayoutInflater.from(context)
        this.dataList = dataList
        this.layoutId = layoutId
        this.mContext = context
    }

     override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        val itemView = layoutInflater?.inflate(layoutId, parent, false)
        return CommonViewHolder(itemView!!)
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        bindData(holder, dataList?.get(position)!!, position)
    }

    override fun getItemCount(): Int {
        return dataList?.size!!
    }

     abstract fun bindData(holder: CommonViewHolder, data: T, position: Int)

    fun addData(dataList: List<T>) {
        this.dataList?.addAll(dataList)
        notifyDataSetChanged()
    }

    fun getData(): List<T> {

        return dataList!!
    }

    fun clearData() {
        this.dataList?.clear()
    }

    fun removeData(postion: Int) {
        this.dataList?.removeAt(postion)
        this.notifyDataSetChanged()
    }
}