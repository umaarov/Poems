package uz.umarov.poems.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.umarov.poems.Models.PoemsData
import uz.umarov.poems.R
import uz.umarov.poems.databinding.FavpoemsItemBinding

class Rv2Adapter(private var myList: ArrayList<PoemsData>, private var itemClick: ItemClick) :
    RecyclerView.Adapter<Rv2Adapter.Vh>() {
    inner class Vh(private val binding: FavpoemsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(poemsData: PoemsData) {
            binding.name.text = poemsData.name
            binding.poem.text = poemsData.poem
            binding.liked.setImageResource(R.drawable.like)
            binding.favCard.setOnClickListener {
                itemClick.isItemClick(poemsData)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(FavpoemsItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Rv2Adapter.Vh, position: Int) {
        holder.onBind(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    interface ItemClick {
        fun isItemClick(poemsData: PoemsData)
    }

}