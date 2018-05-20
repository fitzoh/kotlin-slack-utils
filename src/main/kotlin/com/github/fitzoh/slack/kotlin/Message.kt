package com.github.fitzoh.slack.kotlin

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Message(
        var text: String? = null,
        var markdown: Boolean? = null,
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        val attachments: MutableList<Attachment> = mutableListOf()) {

    fun attachment(init: Attachment.() -> Unit) = attachments.add(Attachment().apply(init))

    companion object {
        fun create(init: Message.() -> Unit) = Message().apply(init)
    }


    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    data class Attachment(
            var title: String? = null,
            var pretext: String? = null,
            var text: String? = null,
            var fallback: String? = null,
            var color: String? = null,
            var authorName: String? = null,
            var authorLink: String? = null,
            var authorIcon: String? = null,
            var titleLink: String? = null,
            var imageUrl: String? = null,
            var thumbUrl: String? = null,
            var footer: String? = null,
            var footerIcon: String? = null,
            var ts: Long? = null,
            @JsonInclude(JsonInclude.Include.NON_EMPTY)
            var fields: MutableList<Field> = mutableListOf()) {

        fun field(init: Field.() -> Unit) = fields.add(Field().apply(init))
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    data class Field(
            var title: String? = null,
            var value: String? = null,
            var short: Boolean? = null)
}

