# Fragment - ListFragment

ListView를 포함하는 Fragment class 이용하기

activity_main.xml, listview_item.xml, MainActivity.java, CustomListFragment.java, ListViewItem.java, ListViewAdapter.java 보기

---------
### ListFragment
+ ListView의 Wrapper(포장) 클래스 역할을 하는 Fragment


### 순서

1. activity_main.xml에 ListFragment(최초 출력될 fragment) 추가
2. ListFragment 상속 및 구현 - CustomListFragment.java
3. ListView item layout 구성 및 class 구현 - listview_item.xml, ListViewItem.java
4. Adapter 클래스 상속 및 구현 - ListViewAdapter.java
5. Adapter 생성 후 ListView에 지정 - ListFragment.onListItemClick()
6. 클릭 이벤트 처리 - ListFragment.onListItemClick()
7. addItem()으로 아이템 다루기
