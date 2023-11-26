package com.tshahakurov.disneyapp.view.fragment.heroinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tshahakurov.disneyapp.databinding.FragmentHeroInfoBinding
import com.tshahakurov.disneyapp.model.Hero
import com.tshahakurov.disneyapp.util.loadImageUrl
import com.tshahakurov.disneyapp.view.fragment.heroinfo.adapter.CharacteristicsAdapter
import dagger.hilt.android.AndroidEntryPoint

private const val HERO_ID_KEY = "hero_id"
private const val DEFAULT_HERO_ID = 308

@AndroidEntryPoint
class HeroInfoFragment : Fragment() {

    private var _binding: FragmentHeroInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HeroInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getHeroById(arguments?.getInt(HERO_ID_KEY) ?: DEFAULT_HERO_ID)

        viewModel.hero.observe(viewLifecycleOwner) { hero ->
            with(binding) {
                setList(hero.characteristicList)

                heroName.text = hero.name

                heroImage.loadImageUrl(hero.imageUrl)
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressBarLayout.root.isVisible = it
        }

    }

    private fun setList(list: ArrayList<Hero.Characteristic>) {
        binding.characteristicsRecycler.run {
            if (adapter == null) {
                adapter = CharacteristicsAdapter()
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? CharacteristicsAdapter)?.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun getFragment(heroId: Int): HeroInfoFragment {
            return HeroInfoFragment().apply {
                arguments = bundleOf(
                    HERO_ID_KEY to heroId
                )
            }
        }
    }
}