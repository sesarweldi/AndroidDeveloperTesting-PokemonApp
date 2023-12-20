package com.well.testpokemonapp.presentation.adapter.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<T : Any, VH : RecyclerView.ViewHolder, VB : ViewDataBinding> :
    RecyclerView.Adapter<VH>() {

    private val itemList: MutableList<T> = mutableListOf()

    protected abstract fun getLayoutIdForType(viewType: Int): Int
    abstract fun onCreateViewHolder(parent: ViewGroup, binding: VB): VH
    protected abstract fun bindViewHolder(holder: VH, item: T, position: Int)

    inner class BaseDiffUtilCallback(
        private val oldItemList: List<T>,
        private val newItemList: List<T>,
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldItemList.size
        }

        override fun getNewListSize(): Int {
            return newItemList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItemList[oldItemPosition] == newItemList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItemList[oldItemPosition] == newItemList[newItemPosition]
        }

    }

    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = DataBindingUtil.inflate<VB>(
            LayoutInflater.from(parent.context),
            getLayoutIdForType(viewType),
            parent,
            false
        )
        return onCreateViewHolder(parent, binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = itemList[position]
        bindViewHolder(holder, item, position)
    }

    fun setItems(list: List<T>) {
        this.itemList.clear()
        this.itemList.addAll(list)
    }

    fun setItemsAnimateChanges(itemList: List<T>) {
        animateNotifyChanged(
            oldItemList = this.itemList,
            newItemList = itemList,
            changeList = {
                setItems(itemList)
            }
        )
    }

    private inline fun animateNotifyChanged(
        oldItemList: List<T>,
        newItemList: List<T>,
        changeList: () -> Unit
    ) {
        val diffCallback = BaseDiffUtilCallback(oldItemList, newItemList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
        changeList()
    }

}