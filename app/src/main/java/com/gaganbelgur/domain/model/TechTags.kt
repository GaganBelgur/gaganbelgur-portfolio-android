package com.gaganbelgur.domain.model

sealed class TechTags(
    override val key: String,
    override val displayName: String,
) : Tag() {

    object BLE : TechTags("ble", "BLE")
    object TESTING : TechTags("testing", "Testing")

    object MEDICAL : TechTags("medical", "Medical")

    object SDK : TechTags("sdk", "SDK")

    object WIFI : TechTags("wifi", "Wi-Fi")

    object FINANCE : TechTags("finance", "Finance")

    object SECURITY : TechTags("security", "Security")

    object IOT : TechTags("iot", "IOT")

    object B2B : TechTags("b2b", "B2B")

    object MQTT : TechTags("mqtt", "MQTT")

    object ANALYTICS : TechTags("analytics", "Analytics")
    object UX : TechTags("ux", "UX")
    object KEYBOARD : TechTags("keyboard", "Keyboard")
    object STICKERS : TechTags("stickers", "Stickers")
    object AVATARS : TechTags("avatars", "Avatars")
    object EDTECH : TechTags("edtech", "EdTech")
    object OFFLINE : TechTags("offline", "Offline")
    object VIDEO : TechTags("video", "Video")
    object ASSESSMENT : TechTags("assessment", "Assessment")
    object AUDIT : TechTags("audit", "Audit")
    object INHOUSE : TechTags("inhouse", "In-House")
    object TRACKING : TechTags("tracking", "Tracking")
    object GEO : TechTags("geo", "Geo")
    object LOGISTICS : TechTags("logistics", "Logistics")
    object REIMBURSEMENTS : TechTags("reimbursements", "Reimbursements")
    object CAREERS : TechTags("careers", "Careers")
    object JOBS : TechTags("jobs", "Jobs")
    object UTILITY : TechTags("utility", "Utility")
}