package com.sauravsharan.request.images

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File

data class ImageEditRequest(

    /**
     * The image to edit. Must be a valid PNG file, less than 4MB, and square.
     * If mask is not provided, image must have transparency, which will be used as the mask.
     */
    @JsonProperty("image")
    val imagePath: String,

    /**
     * An additional image whose fully transparent areas (e.g. where alpha is zero) indicate where image should be edited.
     * Must be a valid PNG file, less than 4MB, and have the same dimensions as image
     */
    @JsonProperty("mask")
    val maskPath: String? = null,

    /**
     * A text description of the desired image(s). The maximum length is 1000 characters.
     */
    val prompt: String,

    /**
     * The number of images to generate. Must be between 1 and 10.
     */
    val n: Int? = null,

    /**
     * The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024
     */
    val size: String? = null,

    /**
     * The format in which the generated images are returned. Must be one of
     * url or b64_json
     */
    @JsonProperty("response_format")
    val responseFormat: String? = null,

    /**
     * A unique identifier representing your end-user, which can help OpenAI to monitor
     * and detect abuse
     */
    var user: String? = null

)
