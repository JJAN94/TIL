// 전처리기 // 
#include <stdio.h>

int main(void) {
  // 1. 마일(mile) 데이터 입력 //
  double miles, kilometer;
  printf("Enter the distance in miles> ");
  scanf("%lf", &miles);
  // 2. 마일을 킬로미터로 변환 //
  kilometer = 1.609 * miles;
  // 3. 킬로미터 데이터 출력 //
  printf("That queals %f kilometers. \n", kilometer);
  return 0;
}