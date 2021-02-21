package com.mohamedhashim.circula.data.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
@Parcelize
data class Pokemon(
    var id: Int,
    var name: String,
    var imagePath: String
) : Parcelable