# Open API 사용 - 공공 데이터 xml 파싱, DOM - DocumentBuilderFactory 이용
OpenAPIDistinct.java 위주로 보면 된다.

./layout/activity_main.xml, ./layout/listview_item.xml, ./layout/listview_header.xml, MainActivity.java, ListViewItem.java, ListViewAdapter.java, OpenAPI.java, OpenAPIDistinct.java, androidManifest.xml, ./res/xml/network_config.xml

OpenAPIDistinct.java : 지역만 우선 받아오기 위한 클래스 -> 이 부분만 DOM으로 바꿨으나 url 받아오는 부분에서 error 발생

---------
### DocumentBuilderFactory, DocumentBuilder : DOM parser 형식
+ OpenAPIDistinct.java 참조 !! -> error가 있으나 적용방식은 동일
+ import javax.xml.parsers.*; 패키지
+ xml 문서를 파싱 -> 1:1로 매핑되는 object로 생성 -> 메모리에 문서 구조 그대로인 Tree 구조 ( 리턴된 Object ) 로 적재
+ 끝까지 파싱하고 객체를 생성하여 리턴하기 전까지는 다른 event 발생 불가 ( 완료될 때까지 대기 )
+ 한번 파싱하면 언제든 원하는 element 정보를 얻을 수 있다( name, text, attribute )
+ root, child, parent, sibling 노드 탐색 기능을 사용할 수 있다
+ DOM 객체를 수정하여 xml로 문서화할 수 있다. ( Generator 기능 )
+ - 문서가 커질수록 메모리를 많이 소모한다.

추천 : xml 문서 탐색이 빈번하게 발생할 경우, 문서 구조가 자주 변경되는 경우

### 순서

1. 활용 신청  ( https://www.data.go.kr/ )
2. 인증키 복사
3. 문서 확인
4. 웹에서 테스트 -> 2~3시간 뒤에 사용 가능
5. network_config.xml 생성 및 작성
6. androidManifest.xml 에 인터넷 접근 권한 추가
```
<manifest xmlns:android=...>
    ...
    <uses-permission android:name="android.permission.INTERNET" />
</manifest>
```
7. app/build.gradle 에 jsoup 의존성 추가(설치)
```
dependencies {
    ...
    implementation 'org.jsoup:jsoup:1.11.3'
    ...
}
```
8. OpenAPIDistinct.java 작성 - 로그로 데이터가 받아와지는지 확인해보자.
...

-----

https://zena1010.tistory.com/80