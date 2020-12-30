# ListView - ArrayAdaper 사용
사용자 목록을 ListView로 보여주고, 버튼 클릭시 선택여부를 알려줌

* activity_main.xml, MainActivity.java, ListViewItem.java, ListViewAdapter.java 보기
* method 내에서 item list 구성
* ArrayAdapter 사용

-------
### 순서
1. activity_main.xml에 ListView 생성
2. ListView item에 대한 layout 구성  ->  /res/layout/listview_item.xml
3. item에 대한 클래스 정의 ( 한 list에 들어갈 여러 item )   -> /java/.../ListViewBtnItem.java
4. Adapter class 상속 및 구현 ( 보통 ArrayAdapter이나 BaseAdapter 사용, 여기서는 ArrayAdapter 사용 )
5. 사용자 데이터 로드 - MainActivity.java의 loadItemsFromDB() : 실제 DB 사용은 아니다.
6. Adapter 생성 후 ListView에 지정
7. ListView 각각을 선택할 수 있도록(클릭, 버튼) 리스너 설정 및 처리


------
참조 : https://recipes4dev.tistory.com/45?category=605791

