package com.example.alexmets.kotlincleanarchexample.content.data.somefeature

import android.os.Parcel
import android.os.Parcelable

class SomeCleanModel(private var mSomeString:String?, var mSomeIntger: Int) : Parcelable{


    constructor(parcel: Parcel?) : this(
    parcel?.readString(),
    parcel!!.readInt())

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(mSomeString)
        p0!!.writeInt(mSomeIntger)
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<SomeCleanModel> {
        override fun createFromParcel(parcel: Parcel): SomeCleanModel {
            return SomeCleanModel(parcel)
        }

        override fun newArray(size: Int): Array<SomeCleanModel?> {
            return arrayOfNulls(size)
        }
    }

}