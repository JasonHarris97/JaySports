package com.jasonharris97.jaysports.domain.core.exception

abstract class DomainException(throwable: Throwable) : Exception(throwable) {
    constructor(message: String) : this(Exception(message))
    constructor(message: String, throwable: Throwable) : this(Exception(message, throwable))
}
