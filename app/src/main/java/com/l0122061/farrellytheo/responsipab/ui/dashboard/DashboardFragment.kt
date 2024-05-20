package com.l0122061.farrellytheo.responsipab.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122061.farrellytheo.responsipab.Circuit
import com.l0122061.farrellytheo.responsipab.DetailedActivity
import com.l0122061.farrellytheo.responsipab.ListAdapter
import com.l0122061.farrellytheo.responsipab.R

class DashboardFragment : Fragment() {

    private lateinit var rvCircuit: RecyclerView
    private val list = ArrayList<Circuit>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val customTitleBar = inflater.inflate(R.layout.custom_title_bar, null)

        val activity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.apply {
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            setCustomView(customTitleBar)
            setDisplayShowTitleEnabled(false)
        }

        rvCircuit = view.findViewById(R.id.rv_circuit)
        rvCircuit.setHasFixedSize(true)

        list.addAll(getListCircuit())
        showRecyclerList(view)

        return view
    }

    private fun getListCircuit(): ArrayList<Circuit> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataImg = resources.obtainTypedArray(R.array.data_img2)
        val dataCar = resources.obtainTypedArray(R.array.data_car)
        val dataDesc2 = resources.getStringArray(R.array.data_descdet)
        val dataNamedet = resources.getStringArray(R.array.data_namedet)
        val dataDriversatu = resources.obtainTypedArray(R.array.data_driversatu)
        val dataDrivernumsatu = resources.getStringArray(R.array.data_drivnumsatu)
        val dataDrivernamesatu = resources.getStringArray(R.array.data_drivnamesatu)
        val dataDriverdua = resources.obtainTypedArray(R.array.data_driverdua)
        val dataDrivernumdua = resources.getStringArray(R.array.data_drivnumdua)
        val dataDrivernamedua = resources.getStringArray(R.array.data_drivnamedua)

        val listCircuit = ArrayList<Circuit>()
        for (i in dataName.indices) {
            val circuit = Circuit(
                dataName[i],
                dataDesc[i],
                dataImg.getResourceId(i, -1),
                dataCar.getResourceId(i, -1),
                dataDesc2[i],
                dataNamedet[i],
                dataDriversatu.getResourceId(i, -1),
                dataDrivernumsatu[i],
                dataDrivernamesatu[i],
                dataDriverdua.getResourceId(i, -1),
                dataDrivernumdua[i],
                dataDrivernamedua[i]
            )
            listCircuit.add(circuit)
        }
        dataImg.recycle()
        return listCircuit
    }

    private fun showRecyclerList(view: View) {
        rvCircuit.layoutManager = LinearLayoutManager(requireContext())
        val listCarAdapter = ListAdapter(list)
        rvCircuit.adapter = listCarAdapter

        listCarAdapter.onItemClick = {
            val intent = Intent(requireContext(), DetailedActivity::class.java)
            intent.putExtra("circuit", it)
            startActivity(intent)
        }
    }
}
