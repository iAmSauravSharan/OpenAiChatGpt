package com.sauravsharan.response.fine_tune

data class FineTuneEvent (
    /**
     * The type of object returned, should be "fine-tune-event".
     */
    var `object`: String? = null,

    /**
     * The creation time in epoch seconds.
     */
    var createdAt: Long? = null,

    /**
     * The log level of this message.
     */
    var level: String? = null,

    /**
     * The event message.
     */
    var message: String? = null
)
