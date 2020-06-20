package handtracking

import android.content.Context
import android.os.Environment
import android.widget.Toast
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter

internal class FileOperations(
        val context: Context,
        val name: String,
        val text: String?
) {


    fun saveData(append: Boolean) {
        try {
            println(text)
            val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "GESTURES")
            !file?.mkdirs()
            val myFile = File(file, "$name.txt")

            val fOut = FileOutputStream(myFile, append)
            val out = OutputStreamWriter(fOut)
            //zapisanie do pliku
            out.write(text)
            out.flush()
            out.close()

            //wyswietlenie komunikatu, że zapisano dane
            Toast.makeText(context, "Data Saved", Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            //obsluga wyjatku
            //w razie niepowodzenia zapisu do pliku zostaje wyswietlony komunikat a w konsoli zrzut stosu
            Toast.makeText(context, "Data Could not be added", Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

}