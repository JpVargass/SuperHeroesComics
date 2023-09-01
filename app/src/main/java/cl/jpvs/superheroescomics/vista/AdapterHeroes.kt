package cl.jpvs.superheroescomics.vista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.jpvs.superheroescomics.R
import cl.jpvs.superheroescomics.data.local.HeroeEntity
import cl.jpvs.superheroescomics.databinding.ItemHeroeBinding
import coil.load

class AdapterHeroes : RecyclerView.Adapter<AdapterHeroes.ItemHeroeViewHolder>() {
    lateinit var binding: ItemHeroeBinding
    private val listItemHeroe = mutableListOf<HeroeEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHeroeViewHolder {
        binding = ItemHeroeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemHeroeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemHeroe.size
    }

    override fun onBindViewHolder(holder: ItemHeroeViewHolder, position: Int) {
        val heroe = listItemHeroe[position]
        holder.bind(heroe)
    }

    fun setData(heroe: List<HeroeEntity>) {
        this.listItemHeroe.clear()
        this.listItemHeroe.addAll(heroe)
        notifyDataSetChanged()
    }


    class ItemHeroeViewHolder(val heroeBinding: ItemHeroeBinding) :
        RecyclerView.ViewHolder(heroeBinding.root) {

        fun bind(heroe: HeroeEntity) {
            val bundle = Bundle()

            heroeBinding.txtNombreHeroe.text = heroe.nombre
            heroeBinding.txtAnnoCreacion.text = heroe.annoCreacion.toString()
            heroeBinding.imgHeroe.load(heroe.imagenLink)

            heroeBinding.cvItem.setOnClickListener {
                bundle.putInt("id", heroe.id)
                Navigation.findNavController(heroeBinding.root)
                    .navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }


        }
    }
}
