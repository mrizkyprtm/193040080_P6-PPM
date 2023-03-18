package id.ac.unpas.pendataanbarang.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.pendataanbarang.model.DataBarang

@Database(entities = [DataBarang::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun dataBarangDao(): DataBarangDao
}