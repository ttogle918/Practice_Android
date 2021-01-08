# ListView - Filtering

ListView의 속성 중 textFilterEnabled 속성을 true로 지정하여 필터링 기능 활성화
ListView의 setFilterText()함수를 호출하여 문자열 전달(필터링 대상, 대소문자 구분 x)

* 문자열의 맨 처음만 검색 가능( a를 검색할 때, Adam Smith, Bryan Adams, Daniel Craig 중에서 Daniel Craig는 검색되지 않는다.

* activity_main.xml, listview_item1.xml, MainActivity.java, ListVewAdapter.java, ListViewItem.java 보기


### 커스텀 Filter 클래스 정의
Filter 클래스 상속, protected로 정의된 performFiltering(), publishResults() 오버라이드

+ performFiltering() 에서 필터링 수행
+ publishResults() 에서 필터링된 결과를 UI에 갱신시킴