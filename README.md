# Drawer layout

+ 기본적으로 swipe 동작에 의해 열린다
    + Drawer을 열 때 : edge swipe
    + Drawer을 닫을 때 : drawer swipe, click main area 두가지 방법

+ 코드를 통해 Drawer을 여닫을 수 있다.
    + Drawer을 열 때 : openDrawer(..) - animation과 gravity를 설정할 수 있다.
    + Drawer을 닫을 때 : closeDrawer(..) - animation과 gravity를 설정할 수 있다.

+ swipe 동작으로 인해 Drawer가 여닫히는 것을 방지하기 위해 잠글 수 있다.
    + setDrawerLockMode(..)을 통해 값 지정
        + LOCK_MODE_UNLOCKED : lock기능 비활성화.
        + LOCK_MODE_LOCKED_CLOSED : Drawer가 닫힌 채로 잠김. Drawer가 열려 있었다면 자동으로 닫힘
        + LOCK_MODE_LOCKED_OPEN : Drawer가 열린 채로 잠김. Drawer가 닫혀 있었다면 자동으로 열림
    + 위의 함수를 적용할 경우 swipe에 의해 여닫는 것은 불가능하지만, openDrawer()이나 closeDrawer() 함수에 의한 여닫기는 가능하다.

+ DrawerLayout에 같은 방향(gravity)의 Drawer이 있을 경우 에러 발생

---------
참조 : https://recipes4dev.tistory.com/139