# gongduck_mobile_project
공덕오거리 공모전 모바일 프로젝트

# Error

## JSON
* JSONObject {}와 JSONArray []를 잘 구분하자!

## ClearText
* Android 9 (Pie) 버전부터는 http에 대한 보안 강화로 ClearText를 막아두었다. (https 위주 이용 가능)
* HttpURLConnection 으로 json 형태로 데이터를 받아오기 때문에 clear text가 필요하다.

```xml
# AndroidManifest.xml에 아래와 같이 추가해서 clear text를 이용할 수 있도록 한다.
<manifest>
	<application
		android:usesCleartextTraffic="true">
</manifest>
```

## DrawerLayout

```java
import androidx.drawerlayout.widget.DrawerLayout;
````

### build.gradle 설정 필요 (순서 중요!!)

1. app 수준의 build.gradle에 추가 및 Sync
```gradle
dependencies {
	implementation "androidx.navigation:navigation-fragment:2.1.0"
	implementation "androidx.navigation:navigation-ui:2.1.0"
}
```
2. project 수준의 build.gradle에 추가 및 Sync
```gradle
buildscript {
	dependencies {
		classpath "android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha09"
	}
}
```
3. app 수준의 build.gradle 가장 아래에 추가 및 Sync
```gradle

apply plugin: "androidx.navigation.safeargs"
```
