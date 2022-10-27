package com.fuze.features.matches.presentation.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fuze.commons.base.BaseListAdapter
import com.fuze.features.matches.domain.model.PlayerModel

class PlayersAdapter : BaseListAdapter<PlayerModel>(
    itemsSame = { old, new -> old.nickname == new.nickname },
    contentsSame = { old, new -> old == new }
) {

    override fun onCreateViewHolder(parent: ViewGroup, inflater: LayoutInflater, viewType: Int) =
        PlayerItemViewHolder(inflater)

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
            is PlayerItemViewHolder -> holder.bind(getItem(position))
        }
    }

}