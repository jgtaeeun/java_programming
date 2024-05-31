자바 기본 개념

1)char ' '
  String " "
  float f
  double

2)  / 몫
   % 나머지

3) 전위 ++a  증가 후 대입
    후위 a++  대입 후 증가

4)비교연산자 > < == !=

5) 논리 연산자 &&   ||

6)부정 연산자 !

7)비트 연산자 8비트
가장 왼쪽은 부호 비트(양수 0 음수 1)

8) 비트 연산
AND &
OR |
XOR  ^
부정 ~
비트이동 <<왼쪽으로 이동,  >>오른쪽으로 이동

9)삼항 연산자
변수=조건 ? 참일 때 : 거짓일 때 ;

***10)타입 변경  Integer.parseInt(string s)  Integer.toString(int n)
String strNum1 = new String("1234");
int num1 = Integer.parseInt(strNum1);

int x = -5;
String xText = Integer.toString(x);
System.out.println("convert int to String: " + xText);


11) 조건문
if (조건 ) {;}
else if (조건 ) {;}
else {;}

switch(변수) {
	case 1 : break;
	default : break;
}

12)반복문 
for (int i = 0 ; i < ; i++){
}



초기값 선언;
while(조건식){
	실행문;
	증감식;
}

13)배열
int a [] = new int [5];
int a [] = { 1,2,3,};

a.length;
