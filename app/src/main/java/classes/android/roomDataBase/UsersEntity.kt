/*
 * Copyright 2018 Google LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package classes.android.roomDataBase

import android.graphics.Bitmap
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

/**
 * Local users data. This is stored on disk in a database.
 */

@Entity(tableName = "users")
@TypeConverters(*[(Converters::class), (ImageConverters::class)])
data class UsersEntity(
    // Local fields.
    @PrimaryKey(autoGenerate = true)
    var primaryKey: Int = 0,
    var userName: String = "",
    var userImage: Bitmap,

    // Remote fields.
    var mobile: String = "",
    var email: String = "",
    var dateOfBirth: Long,
    @Embedded
    var userAddress: Address,
)

data class Address(
    val streetName: String,
    val streetNumber: Int,
    @Embedded
    val coordinates: Coordinates
)

data class Coordinates(
    val latitude: Double,
    val longitude: Double,
)