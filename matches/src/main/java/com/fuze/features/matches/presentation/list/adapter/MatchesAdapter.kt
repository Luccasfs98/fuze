package com.fuze.features.matches.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fuze.commons.base.BaseListAdapter
import com.fuze.features.matches.domain.model.MatchModel

class MatchesAdapter(
    private val click: ((MatchModel) -> Unit)? = null) : BaseListAdapter<MatchModel>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    override fun onCreateViewHolder(parent: ViewGroup, inflater: LayoutInflater, viewType: Int) =
        MatchItemViewHolder(inflater)

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     * @see BaseListAdapter.onBindViewHolder
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MatchItemViewHolder -> holder.bind(getItem(position),click)
        }
    }

}