package com.michelle.motionx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat

class LeaderboardAdapter(
    private var athletes: MutableList<AthleteRanking>,
    private val onAthleteClicked: (AthleteRanking) -> Unit
) : RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>() {

    class LeaderboardViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val txtRank: TextView =
            view.findViewById(R.id.txtRank)

        val txtAvatar: TextView =
            view.findViewById(R.id.txtAvatar)

        val txtAthleteName: TextView =
            view.findViewById(R.id.txtAthleteName)

        val txtAthleteStats: TextView =
            view.findViewById(R.id.txtAthleteStats)

        val txtXp: TextView =
            view.findViewById(R.id.txtXp)

        val btnFollow: TextView =
            view.findViewById(R.id.btnFollow)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LeaderboardViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_leaderboard,
                parent,
                false
            )

        return LeaderboardViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: LeaderboardViewHolder,
        position: Int
    ) {

        val athlete = athletes[position]

        holder.txtRank.text =
            "#${athlete.rank}"

        holder.txtAvatar.text =
            athlete.initials

        holder.txtAthleteName.text =
            athlete.name

        holder.txtAthleteStats.text =
            "${athlete.distance} km  •  ${athlete.activities} activities"

        holder.txtXp.text =
            "🔥 ${NumberFormat.getIntegerInstance().format(athlete.xp)} XP"

        updateFollowButton(
            holder,
            athlete
        )

        holder.btnFollow.setOnClickListener {

            athlete.isFollowing =
                !athlete.isFollowing

            updateFollowButton(
                holder,
                athlete
            )
        }

        holder.itemView.setOnClickListener {
            onAthleteClicked(athlete)
        }
    }

    override fun getItemCount(): Int {
        return athletes.size
    }

    fun updateData(newAthletes: List<AthleteRanking>) {

        athletes = newAthletes.toMutableList()

        notifyDataSetChanged()
    }

    private fun updateFollowButton(
        holder: LeaderboardViewHolder,
        athlete: AthleteRanking
    ) {

        if (athlete.isFollowing) {

            holder.btnFollow.text =
                "FOLLOWING"

            holder.btnFollow.setBackgroundResource(
                R.drawable.bg_following_button_active
            )

        } else {

            holder.btnFollow.text =
                "FOLLOW"

            holder.btnFollow.setBackgroundResource(
                R.drawable.bg_leaderboard_follow
            )
        }
    }
}