package com.geanik.cvgenerator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CvGeneratorApplication

fun main(args: Array<String>) {
	runApplication<CvGeneratorApplication>(*args)
}
