package com.biybiruza.gemmanagement.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity
data class Users(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String = "",
    @ColumnInfo(name = "phone_number") val phoneNumber: String = "",
    val password: String,
    val type: String
)
