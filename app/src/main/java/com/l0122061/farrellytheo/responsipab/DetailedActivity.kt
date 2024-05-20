package com.l0122061.farrellytheo.responsipab

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Build
import android.view.WindowManager

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)

        val customTitleBar = layoutInflater.inflate(R.layout.custom_title_bar, null)
        supportActionBar?.apply {
            displayOptions = androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM
            setCustomView(customTitleBar)
        }

        window.statusBarColor = resources.getColor(R.color.colorTitleBar)

        val circuit = intent.getParcelableExtra<Circuit>("circuit")
        if (circuit != null) {
            val imageView: ImageView = findViewById(R.id.imageDetail)
            val titleView: TextView = findViewById(R.id.titleDetail)
            val desView: TextView = findViewById(R.id.desDetail)
            val carView: ImageView = findViewById(R.id.car_img)
            val driv1View: ImageView = findViewById(R.id.car_img1)
            val drivnum1View: TextView = findViewById(R.id.position_text1)
            val drivname1View: TextView = findViewById(R.id.name_text1)
            val driv2View: ImageView = findViewById(R.id.car_img2)
            val drivnum2View: TextView = findViewById(R.id.position_text2)
            val drivname2View: TextView = findViewById(R.id.name_text2)
            val drivteam1View: TextView = findViewById(R.id.team_text1)
            val drivteam2View: TextView = findViewById(R.id.team_text2)

            imageView.setImageResource(circuit.img)
            titleView.text = circuit.namedet
            desView.text = circuit.descdet
            carView.setImageResource(circuit.car)
            driv1View.setImageResource(circuit.driversatu)
            drivnum1View.text = circuit.drivernumsatu
            drivname1View.text = circuit.drivernamesatu
            driv2View.setImageResource(circuit.driverdua)
            drivnum2View.text = circuit.drivernumdua
            drivname2View.text = circuit.drivernamedua
            drivteam1View.text = circuit.name
            drivteam2View.text = circuit.name
        }
    }
}
