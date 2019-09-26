package com.geanik.cvgenerator.service

import com.geanik.cvgenerator.model.CvInformation
import com.geanik.cvgenerator.model.EducationEntry
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CvGeneratorService {

    private var educationEntries = mutableListOf(EducationEntry("FH Hagenberg", "Software Engineering", "BSc.", LocalDate.now(), LocalDate.now()), EducationEntry("FH Hagenberg", "Software Engineering", "BSc.", LocalDate.now(), LocalDate.now()))
    private var cvInformation = CvInformation("Gea", "nik", "geanik@mail.com", "+43123", "Software Engineer", "BSc", educationEntries/*, ArrayList(), ArrayList(), ArrayList(), Arrays.asList("Java", "Scala")*/)

    fun loadCvInformation(): CvInformation {
        // TODO: load information
        return cvInformation
    }

    fun saveCvInformation(cvInformation: CvInformation) {
        // TODO: save information
        this.cvInformation = cvInformation
    }
}