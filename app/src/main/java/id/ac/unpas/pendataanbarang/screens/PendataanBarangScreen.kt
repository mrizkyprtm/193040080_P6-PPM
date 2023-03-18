package id.ac.unpas.pendataanbarang.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import id.ac.unpas.pendataanbarang.model.DataBarang
import id.ac.unpas.pendataanbarang.persistences.AppDatabase

@Composable
fun PendataanBarangScreen() {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pendataan-barang"
    ).build()
    val dataBarangDao = db.dataBarangDao()

    val list: LiveData<List<DataBarang>> = dataBarangDao.loadAll()
    val items: List<DataBarang> by list.observeAsState(initial = listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
        FormPendataanBarang(dataBarangDao)

        Row(modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()) {

            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Kode Barang", fontSize = 14.sp, textAlign = TextAlign.Center)
            }

            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Nama Barang", fontSize = 14.sp, textAlign = TextAlign.Center)
            }

            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Harga", fontSize = 14.sp, textAlign = TextAlign.Center)
            }

            Column(modifier = Modifier.weight(2f)) {
                Text(text = "Stok", fontSize = 14.sp, textAlign = TextAlign.Center)
            }

            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Jenis Barang", fontSize = 14.sp, textAlign = TextAlign.Center)
            }
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->
                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {

                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = item.kode_brg, fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                    }

                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = item.nama_brg, fontSize = 15.sp, fontWeight =
                        FontWeight.Bold)
                    }

                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Rp. ${item.harga}", fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                    }

                    Column(modifier = Modifier.weight(2f)) {
                        Text(text = item.stok, fontSize = 15.sp, fontWeight =
                        FontWeight.Bold)
                    }

                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = item.jenis_brg, fontSize = 15.sp, fontWeight =
                        FontWeight.Bold)
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}