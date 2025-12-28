package com.gaganbelgur.model

import com.gaganbelgur.domain.model.CompanyTags
import com.gaganbelgur.domain.model.TechTags

data class Project(
    val name: String,
    val description: String,
    val tags: List<TechTags> = emptyList(),
    val company: CompanyTags? = null,
)