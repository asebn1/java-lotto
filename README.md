# java-lotto

로또 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

<span style="background-color:#dcffe4"></span>

### 진행과정
- [ ] <span style="background-color:#fff5b1">사용자</span>는 구입금액을 입력한다.
- [ ] 프로그램은 구입 금액에 해당하는 로또를 발급한다.
- [ ] <span style="background-color:#fff5b1">사용자</span>는 지난 주 당첨 번호를 입력한다.
- [ ] <span style="background-color:#fff5b1">사용자</span>는 보너스 볼을 입력한다.
- [ ] 프로그램은 당첨 통계를 출력한다.

### 사용자입력
1. 구입금액
2. 지난 주 당첨 번호
3. 지난 주 보너스 번호

### 예외사항
1. 구입금액
    - [ ] 0 이상의 정수가 아닌 경우
    - [ ] 로또 한장의 가격으로 나누어 떨어지지 않는 경우
2. 지난 주 당첨 번호
    - [ ] ','로 구분된 6개의 수가 아닌경우
    - [ ] 1~45 사이의 수가 아닌 경우
    - [ ] 6개의 수가 중복되는 경우
3. 보너스 볼
    - [ ] 지난 주 당첨 번호와 수가 중복되는 경우

### 참고사항
1. 로또
   - 로또는 6개의 당첨번호와 1개의 보너스 볼로 구성된다.
   - 로또 번호는 1~45 사이의 정수 값이다.
2. 당첨 통계
   - 총 수익률은 당첨 금액 / 구입 금액 으로 계산하며, 소수점 둘째 자리까지 표기한다.