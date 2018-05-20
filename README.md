# kotlin slack utils
At the moment, just a simple Kotlin DSL for creating messages to send to slack

[ ![Download](https://api.bintray.com/packages/fitzoh/maven/kotlin-slack-utils/images/download.svg) ](https://bintray.com/fitzoh/maven/kotlin-slack-utils/_latestVersion)

`compile 'com.github.fitzoh:kotlin-slack-utils:$version'`

or just copy paste [this file](https://github.com/Fitzoh/kotlin-slack-utils/blob/master/src/main/kotlin/com/github/fitzoh/slack/kotlin/Message.kt) into your project.

### usage:

```
Message.create{
  text = "hello"
  attachment{
    title = "this is"
    text = "an attachment"
  }
}
```