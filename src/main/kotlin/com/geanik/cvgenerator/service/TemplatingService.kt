package com.geanik.cvgenerator.service

import com.geanik.cvgenerator.model.CvInformation
import com.geanik.cvgenerator.service.model.Template
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TemplatingService {
    @Autowired
    lateinit var templates: List<Template>

    fun getTemplateZip(info: CvInformation): ByteArray {
        val template = templates.first()

        return template.generateFile(info)
    }
}