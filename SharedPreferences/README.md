# SharedPreferences
app 폴더 내에 저장되는 데이터 ( 간단한 설정 값이나 문자열 데이터 - DB에 저장하지 않는 데이터 )

PreferenceManager.java를 붙여넣기한 뒤, 활용하면 된다.

#### 파일의 위치
```
data/data/(package_name)/shared_prefs/SharedPreference
```


#### 받아오기  ( context, key값 )
```
String activity = PreferenceManager.getString(this, "activity");
```

#### 지정하기 ( context, key값, key가 없을 때 default값 )
```
PreferenceManager.setBoolean(this, "isLogin", true);
```



### 참조

https://re-build.tistory.com/37
