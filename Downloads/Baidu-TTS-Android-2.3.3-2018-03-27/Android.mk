LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)


LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under,src)

LOCAL_STATIC_JAVA_LIBRARIES :=  baidu-tts android-support-v7

LOCAL_JNI_SHARED_LIBRARIES := libbd_etts libBDSpeechDecoder_V1 libbdtts libgnustl_shared


#LOCAL_SRC_FILES := $(call all-subdir-java-files) \

LOCAL_PACKAGE_NAME := bdtts
LOCAL_CERTIFICATE := platform

include $(BUILD_PACKAGE)
##################引用第三方jar包###########################
include $(CLEAR_VARS)

LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := baidu-tts:libs/com.baidu.tts_2.3.1.20170808_e39ea89.jar
include $(BUILD_MULTI_PREBUILT)
##################引用第三方os库############################
include $(CLEAR_VARS)
LOCAL_SHARED_LIBRARIES := libbd_etts
LOCAL_SHARED_LIBRARIES += libBDSpeechDecoder_V1
LOCAL_SHARED_LIBRARIES += libbdtts
LOCAL_SHARED_LIBRARIES += libgnustl_shared

LOCAL_PREBUILT_LIBS :=libbd_etts:libs/armeabi/libbd_etts.so
LOCAL_PREBUILT_LIBS +=libBDSpeechDecoder_V1:libs/armeabi/libBDSpeechDecoder_V1.so
LOCAL_PREBUILT_LIBS +=libbdtts:libs/armeabi/libbdtts.so
LOCAL_PREBUILT_LIBS +=libgnustl_shared:libs/armeabi/libgnustl_shared.so
include $(BUILD_MULTI_PREBUILT)
###########################################################
# Use the folloing include to make our test apk.
include $(call all-makefiles-under,$(LOCAL_PATH))
LOCAL_PATH:= $(call my-dir)