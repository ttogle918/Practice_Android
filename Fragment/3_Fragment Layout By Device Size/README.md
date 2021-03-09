# Fragment - Title/Detail

Title Listview와 Title을 클릭하면 Detail을 볼 수 있는 앱
7인치 이상 크기 가로모드에서는 왼쪽 title, 오른쪽 detail을 볼 수 있다.( 기기 size에 따라 layout 다르게 하기 )

./layout/activity_main.xml, ./layout-land/activity_main.xml, details_fragment.xml, MainActivity.java, TitleFragment.java, DetailFragment.java, DetailActivity.java, androidManifest.xml 보기

---------
### ListFragment
+ ListView의 Wrapper(포장) 클래스 역할을 하는 Fragment


### 순서

1. activity_main.xml에 ListFragment(최초 출력될 fragment) 추가
2. 7인치 이상 가로모드를 위한 layout xml 정의 - /layout-land/activity_main.xml
3. detail fragment layout 구성
4. Fragment 상속 및 구현 - TitleFragment.java, DetailFragment.java
5. Detail Activity class 구현 DetailActivity.java
6. Fragment initialize
7. event 구현
8. AndroidManifest.xml에 <activity android:name=".DetailActivity"/> 추가