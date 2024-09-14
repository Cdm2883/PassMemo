package vip.cdms.passmemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
