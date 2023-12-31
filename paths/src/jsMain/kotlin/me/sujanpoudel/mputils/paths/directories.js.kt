package me.sujanpoudel.mputils.paths

import me.sujanpoudel.mputils.platformIdentifier.Platform
import me.sujanpoudel.mputils.platformIdentifier.platform

private val platform = platform() as Platform.JS

actual fun dataDirectory(appId: String) = when (platform) {
  is Platform.JS.Node -> desktopAppHomeDirectory(
    appId = appId,
    os = platform.os,
    getEnv = { eval("""process.env["$it"]""") as String },
  )

  else -> error("Non node environment")
}

actual fun cacheDirectory(appId: String) = when (platform) {
  is Platform.JS.Node -> desktopCacheDirectory(
    appId = appId,
    os = platform.os,
    getEnv = {
      eval("""process.env["$it"]""") as String
    },
  )

  else -> error("Non node environment")
}
