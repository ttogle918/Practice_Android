# ListView - 2way item

ListView에 두가지 item을 적용시키기 - 상황에 따라 다른 layout 적용시키기


* activity_main.xml, listview_item1.xml, listview_item2.xml, MainActivity.java, ListViewItem.java, ListViewAdapter 보기
* header, footer 적용
* footer에 있는 add, modify, delete는 기능 구현 x

### 순서
1. 위치 결정 - activity_main.xml에 listview 추가
2. listview_item1.xml 작성( 첫 번째 아이템 layout )
3. listview_item2.xml 작성( 두 번째 아이템 layout )
4. ListViewItem 클래스 정의
5. Adapter 클래스 정의( 상속 및 구현 )
6. Adapter 생성 후 지정
7. ListView 아이템 추가