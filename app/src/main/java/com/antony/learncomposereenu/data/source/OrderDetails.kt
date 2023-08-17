package com.antony.learncomposereenu.data.source

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderDetails(
    @ColumnInfo var qty: Int,
    @ColumnInfo var flavour: String){
    @PrimaryKey(autoGenerate = true) var uid:Int = 0
}
