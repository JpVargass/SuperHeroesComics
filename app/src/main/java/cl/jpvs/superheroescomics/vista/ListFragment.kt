package cl.jpvs.superheroescomics.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.jpvs.superheroescomics.R
import cl.jpvs.superheroescomics.databinding.FragmentListBinding

private const val ARG_PARAM1 = "id"
class ListFragment : Fragment() {
  private var id: Int = 0
lateinit var binding : FragmentListBinding
private val heroeViewModel:HeroeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater,container,false)

        initAdapter()
        heroeViewModel.getAllHeroes()

        return binding.root
    }

    private fun initAdapter() {
      val adapter = AdapterHeroes()
        binding.rViewHeroes.adapter = adapter
        heroeViewModel.heroeLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }
}