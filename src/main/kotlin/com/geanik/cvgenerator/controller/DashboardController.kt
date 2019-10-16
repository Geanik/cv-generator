package com.geanik.cvgenerator.controller

import com.geanik.cvgenerator.model.CvInformation
import com.geanik.cvgenerator.service.CvGeneratorService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.context.annotation.SessionScope


@Controller
@SessionScope
class DashboardController(private val cvGeneratorService: CvGeneratorService) {

    private var currentInformation: CvInformation = CvInformation()

    @GetMapping("/")
    fun getDashboard(model: Model): String {
        currentInformation = cvGeneratorService.loadCvInformation()

        model.addAttribute("cvInformation", currentInformation)
        return "dashboard"
    }

    @PostMapping("/update")
    fun updateInfo(@ModelAttribute cvInformation: CvInformation): String {
        currentInformation.firstName = cvInformation.firstName
        currentInformation.lastName = cvInformation.lastName
        currentInformation.phone = cvInformation.phone
        currentInformation.email = cvInformation.email
        currentInformation.jobTitle = cvInformation.jobTitle
        currentInformation.academicDegree = cvInformation.academicDegree

        cvGeneratorService.saveCvInformation(currentInformation)
        return "redirect:/"
    }

}