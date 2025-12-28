package com.gaganbelgur.domain.model


sealed class CompanyTags(
    override val key: String,
    override val displayName: String
) : Tag() {

    object PHILIPS : CompanyTags("philips", "Philips")

    object CITI : CompanyTags("citi", "Citi")

    object MOLEKULE : CompanyTags("molekule", "Molekule")

    object SAMSUNG : CompanyTags("samsung", "Samsung")

    object NAVRITI : CompanyTags("navriti", "Navriti")

    object HOBBY : CompanyTags("hobby", "Hobby")

    object ALL: CompanyTags("all", "All")
}