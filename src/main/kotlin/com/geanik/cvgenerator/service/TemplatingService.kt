package com.geanik.cvgenerator.service

import com.geanik.cvgenerator.model.CvInformation
import com.geanik.cvgenerator.service.model.Template
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TemplatingService {
    @Autowired
    private lateinit var templates: List<Template>

    fun getAvailableTemplates(): Collection<String>
        = templates.map { t -> t.name }

    fun getTemplateZip(templateName: String, info: CvInformation): ByteArray? {
        val template = templates.find { t -> t.name == templateName }

        return template?.populate(info)
    }
}