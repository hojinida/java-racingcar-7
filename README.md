# java-racingcar-precourse

# 📖 기능 명세서

## 🥇 1주차 미션 목표
1. **이름을 통해 의도를 드러내는 네이밍**
    - 축약하지 않고, 역할이 명확히 드러나는 변수 및 메서드 이름을 사용한다.

2. **Java API 적극 활용**
    - 배열 대신 Collection을 활용하여 코드의 가독성과 유지보수를 높인다.

---

# 📌 구현할 기능 목록

### 1. **입력 안내 메시지 출력 기능**
- 자동차 이름과 시도 횟수를 입력받기 전, 안내 메시지를 출력한다.

### 2. **자동차 이름 입력 기능**
- 사용자로부터 쉼표(,)로 구분된 자동차 이름을 입력받는다.
- 각 이름의 길이가 5자 이하인지 검증한 후, 자동차 객체를 생성한다.

### 3. **시도 횟수 입력 기능**
- 사용자에게 시도할 횟수를 입력받고, 1 이상의 정수인지 검증한다.

### 4. **자동차 이동 조건 결정 기능**
- 0에서 9까지의 무작위 값을 생성하고, 4 이상일 경우 해당 자동차를 한 칸 전진시킨다.

### 5. **자동차 이동 기능**
- 이동 조건에 따라 자동차의 위치를 전진시킨다.

### 6. **경기 진행 기능**
- 입력된 시도 횟수만큼 라운드를 반복하며 모든 자동차의 현재 위치를 출력한다.

### 7. **실행 결과 출력 기능**
- 경기 종료 후, 모든 자동차의 최종 위치와 우승자를 출력한다.

---

## 📌 자동차 이름 입력 기능 - 예외 상황 목록

1. **공백 처리 방식**
    - 각 자동차 이름을 **쉼표(,)**로 구분한 후, **앞뒤 공백(trim)**만 제거한다.
        - 예: `" pobi "` → `"pobi"`
    - **자동차 이름에 포함된 중간 공백**은 그대로 허용한다.
        - 예: `"po bi"` → 자동차 이름: `"po bi"`

2. **잘못된 구분자 처리**
    - 쉼표(,)가 아닌 다른 구분자는 **자동차 이름의 일부로 인식**한다.
        - 예: `"po!"` → 자동차 이름: `"po!"`

3. **이름의 길이 제약**
    - 자동차 이름의 길이가 **1자 이상 5자 이하**가 아니면 **예외 발생**.
        - 예외 메시지: `Error: 자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.`

4. **숫자 포함 허용**
    - 자동차 이름에 **숫자가 포함**될 수 있다.
        - 예: `"car1", "123"`

5. **특수문자 허용**
    - 자동차 이름에 **특수문자**가 포함될 수 있다.
        - 예: `"@car", "c@r!"`

6. **중복 이름 예외**
    - **중복된 자동차 이름**이 입력될 경우 예외 발생.
        - 예외 메시지: `Error: 중복된 자동차 이름은 허용되지 않습니다.`

---

## 📌 시도 횟수 입력 기능 - 예외 상황 목록

1. **정수가 아닌 값 예외**
    - 입력된 값이 **정수로 변환할 수 없는 경우** 예외 발생.
        - 예외 메시지:  
          `Error: 시도 횟수는 정수로 입력해야 합니다.`

2. **1 미만의 정수 예외**
    - 입력된 값이 **1보다 작은 경우** 예외 발생.
        - 예외 메시지:  
          `Error: 시도 횟수는 1 이상의 값으로 입력해야 합니다.`

3. **정수 범위 초과 예외**
    - 입력된 값이 **int형의 최대값(2,147,483,647)**을 초과하면 예외 발생.
        - 예외 메시지:  
          `Error: 시도 횟수는 2,147,483,647 이하의 정수로 입력해야 합니다.`

---

## 📌 자동차 이동 조건 결정 기능 - 예외 상황 목록

1. **무작위 값 범위 예외**
    - 무작위로 생성된 값이 **0~9의 범위를 벗어난 경우** 예외 발생.
        - 예외 메시지:  
          `Error: 무작위 값은 0에서 9 사이여야 합니다.`

---

## 📌 경기 진행 기능 - 예외 상황 목록

1. **자동차 목록이 비어 있는 경우**
    - 자동차 이름이 입력되지 않아 객체가 **하나도 생성되지 않은 경우** 예외 발생.
        - 예외 메시지:  
          `Error: 경기를 진행하려면 최소한 한 대의 자동차가 필요합니다.`

---


# 📖 기능별 테스트 코드 명세

## 1. **입력 안내 메시지 출력 기능**
- ### 테스트 항목:
   1. **안내 메시지 출력 테스트**
      - **목표**: 올바른 안내 메시지가 출력되는지 확인한다.
      - **테스트 내용**:
         - "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
         - "시도할 횟수는 몇 회인가요?"

---

## 2. **자동차 이름 입력 기능**

### **Happy Case**
1. **정상적인 자동차 이름 입력**
   - 입력: `"pobi,woni,jun"`
   - 기대 결과:
      - 자동차 이름 리스트: `["pobi", "woni", "jun"]`

2. **자동차 이름에 공백이 포함된 경우**
   - 입력: `" pobi , woni , jun "`
   - 기대 결과:
      - 자동차 이름 리스트: `["pobi", "woni", "jun"]`

