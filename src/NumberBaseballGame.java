import java.util.*;

public class NumberBaseballGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Set<Integer> computerNumbers = new HashSet<>();
        while (computerNumbers.size() < 3) {
            computerNumbers.add(random.nextInt(10));
        }

        List<Integer> comNumbersList = new ArrayList<>(computerNumbers);
        String comString = "";
        for (int num : comNumbersList) {
            comString += num;
        }
        System.out.println("String으로 변환된  랜덤숫자 = " + comString);


        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int attempts = 1;

        while (true) {
            //사용자 입력 받기
            String input = scanner.nextLine();
            System.out.println(attempts + "번째 시도 : " + input);

            //검증로직 (맞출때까지 반복해야 하니까)
            int strike = 0;
            int ball = 0;

            // 스트라이크 검증로직
            for (int i = 0; i < input.length(); i++) {
                if (comString.charAt(i) == input.charAt(i)) {
                    strike++;
                } else if (comString.indexOf(input.charAt(i)) != -1) {
                    ball++;
                }
            }

            if (strike == 3) {
                System.out.println("3S");
                break;
            } else if (ball == 3) {
                System.out.println("3B");
            } else {
                System.out.println(ball+"B"+strike+"S");
            }
            attempts++;

        }

        // 종료 알림
        System.out.println(attempts + "번만에 맞추셨습니다.");
        System.out.println("게임을 종료합니다.");

    }
}
