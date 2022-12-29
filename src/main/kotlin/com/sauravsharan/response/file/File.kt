package com.sauravsharan.response.file

data class File(
    /**
     * The unique id of this file.
     */
    var id: String? = null,

    /**
     * The type of object returned, should be "file".
     */
    var `object`: String? = null,

    /**
     * File size in bytes.
     */
    var bytes: Long? = null,

    /**
     * The creation time in epoch seconds.
     */
    var createdAt: Long? = null,

    /**
     * The name of the file.
     */
    var filename: String? = null,

    /**
     * Description of the file's purpose.
     */
    var purpose: String? = null
)
