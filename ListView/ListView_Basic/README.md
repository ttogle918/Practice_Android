0부터 99까지 textView로 보여주는 앱

* activity_main.xml, MainActivity.java 보기



# List View
안드로이드에서 UI화면은 View와 ViewGroup을 사용하여 구성된다.
+ View : TextView, Button, CheckBox 등 기본 객체
+ ViewGroup : Layout, ListView 등 View( 혹은 View Group )들이 모인 Group


ListView 또한 ViewGroup에 속한다.
-> 데이터를 화면에 표시하기 위해 View 객체가 ListView에 추가되어야한다.

### 1. Adapter를 사용하여 사용자가 정의한 데이터를 ListView와 연결해줄 수 있다.
Adapter은 데이터를 입력받아 View를 생성하는 일을 한다.

### 2. 기본 ListView
안드로이드에서 기본으로 제공하는 ListView는 TextView만을 포함한다.
-> 다양한 컴포넌트들로 구성된 ListView를 만들어보자! : Custom ListView에서 계속

### 3. Activity에 ListView를 추가하는 것이 기본 방법

#### Fragment에서 ListView를 추가하면 에러가 발생한다.

    Activity가 android.content.Context로부터 상속받은 클래스인것에 반해 Fragment는 java.lang.Object로부터 직접 상속받은 클래스이기 때문에 Context와 전혀 관계가 없는 상태이다.
    첫번째 파라미터로 this를 쓸 수가 없다.
    -> Fragment는 this 대신에 자신이 속한 Activity의 reference를 얻어온 다음 생성자로 전달하면 가능하다.( getActivity() )
    findViewById() 함수는 View의 멤버 함수이다. Fragment의 멤버함수가 아니다.
    -> LayoutInflater을 사용하여 Resource Layout을 View로 변환한 다음 해당 View를 사용하여 findViewById()를 호출할 수 있다.


```java
    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment1, null) ;

            ArrayAdapter Adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, LIST_MENU) ;

            ListView listview = (ListView) view.findViewById(R.id.listview) ;
            listview.setAdapter(adapter) ;

            return view ;
        }
```


-------
### 순서
1. xml에 ListView 생성
2. 문자열만 표시할 것이기 때문에 배열 선언( LIST_MENU )
3. Adapter( 문자열이기 때문에 ArrayAdapter 사용 ) 생성후 ListView에 지정
4. ListView의 Menu 각각을 선택할 수 있도록(클릭) 만들어 메뉴처럼 사용하기 위해 리스너 설정

* parent.getItemAtPosition(position) : 해당 TextView의 text 가져오기