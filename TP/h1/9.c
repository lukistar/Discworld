/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе число x, където 0<x<1. Да се намери числото пи чрез следното развитие в ред:
4-4/3+4/5-4/7+4/9-4/11+...4/N. Развитието в ред спира при 4/N<x. Получената стойност за пи да се изведе на екрана.
*/

#include<stdio.h>
int main()
{
	long double x;
	do
	{
		printf("Vuvedete x da e v interval (0,1)\n");
		scanf("%Lf", &x);
	} while ((x<=0)||(x>=1));
	int Bool = 1;
	long double number = 4.00L;
	int N;
	for (N=3; (long double)4/N>x; N+=2)
	{
		if (Bool == 1)
		{
			Bool = 0;
			number-=(long double)4/N;
		}
		else
		{
			Bool = 1;		
			number+=(long double)4/N;
		}
	}
	printf("Pi=%.20Lf\n", number);

return 0;
}
