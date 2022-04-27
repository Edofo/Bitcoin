package bitcoinapp.kotlin.com.bitcoin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val postModel: PostModel): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_btc, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return when {
            position === 0 -> {
                holder.bindView(postModel.bpi?.USD, "$")

            }
            position === 1 -> {
                holder.bindView(postModel.bpi?.GBP, "£")

            }
            else -> {
                holder.bindView(postModel.bpi?.EUR, "€")

            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvMoney: TextView = itemView.findViewById(R.id.tvMoney)
    private val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
    private val tvFloat: TextView = itemView.findViewById(R.id.tvFloat)

    fun bindView(postModel: dataInfo?, symbol: String) {

        tvMoney.text = postModel?.code
        tvDesc.text = postModel?.description
        tvFloat.text = postModel?.rate_float.toString() + symbol
    }
}