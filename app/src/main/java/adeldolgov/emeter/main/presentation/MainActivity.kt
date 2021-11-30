package adeldolgov.emeter.main.presentation

import adeldolgov.emeter.R
import adeldolgov.emeter.common_ui.base.binding.BindingActivity
import adeldolgov.emeter.counters.presentation.CountersFragment
import adeldolgov.emeter.databinding.ActivityMainBinding
import adeldolgov.emeter.info.presentation.InfoFragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment

/*
*@author Adel Dolgov on 21,Ноябрь,2021
*/
internal class MainActivity : BindingActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        if (savedInstanceState == null) showFragment(CountersFragment.newInstance(), FRAGMENT_COUNTERS_TAG)
    }

    private fun initUi() {
        binding.mainNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_counters ->
                    (supportFragmentManager.findFragmentByTag(FRAGMENT_COUNTERS_TAG) ?: CountersFragment.newInstance()) to FRAGMENT_COUNTERS_TAG
                R.id.action_info ->
                    (supportFragmentManager.findFragmentByTag(FRAGMENT_INFO_TAG) ?: InfoFragment.newInstance()) to FRAGMENT_INFO_TAG
                else -> null
            }?.let { fragmentWithTag -> showFragment(fragmentWithTag.first, fragmentWithTag.second) }
            true
        }
        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                finish()
            } else {
                supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name?.let {
                    setBottomNavigationItemByTag(it)
                }
            }
        }
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainer)?.tag != tag) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.fragmentContainer, fragment, tag)
                .addToBackStack(tag)
                .commit()
        }
    }

    private fun setBottomNavigationItemByTag(tag: String) {
        when (tag) {
            FRAGMENT_COUNTERS_TAG -> binding.mainNavigation.menu.findItem(R.id.action_counters).isChecked = true
            FRAGMENT_INFO_TAG -> binding.mainNavigation.menu.findItem(R.id.action_info).isChecked = true
        }
    }

    companion object {

        private const val FRAGMENT_COUNTERS_TAG = "counters_fragment"
        private const val FRAGMENT_INFO_TAG = "info_fragment"

        fun createIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}