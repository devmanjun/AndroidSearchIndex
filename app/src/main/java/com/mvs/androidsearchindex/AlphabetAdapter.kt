package com.mvs.androidsearchindex


import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.provider.FontsContract
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by User on 17-Mar-18.
 */
class AlphabetAdapter(private val alphabetList: List<Char>, private val mContext: Context, private val alphaClickListener: AlphabetClickListener) : RecyclerView.Adapter<AlphabetAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val mView = layoutInflater.inflate(R.layout.row_item_layout, parent, false)
        return MyViewHolder(mView)

    }

    override fun getItemCount(): Int {
        return alphabetList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.textView.text=alphabetList.get(position).toString()
        holder.textView.setOnClickListener({
            alphaClickListener.onAlphabetClicked(alphabetList.get(position))
            Companion.rowIndex =position
            this.notifyDataSetChanged()

        })
        if(Companion.rowIndex == position)
        {
            holder.textView.textSize=25F
            holder.textView.typeface= Typeface.DEFAULT_BOLD
        }
        else
        {
            holder.textView.textSize=15F
            holder.textView.typeface= Typeface.DEFAULT
        }
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textView: TextView = itemView.findViewById(R.id.tv_word)

    }

    companion object {
        private var rowIndex: Int=-1
    }

}