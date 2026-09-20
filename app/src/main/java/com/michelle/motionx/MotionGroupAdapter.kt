package com.michelle.motionx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat

class MotionGroupAdapter(
    private var groups: MutableList<MotionGroup>,
    private val onGroupClicked: (MotionGroup) -> Unit
) : RecyclerView.Adapter<MotionGroupAdapter.GroupViewHolder>() {

    class GroupViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val txtGroupIcon: TextView =
            view.findViewById(R.id.txtGroupIcon)

        val txtGroupName: TextView =
            view.findViewById(R.id.txtGroupName)

        val txtGroupDescription: TextView =
            view.findViewById(R.id.txtGroupDescription)

        val txtGroupMembers: TextView =
            view.findViewById(R.id.txtGroupMembers)

        val txtGroupCategory: TextView =
            view.findViewById(R.id.txtGroupCategory)

        val btnJoinGroup: TextView =
            view.findViewById(R.id.btnJoinGroup)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GroupViewHolder {

        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_motion_group,
                    parent,
                    false
                )

        return GroupViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: GroupViewHolder,
        position: Int
    ) {

        val group =
            groups[position]

        holder.txtGroupIcon.text =
            group.icon

        holder.txtGroupName.text =
            group.name

        holder.txtGroupDescription.text =
            group.description

        holder.txtGroupMembers.text =
            "${NumberFormat.getIntegerInstance().format(group.members)} members"

        holder.txtGroupCategory.text =
            group.category.uppercase()

        updateJoinButton(
            holder,
            group
        )

        holder.btnJoinGroup.setOnClickListener {

            group.isJoined =
                !group.isJoined

            updateJoinButton(
                holder,
                group
            )
        }

        holder.itemView.setOnClickListener {
            onGroupClicked(group)
        }
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    private fun updateJoinButton(
        holder: GroupViewHolder,
        group: MotionGroup
    ) {

        if (group.isJoined) {

            holder.btnJoinGroup.text =
                "JOINED"

            holder.btnJoinGroup.setBackgroundResource(
                R.drawable.bg_group_joined
            )

        } else {

            holder.btnJoinGroup.text =
                "JOIN"

            holder.btnJoinGroup.setBackgroundResource(
                R.drawable.bg_group_join
            )
        }
    }
}