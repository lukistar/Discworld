/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе целочислено число x, където 0<x<10. Да се инициализира масив от 10 елемента. Да се намери първото число на Фибоначи в интервала [0; +∞) завършващо на x и да се запише като първи елемент в масива. Да се намери второто число на Фибоначи в интервала [0; +∞) завършващо на x и да се запише като втори елемент в масива. Аналогично да се намерят първите N прости числа в интервала [0; +∞) и да се запишат като елемент N в масива. Масивът да се изведе на стандартния изход.
*/

#include<stdio.h>
#include<limits.h>

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
	int number = 0; //chisloto N
	int br = 0;
	int i;
	int cont1 = 1;
	int cont2 = 1;

		for (br = 0; (cont2 < INT_MAX-1)&&(cont2 > 0)&&(br < INT_MAX-1); br++)
		{
			cont2+=cont1;
			cont1 = cont2 - cont1;
			if (cont2 % 10 == x)
			{
				mas[number] = cont2;
				number++;
				if (number == 10) break;
			}
		}
			
		printf("Chisla na Fibonachi: \n");
		for (i = 0; i < number; i++)
		{
				printf("%d\n", mas[i]);
		}
	
return 0;
}
