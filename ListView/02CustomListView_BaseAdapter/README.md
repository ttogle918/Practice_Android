사용자 목록을 ListView로 보여주는 앱

* activity_main.xml, MainActivity.java, ListViewItem.java, ListViewAdapter.java 보기
* adapter에 만들어 놓은 addItem() 함수를 직접 사용하여 데이터 추가

-------
### 순서
1. activity_main.xml에 ListView 생성
2. ListView item에 대한 layout 구성  ->  /res/layout/listview_item.xml
3. item에 대한 클래스 정의 ( 한 list에 들어갈 여러 item )   -> /java/.../ListViewItem.java
4. Adapter class 상속 및 구현 ( 보통 ArrayAdapter이나 BaseAdapter 사용 )
5. Adapter 생성 후 ListView에 지정 ( 일반적으로는 db나 xml파일에서 listview의 파일을 load하지만, 여기서는 정적파일로 대체)
6. ListView 각각을 선택할 수 있도록(클릭) 리스너 설정


------
참조 : https://recipes4dev.tistory.com/43?category=605791
