
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


14)클래스
class 클래스명 {
	//필드

      	//생성자
	public 클래스명(){}

	//메서드
	제어자 리턴타입 함수명 (매개변수){}

}

15) 접근 제한자 
private 같은 클래스 내
public 모두
protected 같은 패키지 내, 상속관계

16)메서드 오버로딩 
함수명 동일, 매개변수 다름

*매개변수 개수 - 인자값의 개수와 반드시 일치
*매개변수 타입- 인자값의 타입과 일치 /인자값의 타입보다 큰 타입의 매개변수면 가능

17)가변길이 인자 (208쪽)
메서드 이름( 데이터 타입 ...변수이름){}

18) 게터, 세터
private로 필드가 선언된 경우

19)클래스, 인스턴스 객체
Class Car{
}

Car bus = new Car();

bus.필드명;
bus.메서드명();

20) 인스턴스 객체의 경우, 
스택   메모리를 가리키는 주소를 갖고 있는 참조변수
힙     메모리

21)가비지 콜렉션

22)정적멤버 선언: 프로그램이 시작될 때 딱 한 번 메모리의 코드 영역에 할당, 
 	          프로그램 종료될 때까지 유지된다.
static 변수;
static 메서드;          #인스턴스 객체 없이 사용가능한 메서드

23)변수명 :소문자
    클래스명 : 대문자


24)배열 ,      리스트 
Arrays.sort  Collections.sort

리스트 출력 :::for-each로 출력

25)*try-catch-resources 
