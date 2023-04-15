package com.govind8061.mypdfviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView

class PdfViewerActivity : AppCompatActivity() {
    private lateinit var pdfView: PDFView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)

        pdfView = findViewById(R.id.pdfView)

//        val file: File = File(Environment.getExternalStorageDirectory(), "my_pdf_file.pdf")
//        pdfView.fromFile(file)

        pdfView.fromAsset("my_pdf.pdf")
            .defaultPage(0)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .onPageChange { page, pageCount ->
                // Handle page change events
            }
            .load()
    }
}