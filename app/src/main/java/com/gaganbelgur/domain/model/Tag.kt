package com.gaganbelgur.domain.model

sealed class Tag {
    abstract val key: String

    abstract val displayName: String
}