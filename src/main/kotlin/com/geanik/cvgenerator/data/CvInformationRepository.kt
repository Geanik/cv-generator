package com.geanik.cvgenerator.data;

import com.geanik.cvgenerator.model.CvInformation
import org.springframework.data.repository.CrudRepository

interface CvInformationRepository : CrudRepository<CvInformation, Long> {
    fun findCvInformationByFirstNameAndLastName(firstName: String, lastName: String) : Iterable<CvInformation>
}
