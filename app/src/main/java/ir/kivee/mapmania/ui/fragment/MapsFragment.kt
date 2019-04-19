package ir.kivee.mapmania.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import ir.kivee.mapmania.R
import kotlinx.android.synthetic.main.fragment_maps.*

class MapsFragment : Fragment(), OnMapReadyCallback {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_maps, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap(savedInstanceState)
    }


    override fun onMapReady(p0: GoogleMap?) {

    }

    private fun initMap(savedInstanceState: Bundle?) {
        fMapsMapView.onCreate(savedInstanceState)
        fMapsMapView.onResume()
        try {
            MapsInitializer.initialize(activity!!.applicationContext)
        } catch (e: Exception) {
            Log.d("p4yam", e.message)
        }
        fMapsMapView.getMapAsync(this)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MapsFragment()
    }
}
