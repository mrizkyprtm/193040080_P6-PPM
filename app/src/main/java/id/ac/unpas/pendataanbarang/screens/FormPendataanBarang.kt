package id.ac.unpas.pendataanbarang.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.unpas.pendataanbarang.model.DataBarang
import id.ac.unpas.pendataanbarang.ui.theme.Purple700
import id.ac.unpas.pendataanbarang.ui.theme.Teal200

@Composable
fun FormPendataanBarang(onSimpan: (DataBarang) -> Unit) {
    val kode_brg = remember { mutableStateOf(TextFieldValue("")) }
    val nama_brg = remember { mutableStateOf(TextFieldValue("")) }
    val harga = remember { mutableStateOf(TextFieldValue("")) }
    val stok = remember { mutableStateOf(TextFieldValue("")) }
    val jenis_brg = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            label = { Text(text = "Kode Barang") },
            value = kode_brg.value,
            onValueChange = {
                kode_brg.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd") })

        OutlinedTextField(label = { Text(text = "Nama Barang") },
            value = nama_brg.value,
            onValueChange = {
                nama_brg.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text
            ),
            placeholder = { Text(text = "XXXXX") })

        OutlinedTextField(label = { Text(text = "Harga Barang") },
            value = harga.value, onValueChange = {
                harga.value = it
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(), keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ), placeholder = { Text(text = "5000") })

        OutlinedTextField(label = { Text(text = "Stok") },
            value = stok.value, onValueChange = {
                stok.value = it
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(), keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ), placeholder = { Text(text = "5") })

        OutlinedTextField(label = { Text(text = "Jenis Barang") },
            value = jenis_brg.value, onValueChange = {
                jenis_brg.value = it
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "cth: Peralatan Dapur") })

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700, contentColor = Teal200
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200, contentColor = Purple700
        )
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)) {
                Button(onClick = {
                    val item = DataBarang(
                        kode_brg.value.text,
                        nama_brg.value.text,
                        harga.value.text,
                        stok.value.text,
                        jenis_brg.value.text
                    )
                    onSimpan(item)
                    kode_brg.value = TextFieldValue("")
                    nama_brg.value = TextFieldValue("")
                    harga.value = TextFieldValue("")
                    stok.value = TextFieldValue("")
                    jenis_brg.value = TextFieldValue("")
                }, colors = loginButtonColors) {
                    Text(
                        text = "Simpan", style = TextStyle(
                            color = Color.White, fontSize = 18.sp
                        ), modifier = Modifier.padding(8.dp)
                    )
                }
            }

            Column(modifier = Modifier.padding(5.dp).fillMaxWidth()) {
                Button(onClick = {
                    kode_brg.value = TextFieldValue("")
                    nama_brg.value = TextFieldValue("")
                    harga.value = TextFieldValue("")
                    stok.value = TextFieldValue("")
                    jenis_brg.value = TextFieldValue("")
                }, colors = resetButtonColors) {
                    Text(
                        text = "Reset", style = TextStyle(
                            color = Color.White, fontSize = 18.sp
                        ), modifier = Modifier.padding(8.dp)
                    )
                }
            }


        }
    }
}