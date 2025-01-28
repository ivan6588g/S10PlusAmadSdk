package com.s10plus.coreSdk.exceptions

import com.s10plus.coreSdk.network.Errors

class ExceptionBaseResponse : Exception {
    var error: Errors = Errors()

    constructor() : super()
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)

    constructor(error: Errors) {
        this.error = error
    }
}