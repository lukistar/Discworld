/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе целочислено число x, където 0<x<10. Да се инициализира масив от 10 елемента. Да се намери сумата от всички числа в интервала [0; 1000) делящи се на x и да се запише като първа стойност в масива. Да се намери сумата от всички числа в интервала [0;1000) деляща се на 2x и да се запише като втора стойност в масива. Аналогично да се намери сумата на всички числа делящи се на Nx за N в интервала [1;10] и да се запишат като елемент N-1 в масива. Масивът да се изведе на стандартния изход.
*/

#include<stdio.h>

int main()
{
	int x;
		
		do
		{
			printf("Vuvedete x, popadasht v intervala (0,10)\n");
			scanf("%d", &x);
		}
		while (x<=0 || x>=10);

	int mas[10];
	int sum = 0;
	int number = 1; //chisloto N
	int br = 0;
	
		for (number = 1; number < 11; number++)
		{
			for (br = 0; br < 1000; br++)
			{
				if (br % (number*x) == 0)
				{
					sum+=br;
				}
			}
			mas[number-1] = sum;
			sum = 0;
		}
		
	int i;
	
		printf("Elementite na masiva: \n");
		for (i = 0; i < 10; i++)
		{
			printf("%d\n", mas[i]);
		}
	
return 0;
}

