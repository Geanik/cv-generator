package com.geanik.cvgenerator.service.model

import java.io.ByteArrayOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

abstract class AbstractTemplate : Template {
    protected fun createZip(files: Iterable<Pair<String, ByteArray>>): ByteArray {
        val zipBos = ByteArrayOutputStream()
        ZipOutputStream(zipBos).use {
            for (file in files) {
                val entry = ZipEntry(file.first)
                it.putNextEntry(entry)

                it.write(file.second)
                it.closeEntry()
            }
        }
        return zipBos.toByteArray()
    }
}