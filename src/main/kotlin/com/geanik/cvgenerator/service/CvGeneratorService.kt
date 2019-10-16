package com.geanik.cvgenerator.service

import com.geanik.cvgenerator.data.CvInformationRepository
import com.geanik.cvgenerator.model.CvInformation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CvGeneratorService {

    @Autowired
    lateinit var cvInformationRepository: CvInformationRepository

    fun loadCvInformation(): CvInformation
        = cvInformationRepository.findAll().firstOrNull()
            ?: CvInformation("Gea", "nik", "geanik@mail.com", "+43123", "Software Engineer", "BSc")

    fun saveCvInformation(cvInformation: CvInformation) {
        cvInformationRepository.save(cvInformation)
    }
}