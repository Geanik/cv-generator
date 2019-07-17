package com.geanik.cvgenerator.service

import com.geanik.cvgenerator.model.CvInformation
import org.springframework.stereotype.Service

@Service
class CvGeneratorService {

    private var cvInformation = CvInformation("Gea", "nik", "geanik@mail.com", "+43123", "Software Engineer", "BSc")

    fun loadCvInfromation(): CvInformation {
        // TODO: load information
        return cvInformation
    }

    fun saveCvInformation(cvInformation: CvInformation) {
        // TODO: save information
        this.cvInformation = cvInformation
    }
}