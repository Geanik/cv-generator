package com.geanik.cvgenerator.service.model

import com.geanik.cvgenerator.model.CvInformation
import org.springframework.stereotype.Component
import java.io.ByteArrayOutputStream

@Component
class BasicHtmlTemplate : AbstractTemplate() {
    override val name: String
        get() = "basic-html"

    override fun populate(info: CvInformation): ByteArray {
        val fileBos = ByteArrayOutputStream()
        fileBos.bufferedWriter().use {
            it.appendln("<html>")
            it.appendln("    <head>")
            it.appendln("        <title>CV</title>")
            it.appendln("    </head>")

            it.appendln("    <body>")
            it.appendln("        <div>")
            it.appendln("            ${info.firstName} ${info.lastName}")
            it.appendln("        </div>")
            it.appendln("    </body>")

            it.appendln("</html>")
        }

        return createZip(listOf(Pair("index.html", fileBos.toByteArray())))
    }
}