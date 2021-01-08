# Fragment - 화면 일부 바꾸기

첫화면은 fragment A, fragment C가 나온다.
버튼을 누르면 fragmentC -> fragmentB로 바뀜 ( A는 그대로 )
버튼을 다시 누르면 fragmentB -> fragmentC로 바뀜 ( A는 그대로 )

activity_main.xml, fragment_a.xml, fragment_b.xml, fragment_c.xml, MainActivity.java, FragmentA.java, FragmentB.java, FragmentC.java 보기

---------
### Fragment
+ Activity 내에서 생성되어 UI 구성을 모듈 단위로 작성할 수 있게 한다.
+ 여러 Activity에서 재사용될 수 있다.(모듈과 비슷하다.)
+ 디바이스의 크기에 따라 UI 구성을 다르게 할 수 있다
+ 두가지 방식으로 Fragment를 적용시킬 수 있다.
    + xml(layout)을 이용하는 방식 : 정적일 경우 - 첫 화면이거나 화면에서의 동적 변화가 없는 경우
    + java 파일에서 FragmentManager를 사용하는 경우 - 앱 실행 중 동적으로 Fragment를 추가하거나 수정할 경우


### 순서

1. activity_main.xml에 fragment(최초 출력될 fragment) 추가 - "you must fist create one or more fragments in code"란 오류 메세지가 뜰 수도 있다. design이 아닌 text로 추가하자.
2. 1번에서 fragment의 속성 중 "android:name"에 출력할 Fragment 클래스(java, Fragment 클래스 상속 받은 사용자 클래스)를 지정.
3. fragment_a.xml, fragment_b.xml에 layout 작성
4. 각 Fragment class 구현  -   ../java/../Fragment/FragmentA.java, FragmentB.java, FragmentC.java
5. Activity의 onCreate()에서 Freagment 초기화 - FragmentTransaction의 add()
6. FragmentTrasaction을 사용하여 Fragment 제어 - FragmentTrasaction의 replace()