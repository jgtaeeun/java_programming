/**
 * 
 */
package chater3;

/**
 * 
 */
public class Test19_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//점수 초기값 입력
		float score = 60.0f;
		//결과 문자열 초기화
		String result = "";
		
		
		//점수가 60점이상인지 비교
		if (score > 70.0) {
			result = "pass";
		}else {
			result="fail";
		}
		
		//결과문자열을 화면에 출력
		System.out.println(result);
		System.out.println(score>70.0 ? "pass" : "fail");

	}

}
