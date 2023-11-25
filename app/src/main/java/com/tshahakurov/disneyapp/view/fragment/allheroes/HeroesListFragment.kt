package com.tshahakurov.disneyapp.view.fragment.allheroes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tshahakurov.disneyapp.R
import com.tshahakurov.disneyapp.databinding.FragmentHeroesListBinding
import com.tshahakurov.disneyapp.model.Hero
import com.tshahakurov.disneyapp.view.fragment.allheroes.adapter.HeroesListAdapter
import com.tshahakurov.disneyapp.view.fragment.heroinfo.HeroInfoFragment
import com.tshahakurov.disneyapp.view.fragment.heroinfo.adapter.CharacteristicsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesListFragment : Fragment() {

    private var _binding: FragmentHeroesListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HeroesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            getHeroList()

            heroList.observe(viewLifecycleOwner) {
                setList(it)
            }

            isLoading.observe(viewLifecycleOwner) {
                binding.progressBarLayout.root.isVisible = it
            }
        }

    }

    private fun setList(list: ArrayList<Hero>) {
        binding.allHeroesRecycler.run {
            if (adapter == null) {
                adapter = HeroesListAdapter { id ->
                    parentFragmentManager.beginTransaction()
                        .add(R.id.container, HeroInfoFragment.getFragment(id))
                        .addToBackStack(null)
                        .commit()
                }
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
            (adapter as? HeroesListAdapter)?.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}