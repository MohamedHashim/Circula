package com.mohamedhashim.circula.data.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 2/21/2021.
 */
@Entity
@Parcelize
class Pokemon(
    @PrimaryKey var id: Int,
    var name: String,
    var imagePath: String
) : Parcelable