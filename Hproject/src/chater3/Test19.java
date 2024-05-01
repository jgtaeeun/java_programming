/**
 * 
 */
package chater3;

/**
 * 
 */
public class Test19 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//점수 초기값 입력
		int score=40;
		
		//결과 문자열 초기화
		String result=" ";
		
		//점수가 60점이상인지 비교
		if (score>=60) {
			//60점이상이면 합격문자열을 결과 변수에 저장
			result = "합격";
		}
		else {
			result="불합격";
		}
		
		
		//결과문자열을 화면에 출력
		System.out.println(result);

	}

}
