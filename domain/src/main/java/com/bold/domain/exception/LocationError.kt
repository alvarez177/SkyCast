package com.bold.domain.exception

sealed class LocationError : Throwable() {
    object NetworkError : LocationError()
    object EmptyResult : LocationError()
    object InvalidResponse : LocationError()
}