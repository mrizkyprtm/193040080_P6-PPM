package id.ac.unpas.pendataanbarang.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.pendataanbarang.model.DataBarang

@Dao
interface DataBarangDao {
   @Query("SELECT * FROM databarang")
   fun loadAll(): LiveData<List<DataBarang>>

   @Query("SELECT * FROM databarang WHERE kode_brg = :kode_brg")
   fun find(kode_brg: String): DataBarang?

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAll(vararg items: DataBarang)

   @Delete
   fun delete(items: DataBarang)
}