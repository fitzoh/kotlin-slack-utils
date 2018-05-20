package com.github.fitzoh.slack.kotlin

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class MessageTest {

    val mapper = jacksonObjectMapper()

    @Test
    fun `basic example`() {
        val json = """
            {
                "text": "This is a line of text.\nAnd this is another one."
            }"""
        val message = Message.create {
            text = "This is a line of text.\nAnd this is another one."
        }

        assertThat(message).isEqualTo(mapper.readValue<Message>(json))
    }

    @Test
    fun `attachments example`() {
        val json = """
            {
                "attachments": [
                    {
                        "fallback": "Required plain-text summary of the attachment.",
                        "color": "#36a64f",
                        "pretext": "Optional text that appears above the attachment block",
                        "author_name": "Bobby Tables",
                        "author_link": "http://flickr.com/bobby/",
                        "author_icon": "http://flickr.com/icons/bobby.jpg",
                        "title": "Slack API Documentation",
                        "title_link": "https://api.slack.com/",
                        "text": "Optional text that appears within the attachment",
                        "fields": [
                            {
                                "title": "Priority",
                                "value": "High",
                                "short": false
                            }
                        ],
                        "image_url": "http://my-website.com/path/to/image.jpg",
                        "thumb_url": "http://example.com/path/to/thumb.png",
                        "footer": "Slack API",
                        "footer_icon": "https://platform.slack-edge.com/img/default_application_icon.png",
                        "ts": 123456789
                    }
                ]
            }"""
        val message = Message.create {
            attachment {
                fallback = "Required plain-text summary of the attachment."
                color = "#36a64f"
                pretext = "Optional text that appears above the attachment block"
                authorName = "Bobby Tables"
                authorLink = "http://flickr.com/bobby/"
                authorIcon = "http://flickr.com/icons/bobby.jpg"
                title = "Slack API Documentation"
                titleLink = "https://api.slack.com/"
                text = "Optional text that appears within the attachment"
                field {
                    title = "Priority"
                    value = "High"
                    short = false
                }
                imageUrl = "http://my-website.com/path/to/image.jpg"
                thumbUrl = "http://example.com/path/to/thumb.png"
                footer = "Slack API"
                footerIcon = "https://platform.slack-edge.com/img/default_application_icon.png"
                ts = 123456789
            }
        }

        assertThat(message).isEqualTo(mapper.readValue<Message>(json))
    }

    //TODO get message buttons working and enable
    @Test
    @Ignore("https://api.slack.com/docs/message-buttons")
    fun `message buttons example`() {
        val json = """
            {
                "text": "Would you like to play a game?",
                "attachments": [
                    {
                        "text": "Choose a game to play",
                        "fallback": "You are unable to choose a game",
                        "callback_id": "wopr_game",
                        "color": "#3AA3E3",
                        "attachment_type": "default",
                        "actions": [
                            {
                                "name": "game",
                                "text": "Chess",
                                "type": "button",
                                "value": "chess"
                            },
                            {
                                "name": "game",
                                "text": "Falken's Maze",
                                "type": "button",
                                "value": "maze"
                            },
                            {
                                "name": "game",
                                "text": "Thermonuclear War",
                                "style": "danger",
                                "type": "button",
                                "value": "war",
                                "confirm": {
                                    "title": "Are you sure?",
                                    "text": "Wouldn't you prefer a good game of chess?",
                                    "ok_text": "Yes",
                                    "dismiss_text": "No"
                                }
                            }
                        ]
                    }
                ]
            }"""
        //TODO implement
        val message = Message.create {
            //            text = "Would you like to play a game?"
//            attachment {
//                text = "Choose a game to play"
//                fallback = "You are unable to choose a game"
//                callback_id
//
//            }
        }

        assertThat(message).isEqualTo(mapper.readValue<Message>(json))
    }
}
