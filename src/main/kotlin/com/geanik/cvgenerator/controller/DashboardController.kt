package com.geanik.cvgenerator.controller

import com.geanik.cvgenerator.model.CvInformation
import com.geanik.cvgenerator.service.CvGeneratorService
import com.geanik.cvgenerator.service.TemplatingService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.context.annotation.SessionScope
import org.springframework.http.HttpStatus

@Controller
@SessionScope
class DashboardController(private val cvGeneratorService: CvGeneratorService, private val templatingService: TemplatingService) {

    private var currentInformation: CvInformation = CvInformation()

    @GetMapping("/")
    fun getDashboard(model: Model): String {
        val info = cvGeneratorService.loadCvInformation()
        currentInformation = info
        model.addAttribute("cvInformation", currentInformation)

        model.addAttribute("availableTemplates", templatingService.getAvailableTemplates())

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

    @GetMapping("/download", produces = ["application/zip"])
    @ResponseBody
    fun downloadTemplate(template: String): ResponseEntity<ByteArray> {
        val zip = templatingService.getTemplateZip(template, currentInformation)
        return ResponseEntity(zip, HttpStatus.OK)
    }
}