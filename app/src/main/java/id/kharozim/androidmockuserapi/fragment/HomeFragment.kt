package id.kharozim.androidmockuserapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import id.kharozim.androidmockuserapi.R
import id.kharozim.androidmockuserapi.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {


            val pagers = listOf<Pager>(
                Pager("Users", UsersFragment()),
                Pager("Favorites", FavoritesFragment()),
                Pager("Profile", ProfileFragment())
            )

            val pagerAdapter = MainPagerAdapter(pagers, childFragmentManager, lifecycle)

                vpHomeFragment.adapter = pagerAdapter
                TabLayoutMediator(tlHomeFragment, vpHomeFragment) { tab, index ->
                    tab.text = pagers[index].title
                }.attach()
        }
        return binding.root
    }

    data class Pager(val title: String, val fragment: Fragment)

    class MainPagerAdapter(
        private val list: List<Pager>,
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle
    ) : FragmentStateAdapter(fragmentManager, lifecycle) {
        override fun getItemCount(): Int {
            return list.size
        }

        override fun createFragment(position: Int): Fragment {
            return list[position].fragment
        }

    }


}

