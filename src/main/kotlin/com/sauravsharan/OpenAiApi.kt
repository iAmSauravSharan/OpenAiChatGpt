package com.sauravsharan

import com.sauravsharan.request.completion.CompletionRequest
import com.sauravsharan.request.edit.EditRequest
import com.sauravsharan.request.embeddings.EmbeddingRequest
import com.sauravsharan.request.fine_tune.FineTuneRequest
import com.sauravsharan.request.images.ImageGenerationRequest
import com.sauravsharan.request.moderation.ModerationRequest
import com.sauravsharan.response.OpenAiResponse
import com.sauravsharan.response.completion.CompletionResponse
import com.sauravsharan.response.edit.EditResponse
import com.sauravsharan.response.embeddings.EmbeddingResponse
import com.sauravsharan.response.file.DeleteResponse
import com.sauravsharan.response.file.File
import com.sauravsharan.response.fine_tune.FineTuneEvent
import com.sauravsharan.response.fine_tune.FineTuneResponse
import com.sauravsharan.response.images.ImageResponse
import com.sauravsharan.response.model.Model
import com.sauravsharan.response.moderation.ModerationResponse
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*


interface OpenAiApi {

    @GET("models")
    fun listModels(): Single<OpenAiResponse<Model>>

    @GET("models/{model_id}")
    fun getModel(@Path("model_id") modelId: String): Single<Model>

    @POST("completions")
    fun createCompletion(@Body request: CompletionRequest): Single<CompletionResponse>

    @POST("edits")
    fun createEdit(@Body request: EditRequest): Single<EditResponse>

    @POST("embeddings")
    fun createEmbeddings(@Body request: EmbeddingRequest): Single<EmbeddingResponse>

    @POST("images/generations")
    fun generateImages(@Body request: ImageGenerationRequest): Single<ImageResponse>

    @Multipart
    @POST("images/edits")
    fun editImage(
        @Part image: MultipartBody.Part,
        @Part mask: MultipartBody.Part? = null,
        @Part("prompt") prompt: RequestBody
    ): Single<ImageResponse>

    @Multipart
    @POST("images/variations")
    fun generateImageVariations(
        @Part image: MultipartBody.Part
    ): Single<ImageResponse>

    @GET("files")
    fun listFiles(): Single<OpenAiResponse<File>>

    @Multipart
    @POST("files")
    fun uploadFile(@Part("purpose") purpose: RequestBody?, @Part file: MultipartBody.Part?): Single<File>

    @DELETE("files/{file_id}")
    fun deleteFile(@Path("file_id") fileId: String?): Single<DeleteResponse>

    @GET("files/{file_id}")
    fun retrieveFile(@Path("file_id") fileId: String?): Single<File>

    @POST("fine-tunes")
    fun createFineTune(@Body request: FineTuneRequest): Single<FineTuneResponse>

    @POST("completions")
    fun createFineTuneCompletion(@Body request: CompletionRequest?): Single<CompletionResponse>

    @GET("fine-tunes")
    fun listFineTunes(): Single<OpenAiResponse<FineTuneResponse>>

    @GET("fine-tunes/{fine_tune_id}")
    fun retrieveFineTune(@Path("fine_tune_id") fineTuneId: String?): Single<FineTuneResponse>

    @POST("fine-tunes/{fine_tune_id}/cancel")
    fun cancelFineTune(@Path("fine_tune_id") fineTuneId: String?): Single<FineTuneResponse>

    @GET("fine-tunes/{fine_tune_id}/events")
    fun listFineTuneEvents(@Path("fine_tune_id") fineTuneId: String?): Single<OpenAiResponse<FineTuneEvent>>

    @DELETE("models/{fine_tune_id}")
    fun deleteFineTune(@Path("fine_tune_id") fineTuneId: String?): Single<DeleteResponse>

    @POST("moderations")
    fun createModeration(@Body request: ModerationRequest): Single<ModerationResponse>

}