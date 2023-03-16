package id.ac.unpas.pendataanbarang.model

data class DataBarang(
    val kode_brg: String,
    val nama_brg: String,
    val harga: String,
    val stok: Int,
    val jenis_brg: String
)
