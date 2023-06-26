package uz.umarov.poems.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.umarov.poems.Models.PoemsData
import uz.umarov.poems.databinding.PoemsItemBinding

class RvAdapter(private var myList: ArrayList<PoemsData>,  private var itemClick: ItemClick) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(private val binding: PoemsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(poemsData: PoemsData) {
            binding.name.text = poemsData.name
            binding.poem.text = poemsData.poem
            binding.poem.setOnClickListener {
                itemClick.isItemClick(poemsData)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(PoemsItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(myList[position])
    }

    interface ItemClick {
        fun isItemClick(poemsData: PoemsData)
    }
}