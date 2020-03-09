import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.OnClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


/**
 * @author Anupam Singh
 * @version 1.0
 * @since 2020-03-09
 */
class BaseRecyclerViewAdapter(private val interaction: Interaction? = null) :
    ListAdapter<BaseRecyclerItemModel, BaseRecyclerViewAdapter.BaseRecyclerViewHolder>(BaseRecyclerItemModelDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BaseRecyclerViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.base_recycler_item, parent, false), interaction
    )

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder, position: Int) = holder.bind(getItem(position))

    fun swapData(data: List<BaseRecyclerItemModel>) {
        submitList(data.toMutableList())
    }

    inner class BaseRecyclerViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView), OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            if (adapterPosition == RecyclerView.NO_POSITION) return

            val clicked = getItem(adapterPosition)
        }

        fun bind(item: BaseRecyclerItemModel) = with(itemView) {
            // TODO: Bind the data with View
        }
    }

    interface Interaction {

    }

    private class BaseRecyclerItemModelDC : DiffUtil.ItemCallback<BaseRecyclerItemModel>() {
        override fun areItemsTheSame(
            oldItem: BaseRecyclerItemModel,
            newItem: BaseRecyclerItemModel
        ): Boolean {
            TODO(
                "not implemented"
            )
        }

        override fun areContentsTheSame(
            oldItem: BaseRecyclerItemModel,
            newItem: BaseRecyclerItemModel
        ): Boolean {
            TODO(
                "not implemented"
            )
        }
    }
}