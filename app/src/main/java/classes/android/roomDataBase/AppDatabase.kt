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

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(
    entities = [(UsersEntity::class)],
    version = 1,
    exportSchema = false
)
@TypeConverters(*[(Converters::class), (ImageConverters::class)])
abstract class AppDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        @VisibleForTesting
        private val DATABASE_NAME = "users-db"

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context.applicationContext).also { INSTANCE = it }
            }

        /**
         * Set up the database configuration.
         * The SQLite database is only created when it's accessed for the first time.
         */
        private fun buildDatabase(appContext: Context): AppDatabase {
            return Room.databaseBuilder(appContext, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()//Auto migrate to new schema version, instead of crashing
                .fallbackToDestructiveMigrationOnDowngrade()//Auto migrate to old schema version, instead of crashing
                .fallbackToDestructiveMigrationFrom(1)//Auto migrate to new schema version, from started version
                .addAutoMigrationSpec(object : AutoMigrationSpec {
                    override fun onPostMigrate(db: SupportSQLiteDatabase) {
                        super.onPostMigrate(db)
                    }
                })
                .addMigrations(MIGRATION_1_2)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                    }

                    override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                        super.onDestructiveMigration(db)
                    }

                    override fun onCreate(db: SupportSQLiteDatabase) {
                        // Create and pre-populate the database. See this article for more details:
                        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
                        super.onCreate(db)
                    }
                })
                .build()
        }


        /**
         * If there are not enough migrations provided to move from the current version to the latest
         * version, Room will clear the database and recreate so even if you have no changes between 2
         * versions, you should still provide a Migration object to the builder.
         * */
        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Since we didn't alter the table, there's nothing else to do here.
            }
        }
    }
}
