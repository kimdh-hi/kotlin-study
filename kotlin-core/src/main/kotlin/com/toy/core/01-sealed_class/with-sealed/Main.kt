package com.toy.core.`01-sealed_class`.`with-sealed`

fun main() {
  getUserStatus(Enabled())
  getUserStatus(Disabled())
  getUserStatus(Warning())
}

/**
 * UserStatus 클래스를 sealed 클래스로 만들어 주는 것은 컴파일러에게 UserStatus의 종류를 알리는 것과 같음
 * 모든 자식클래스에 대한 처리를 강제할 수 있다.
 *
 * 단, sealed 클래스로 선언된 부모 클래스는 같은 패키지 안의 클래스만 상속받을 수 있다.
 */

// else가 없어도 컴파일 에러 xx
// UserStatus 의 자식클래스가 case에 없다면 컴파일에러 발생
fun getUserStatus(userStatus: UserStatus) = when(userStatus) {
  is Enabled -> userStatus.printStatus()
  is Disabled -> userStatus.printStatus()
  is Warning -> userStatus.printStatus()
}

/**
 * // NoWhenBranchMatchedException
 * // 컴파일 타임에 is 구문이 작성되지 않은 서브클래스에 대해 검증되므로 런타임에 발생되지 않겠지만 java 코드로 컴파일시 예외처리 들어가 있는 것 확인.
 *    public static final void getUserStatus(@NotNull UserStatus userStatus) {
 *       Intrinsics.checkNotNullParameter(userStatus, "userStatus");
 *       if (userStatus instanceof Enabled) {
 *          ((Enabled)userStatus).printStatus();
 *       } else if (userStatus instanceof Disabled) {
 *          ((Disabled)userStatus).printStatus();
 *       } else {
 *          if (!(userStatus instanceof Warning)) {
 *             throw new NoWhenBranchMatchedException();
 *          }
 *
 *          ((Warning)userStatus).printStatus();
 *       }
 *
 *    }
 */
