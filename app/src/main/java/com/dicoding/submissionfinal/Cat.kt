package com.dicoding.submissionfinal

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Cat(
    var name: String,
    var description: String,
    var photo: Int
) : Parcelable
