package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Mahasiswa(
    val npm: Int,
    val nama: String?,
    val ipk: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(npm)
        parcel.writeString(nama)
        parcel.writeDouble(ipk)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mahasiswa> {
        override fun createFromParcel(parcel: Parcel): Mahasiswa {
            return Mahasiswa(parcel)
        }

        override fun newArray(size: Int): Array<Mahasiswa?> {
            return arrayOfNulls(size)
        }
    }
}
