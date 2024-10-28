package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.game.Cars;
import racingcar.domain.game.Game;
import racingcar.view.CarStatusDTO;
import racingcar.strategy.RandomMoveStrategy;

class CarsTest {

  // ## Happy Case

  @Test
  @DisplayName("중복되지 않은 이름으로 Cars 객체를 생성한다.")
  void createCarsWithUniqueNames() {
    // Given
    String input = "pobi, jun, car1";
    List<String> carNames = List.of(input.split(","));

    // When
    Cars cars = new Cars(carNames, new RandomMoveStrategy());

    // Then
    List<CarStatusDTO> carNameObjects = cars.getCarStatuses();
    assertEquals(carNameObjects.getFirst().name(), "pobi");
    assertEquals(carNameObjects.get(1).name(), "jun");
    assertEquals(carNameObjects.getLast().name(), "car1");
  }

  @Test
  @DisplayName("공백이 포함된 이름을 trim()하여 Cars 객체를 생성한다.")
  void createCarsWithTrimmedNames() {
    // Given
    String input = " pobi ,  jun , car2 ";
    List<String> carNames = List.of(input.split(","));

    // When
    Cars cars = new Cars(carNames, new RandomMoveStrategy());

    // Then
    List<CarStatusDTO> carNameObjects = cars.getCarStatuses();
    assertEquals(carNameObjects.getFirst().name(), "pobi");
    assertEquals(carNameObjects.get(1).name(), "jun");
    assertEquals(carNameObjects.getLast().name(), "car2");
  }

  @Test
  @DisplayName("숫자와 특수문자가 포함된 이름으로 Cars 객체를 생성한다.")
  void createCarsWithSpecialCharactersInNames() {
    // Given
    String input = "car1!, pobi@";
    List<String> carNames = List.of(input.split(","));

    // When
    Cars cars = new Cars(carNames, new RandomMoveStrategy());

    // Then
    List<CarStatusDTO> carNameObjects = cars.getCarStatuses();
    assertEquals(carNameObjects.getFirst().name(), "car1!");
    assertEquals(carNameObjects.getLast().name(), "pobi@");
  }

  // ## Bad Case

  @Test
  @DisplayName("중복된 이름이 포함된 경우 예외를 던진다.")
  void throwExceptionWhenDuplicateNames() {
    // Given
    String input = "pobi, pobi, jun";
    List<String> carNames = List.of(input.split(","));

    // When & Then
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new Cars(carNames, new RandomMoveStrategy()));
    assertEquals("Error: 중복된 자동차 이름은 허용되지 않습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("자동차 이름이 5자를 초과하면 예외를 던진다.")
  void throwExceptionWhenNameExceedsLength() {
    // Given
    String input = "pobi, longname";
    List<String> carNames = List.of(input.split(","));

    // When & Then
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new Cars(carNames, new RandomMoveStrategy()));
    assertEquals("Error: 자동차 이름은 5자 이하로 입력해야 합니다.", exception.getMessage());
  }

  @Test
  @DisplayName("빈 문자열을 이름으로 사용할 경우 예외를 던진다.")
  void throwExceptionWhenNameIsEmptyString() {
    // Given
    String input = "pobi, ";
    List<String> carNames = List.of(input.split(","));

    // When & Then
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new Cars(carNames, new RandomMoveStrategy()));
    assertEquals("Error: 자동차 이름은 비어있을 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("공백 문자열을 이름으로 사용할 경우 예외를 던진다.")
  void throwExceptionWhenNameIsWhitespace() {
    // Given
    String input = "  , pobi";
    List<String> carNames = List.of(input.split(","));

    // When & Then
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new Cars(carNames, new RandomMoveStrategy()));
    assertEquals("Error: 자동차 이름은 비어있을 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("입력값이 null일 경우 예외를 던진다.")
  void throwExceptionWhenInputIsNull() {
    // Given
    String input = null;

    // When & Then
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new Game(input, "5", new RandomMoveStrategy()));
    assertEquals("Error: 입력값은 null일 수 없습니다.", exception.getMessage());
  }

  @Test
  @DisplayName("숫자만으로 이루어진 이름이 5자를 초과할 경우 예외를 던진다.")
  void throwExceptionWhenNumericNameExceedsLength() {
    // Given
    String input = "123456, pobi";
    List<String> carNames = List.of(input.split(","));

    // When & Then
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new Cars(carNames, new RandomMoveStrategy()));
    assertEquals("Error: 자동차 이름은 5자 이하로 입력해야 합니다.", exception.getMessage());
  }
}
