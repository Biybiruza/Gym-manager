package com.biybiruza.gemmanagement.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.biybiruza.gemmanagement.entities.Users

@Dao
interface UserDao {

    @Query("Select * from users")
    fun getUser(): List<Users>

    @Insert
    fun adduser(users: Users)

    @Query("Select * from users where phone_number Like :phone")
    fun checkPhone(phone: String): Boolean

    @Query("Select * from users where phone_number Like :phone and password like :password")
    fun checkPhoneAndPassword(phone: String, password: String): Boolean

}