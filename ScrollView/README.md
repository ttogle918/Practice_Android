0부터 99까지 textView로 보여주는 앱

* activity_main.xml, MainActivity.java 보기



# Scroll Layout ( vertical - 수직 )

### 1. ScrollView 안에는 단 하나의 위젯만 넣을 수 있기 때문에 Layout(vertical-수직)을 넣고 layout 밑에 여러 위젯을 넣는 방식을 주로 사용한다.
| 이 Layout안에 스크롤되어 나타날 정보를 넣을 것!

### 2. 상단, 하단 이동하기(버튼 클릭)
+ 맨위로 갈 때 : scrollView.fullScroll(ScrollView.FOCUS_UP)
+ 맨 아래로 갈 때 : scrollView.fullScroll(ScrollView.FOCUS_DOWN)

### 3. 맨 아래에 버튼 고정하였다. ScrollView 바깥에 둘 것!


### 4. 비슷하게 수평으로 넘기는 HorizontalScrollView ( Horizontal - 수평 )이 있다.
