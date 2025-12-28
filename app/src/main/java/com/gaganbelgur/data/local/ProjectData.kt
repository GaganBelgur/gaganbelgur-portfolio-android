package com.gaganbelgur.data.local

import com.gaganbelgur.domain.model.CompanyTags
import com.gaganbelgur.domain.model.TechTags
import com.gaganbelgur.model.Project

internal fun getProjectList() =
    listOf(
        systemTestApp,
        odin,
        connectivitySDK,
        citiBankMobile,
        molekuleB2B,
        molekuleConsumer,
        molekuleIAQ,
        samsungCursorControl,
        samsungEmotify,
        uap,
        ciiSkills,
        careerMap,
        esciiCentreAudit,
        uapCentreAudit,
        fmsFacilitatorMonitoring,
        amaFacilitatorMonitoring,
        pramaanJobs,
        digitalSportsStopWatch
    )

val systemTestApp = Project(
    name = "System Test App",
    description = """ 
        Demo app for Connectivity SDK validation. Features BLE device pairing, RSSI reading, background sync, port properties read/write, subscriptions, and continuous fetch.
        """.trimIndent(),
    tags = listOf(TechTags.BLE, TechTags.TESTING),
    company = CompanyTags.PHILIPS
)

val odin = Project(
    name = "ODIN",
    description = """
        Mobile app to connect Philips medical BLE devices (Thermometer, BP Meter, Weighing Scale, Pulse Oximeter) and work with the 2Net Hub for broad healthcare workflows.
        """.trimIndent(),
    tags = listOf(TechTags.BLE, TechTags.MEDICAL),
    company = CompanyTags.PHILIPS
)

val connectivitySDK = Project(
    name = "Connectivity SDK",
    description = """
        Cross-platform BLE & Wi-Fi library for Android and iOS providing robust primitives and advanced features to power multiple propositions.
        """.trimIndent(),
    tags = listOf(TechTags.SDK, TechTags.BLE, TechTags.WIFI),
    company = CompanyTags.PHILIPS
)

val citiBankMobile = Project(
    name = "Citi Bank Mobile",
    description = """
        Banking app for fund transfers, statements (download/view), and credit card & account management. Released across multiple markets with compliance and performance focus.
        """.trimIndent(),
    tags = listOf(TechTags.FINANCE, TechTags.SECURITY),
    company = CompanyTags.CITI
)

val molekuleB2B = Project(
    name = "Molekule B2B",
    description = """
      B2B app for organizations to group and manage multiple purifiers. control by type (speed, mode, filter status) and reorder devices within groups.
      """.trimIndent(),
    tags = listOf(TechTags.IOT, TechTags.B2B),
    company = CompanyTags.CITI
)

val molekuleConsumer = Project(
    name = "Molekule Consumer",
    description = """
        IoT app to onboard Molekule Air Purifiers, control fan speeds and modes, view particle levels, and stream real - time data via MQTT. Includes historical charts and smooth animations.
        """.trimIndent(),
    tags = listOf(
        TechTags.IOT,
        TechTags.MQTT
    ),
    company = CompanyTags.MOLEKULE
)

val molekuleIAQ = Project(
    name = "Molekule IAQ",
    description = """
        Indoor Air Quality app with rich graphs for CO₂, Chemicals, Humidity, Coarse/Fine/Microfine particles and daily/weekly/yearly insights.
        """.trimIndent(),
    tags = listOf(
        TechTags.ANALYTICS,
        TechTags.IOT
    ),
    company = CompanyTags.MOLEKULE
)

val samsungCursorControl = Project(
    name = "Samsung Keyboard – Cursor Control",
    description = """
        Honey Board feature enabling precise cursor movement via swipe gestures to improve text editing UX.
        """.trimIndent(),
    tags = listOf(
        TechTags.KEYBOARD,
        TechTags.UX
    ),
    company = CompanyTags.SAMSUNG
)

val samsungEmotify = Project(
    name = "Samsung Keyboard – Emotify",
    description = """
        Sticker platform offering default and customized avatar stickers. Users select gender and customize with predefined accessories.
        """.trimIndent(),
    tags = listOf(
        TechTags.STICKERS,
        TechTags.AVATARS
    ),
    company = CompanyTags.SAMSUNG
)

val uap = Project(
    name = "UAP – Unified Assessment Platform",
    description = """
        End-to-end exam platform for theory & practical with batching, paper download, offline mode, and facilitator-led practicals.       
         """.trimIndent(),
    tags = listOf(
        TechTags.EDTECH,
        TechTags.OFFLINE
    ),
    company = CompanyTags.NAVRITI
)

val ciiSkills = Project(
    name = "CII Skills",
    description = """
        Video assessment app integrating with Certiplate for paper/schedule downloads, offline assessments, and real-time sync for evaluation.
        """.trimIndent(),
    tags = listOf(
        TechTags.VIDEO,
        TechTags.EDTECH
    ),
    company = CompanyTags.NAVRITI
)

val careerMap = Project(
    name = "Career Map",
    description = """
        Assessment interface supporting online/offline, multilingual selection, timers, and auto-submit on time-out.
        """.trimIndent(),
    tags = listOf(
        TechTags.ASSESSMENT,
        TechTags.OFFLINE
    ),
    company = CompanyTags.NAVRITI
)

val esciiCentreAudit = Project(
    name = "ESCII – Centre Audit",
    description = """
        Audit tool for the electronics sector with role-based views, inspection flows, and data projections for auditors/chief assessors.
        """.trimIndent(),
    tags = listOf(
        TechTags.AUDIT,
        TechTags.ANALYTICS
    ),
    company = CompanyTags.NAVRITI
)

val uapCentreAudit = Project(
    name = "UAP – Centre Audit",
    description = """
        In-house Android app to audit assessment centers, evaluate infrastructure, and verify standards for examinations.
        """.trimIndent(),
    tags = listOf(
        TechTags.AUDIT,
        TechTags.INHOUSE
    ),
    company = CompanyTags.NAVRITI
)

val fmsFacilitatorMonitoring = Project(
    name = "FMA – Facilitator Monitoring",
    description = """
        Tracks facilitators and assessment stages with geo-tagged photos, forms, and status updates for scheduled batches.
        """.trimIndent(),
    tags = listOf(
        TechTags.TRACKING,
        TechTags.GEO
    ),
    company = CompanyTags.NAVRITI
)

val amaFacilitatorMonitoring = Project(
    name = "AMA – Assessor Monitoring",
    description = """
        Assessor app to view scheduled assessments, locations, and manage reimbursements.
        """.trimIndent(),
    tags = listOf(
        TechTags.LOGISTICS,
        TechTags.REIMBURSEMENTS
    ),
    company = CompanyTags.NAVRITI
)

val pramaanJobs = Project(
    name = "PRAMAAN JOBS",
    description = """
        Job opportunities, job-fair info, training programs, tutorials, and counseling for candidates.
        """.trimIndent(),
    tags = listOf(
        TechTags.CAREERS,
        TechTags.JOBS
    ),
    company = CompanyTags.NAVRITI
)

val digitalSportsStopWatch = Project(
    name = "Digital Sports Stopwatch",
    description = """
        Sports stopwatch with fast/slow lap, start/stop, and millisecond precision.
        """.trimIndent(),
    tags = listOf(
        TechTags.UTILITY
    ),
    company = CompanyTags.HOBBY
)



