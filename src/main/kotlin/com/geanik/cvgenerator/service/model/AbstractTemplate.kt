package com.geanik.cvgenerator.service.model

import java.io.ByteArrayOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

abstract class AbstractTemplate : Template {
    protected fun writeZip(fileNames: Iterable<String>, fileContents: Iterable<ByteArray>): ByteArray {
        val zipBos = ByteArrayOutputStream()
        val zip = ZipOutputStream(zipBos)
        zip.use {
            for (content in fileContents) {
                val entry = ZipEntry("index.html")
                it.putNextEntry(entry)

                it.write(content)
                it.closeEntry()
            }
        }
        return zipBos.toByteArray()
    }
}