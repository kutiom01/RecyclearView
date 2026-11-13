
package com.eman.myrestaurant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMenuAdapter(
    private val listMenu: ArrayList<Menu>
) : RecyclerView.Adapter<ListMenuAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_menu, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) {
        val menu = listMenu[position]

        holder.imgPhoto.setImageResource(menu.photo)
        holder.tvName.text = menu.name
        holder.tvDescription.text = menu.description

        holder.itemView.setOnClickListener {
            val intent = Intent(
                holder.itemView.context,
                DetailMenuActivity::class.java
            )

            intent.putExtra(
                DetailMenuActivity.EXTRA_NAME,
                menu.name
            )

            intent.putExtra(
                DetailMenuActivity.EXTRA_DESCRIPTION,
                menu.description
            )

            intent.putExtra(
                DetailMenuActivity.EXTRA_PHOTO,
                menu.photo
            )

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    class ListViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val imgPhoto: ImageView =
            itemView.findViewById(R.id.img_menu)

        val tvName: TextView =
            itemView.findViewById(R.id.tv_item_name)

        val tvDescription: TextView =
            itemView.findViewById(R.id.tv_item_description)
    }
}
