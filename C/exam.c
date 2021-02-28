#include <stdio.h>

int sum(int a, int b);
void swap(int *p, int *q);

int main(void)
{
    int a, b, total;
    printf("Input two integers : ");
    scanf("%d%d", &a, &b);
    printf("a:%d, b:%d \n",a,b);
    total = sum(a,b);
    printf("** sum function call **\n");
    printf("%d + %d = %d \n",a,b,total);
    swap(&a,&b);
    printf("** swap function call **\n");
    printf("a:%d, b:%d \n",a,b);
    return 0;
}

int sum(int a, int b)
{
    int total;
    total = a + b;
    return total;
}

void swap(int *p, int *q)
{
    int temp;
    temp = *p;
    *p = *q;
    *q = temp;
}
