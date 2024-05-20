package com.l0122061.farrellytheo.responsipab

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Circuit(
    val name: String,
    val desc: String,
    val img: Int,
    val car: Int,
    val descdet: String,
    val namedet: String,
    val driversatu: Int,
    val drivernumsatu: String,
    val drivernamesatu: String,
    val driverdua: Int,
    val drivernumdua: String,
    val drivernamedua: String,
) : Parcelable
