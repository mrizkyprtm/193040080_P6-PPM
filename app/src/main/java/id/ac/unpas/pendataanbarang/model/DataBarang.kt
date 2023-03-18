package id.ac.unpas.pendataanbarang.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataBarang(
    @PrimaryKey val kode_brg: String,
    val nama_brg: String,
    val harga: String,
    val stok: String,
    val jenis_brg: String
)
