package id.kharozim.androidmockuserapi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.kharozim.androidmockuserapi.databinding.ItemUserBinding
import id.kharozim.androidmockuserapi.model.ResponseModel

class UserAdapter(private val context: Context) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private var lists = listOf<ResponseModel>()
    fun setData(data: List<ResponseModel>) {
        this.lists = data
        notifyDataSetChanged()
    }


    inner class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(responseModel: ResponseModel) {
            binding.run {
                tvName.text =
                    responseModel.name.title + " " + responseModel.name.first + " " + responseModel.name.last
                tvPhone.text = responseModel.phone
                Glide.with(root).load(responseModel.picture.medium).into(ivImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(lists[position])
    }

    override fun getItemCount(): Int = lists.size
}