3. **숫자와 특수문자가 포함된 경우**
   - 입력: `"car1,!jun,@woni"`
   - 기대 결과:
      - 자동차 이름 리스트: `["car1", "!jun", "@woni"]`

4. **이름 길이가 정확히 5자인 경우**
   - 입력: `"abcde,12345,!!!!!"`
   - 기대 결과:
      - 자동차 이름 리스트: `["abcde", "12345", "!!!!!"]`

---

### **Bad Case**
1. **자동차 이름의 길이가 5자를 초과하는 경우**
   - 입력: `"longname,woni,jun"`
   - 기대 결과:
      - 예외 발생: `Error: 자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.`

2. **자동차 이름이 중복된 경우**
   - 입력: `"pobi,pobi,jun"`
   - 기대 결과:
      - 예외 발생: `Error: 중복된 자동차 이름은 허용되지 않습니다.`

3. **구분자를 잘못 사용하고 이름 길이 초과**
   - 입력: `"pobi/woni/junnnnn"`
   - 기대 결과:
      - 예외 발생: `Error: 자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.`

4. **빈 문자열 입력**
   - 입력: `""`
   - 기대 결과:
      - 예외 발생: `Error: 자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.`

5. **공백 문자열 입력**
   - 입력: `"  "`
   - 기대 결과:
      - 예외 발생: `Error: 자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.`

6. **`null` 입력**
   - 입력: `null`
   - 기대 결과:
      - 예외 발생: `Error: 입력값이 null일 수 없습니다.`

7. **숫자만으로 이루어진 이름의 길이가 초과된 경우**
   - 입력: `"123456,woni,jun"`
   - 기대 결과:
      - 예외 발생: `Error: 자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.`

---

## 3. **시도 횟수 입력 기능**

### **Happy Case**
1. **정상적인 1자리 숫자 입력**
    - 입력: `"3"`
    - 기대 결과:
        - 시도 횟수: `3`

2. **정상적인 2자리 숫자 입력**
    - 입력: `"35"`
    - 기대 결과:
        - 시도 횟수: `35`

3. **정상적인 큰 숫자 입력 (int 범위 내)**
    - 입력: `"2147483647"`
    - 기대 결과:
        - 시도 횟수: `2147483647`

---

### **Bad Case**
1. **`null` 입력**
    - 입력: `null`
    - 기대 결과:
        - 예외 발생: `Error: 입력값이 null일 수 없습니다.`

2. **문자 입력**
    - 입력: `"a"`
    - 기대 결과:
        - 예외 발생: `Error: 시도 횟수는 숫자여야 합니다.`

3. **문자와 숫자가 혼합된 경우**
    - 입력: `"a3"`
    - 기대 결과:
        - 예외 발생: `Error: 시도 횟수는 숫자여야 합니다.`

4. **여러 글자가 포함된 문자 입력**
    - 입력: `"adad"`
    - 기대 결과:
        - 예외 발생: `Error: 시도 횟수는 숫자여야 합니다.`

5. **숫자와 특수문자가 혼합된 경우**
    - 입력: `"1!"`
    - 기대 결과:
        - 예외 발생: `Error: 시도 횟수는 숫자여야 합니다.`

6. **`int` 범위를 초과하는 숫자 입력**
    - 입력: `"2147483648"`
    - 기대 결과:
        - 예외 발생: `Error: 시도 횟수는 2,147,483,647 이하의 정수여야 합니다.`

7. **0 이하의 숫자 입력**
    - 입력: `"0"`
    - 기대 결과:
        - 예외 발생: `Error: 시도 횟수는 1 이상의 값이어야 합니다.`

8. **음수 입력**
    - 입력: `"-1"`
    - 기대 결과:
        - 예외 발생: `Error: 시도 횟수는 1 이상의 값이어야 합니다.`

---

## 4. **자동차 이동 조건 결정 기능**

### **Happy Case**
1. **랜덤 값이 4 이상인 경우**
    - **Stub 값**: 4, 5, 6, 7, 8, 9
    - 기대 결과:
        - 이동 조건이 충족된다.

2. **랜덤 값이 3 이하인 경우**
    - **Stub 값**: 0, 1, 2, 3
    - 기대 결과:
        - 이동 조건이 충족되지 않는다.

---

### **Bad Case**
1. **랜덤 값이 0~9 범위를 벗어난 경우**
    - **Stub 값**: -1, 10
    - 기대 결과:
        - 예외 발생: `Error: 무작위 값은 0에서 9 사이여야 합니다.`

---

## 5. **자동차 이동 기능**

### **Happy Case**
1. **전진 조건을 충족하는 경우**
    - **Stub 값**: 5 (전진 조건 충족)
    - 초기 위치: 0
    - 기대 결과:
        - 자동차의 위치가 **1**로 변경된다.

2. **전진 조건을 충족하지 않는 경우**
    - **Stub 값**: 2 (전진 조건 미충족)
    - 초기 위치: 3
    - 기대 결과:
        - 자동차의 위치가 **3**으로 유지된다.

---

### **테스트 예시**
1. **입력 조건**:
    - Stub 값: 4 (전진 조건 충족)
    - 초기 위치: 2
    - **기대 결과**: 위치가 3으로 변경된다.

2. **입력 조건**:
    - Stub 값: 1 (전진 조건 미충족)
    - 초기 위치: 5
    - **기대 결과**: 위치가 5로 유지된다.

---
