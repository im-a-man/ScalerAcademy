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

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.Date

/**
 * Local users data. This is stored on disk in a database.
 */
@Entity(tableName = "users")
@TypeConverters()
data class Users(
    // Local fields.
    @PrimaryKey(autoGenerate = true)
    var primaryKey: Int = 0,
    var userName: String = "",

    // Remote fields.
    var mobile: String = "",
    var email: String = "",
    var dateOfBirth: Long
)


