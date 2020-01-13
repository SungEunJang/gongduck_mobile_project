# gongduck_mobile_project
공덕오거리 공모전 모바일 프로젝트

# Error

## JSON
* JSONObject {}와 JSONArray []를 잘 구분하자!

## ClearText
* Android 9 (Pie) 버전부터는 http에 대한 보안 강화로 ClearText를 막아두었다.
```xml
<manifest>
	<application
		android:usesCleartextTraffic="true">
</manifest>
```

