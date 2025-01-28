package com.s10plus.coreSdk.utils

fun getArrayPermission(): List<PermissionModel>{
   return  arrayListOf(
        PermissionModel(
            permission = "android.permission.READ_PHONE_STATE",
            maxSDKVersion = Int.MAX_VALUE,
            minSDKVersion = 28,
            rational = ""
        ),
       PermissionModel(
            permission = "android.permission.ANSWER_PHONE_CALLS",
            maxSDKVersion = Int.MAX_VALUE,
            minSDKVersion = 28,
            rational = ""
        ),
        PermissionModel(
            permission = "android.permission.CALL_PHONE",
            maxSDKVersion = Int.MAX_VALUE,
            minSDKVersion = 28,
            rational = ""
        ),
        PermissionModel(
            permission = "android.permission.READ_CALL_LOG",
            maxSDKVersion = Int.MAX_VALUE,
            minSDKVersion = 28,
            rational = ""
        ),
       PermissionModel(
           permission = "android.permission.ACCESS_COARSE_LOCATION",
           maxSDKVersion = Int.MAX_VALUE,
           minSDKVersion = 28,
           rational = ""
       ),
       PermissionModel(
           permission = "android.permission.ACCESS_FINE_LOCATION",
           maxSDKVersion = Int.MAX_VALUE,
           minSDKVersion = 28,
           rational = ""
       ),
       PermissionModel(
           permission = "android.permission.POST_NOTIFICATIONS",
           maxSDKVersion = Int.MAX_VALUE,
           minSDKVersion = 28,
           rational = ""
       )
    )
}