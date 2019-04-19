package ir.kivee.mapmania.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ir.kivee.mapmania.R
import ir.kivee.mapmania.ui.fragment.MapsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(MapsFragment.newInstance(),"mapsFragment")
    }

    private fun openFragment(fr: Fragment, tag: String) {
        val ft = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag(tag)
        if (prev == null) {
            ft.replace(R.id.mActivityContainer, fr, tag)
            ft.addToBackStack(tag)
            ft.commit()
        } else {
            ft.replace(R.id.mActivityContainer, prev, tag)
            ft.commit()
        }
    }
}
