import java.util.*;

public class NumberBaseballGame {
    public static void main(String[] args) {
        // 사용자가 입력하는 숫자 입력
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 정답 랜덤숫자 받기 (SET ->(집합이기 때문에 중복을 걸로줌))
        Set<Integer> computerNumbers = new HashSet<>(); //SET 집합 생성
        while (computerNumbers.size() < 3) { //0.1.2 크기 3개
            computerNumbers.add(random.nextInt(10));
        }

        //( 정답 숫자 SET을 -> 리스트로 변환 -> 문자열로 변환)
        List<Integer> comNumbersList = new ArrayList<>(computerNumbers); //랜덤숫자 SET -> 리스트로 변환
        String comString = ""; // 빈 문자열 문자열 + 뭐 -> 문자열로 변함
        for (int num : comNumbersList) { //[6, 7, 9]
            comString += num; //문자열로 자동 형변환
        }
        System.out.println("String으로 변환된  랜덤숫자 = " + comString);


        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        System.out.println(comString); //정답

        int attempts = 1; //시도 횟수 -> 초기값 1

        while (true) {
            //사용자 입력 받기
            String input = scanner.nextLine();
            System.out.println(attempts + "번째 시도 : " + input);

            //검증로직 (맞출때까지 반복해야 하니)
            if (input.equals(comString)) { //3개 한번에 맞추기
                System.out.println("3S");
                break;

            } else { //못맞춘경우
                System.out.println("틀렸습니다, 다시 시도해보세요");
            }
            attempts++;
            //아래 로직이 추가되어야함
            //숫자의 값과 위치가 모두 일치하면 S (1개 맞추면 1S) -> 3개 맞추면 정답 종료
            //숫자의 값은 일치하지만 위치가 틀렸으면 B
        }


        // 종료 알림
        System.out.println(attempts + "번만에 맞추셨습니다.");
        System.out.println("게임을 종료합니다.");

//          우리의 예상 해결방법
//        1. 배열로 입력받아 비교 (배열대 배열비교) / 문제점: 배열중 일부분만 똑같을때 (볼일경우를 어떻게 해결할 것인지), SET은 집합이라 순서가 없다 -> 볼을 확인할수가 없다. (X)
//        2. 배열을 int로빼서 비교
//        3. 문자로 뺴서 문자끼리 비교 (O) / SET을 -> 문자로


        //SET 메서드 중 -> 특정 숫자가 존재하는지 확인하는 메서드 contains() -> 볼을 확인

    }
}
