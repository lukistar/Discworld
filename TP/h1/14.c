/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе целочислено число x, където 0<x<10. Да се инициализира масив от 10 елемента. Да се намери първото просто число в интервала [0; +∞) завършващо на x и да се запише като първи елемент в масива. Да се намери второто просто число в интервала [0; +∞) завършващо на x и да се запише като втори елемент в масива. Аналогично да се намерят първите N прости числа в интервала [0; +∞) и да се запишат като елемент N в масива. Масивът да се изведе на стандартния изход.
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
	int count = 0;
	int Bool = 1;

		if (x%2 != 0 && x != 5)
		{
		for (br = 0; br < INT_MAX-1; br++)
		{
			for (i = 1; i<=br; i++)
			{
				if (br%i == 0) count++;
				if (count > 2) break;				
			}
			if (count <= 2)
			{
				if (br%10 == x)
				{	
					mas[number] = br;
					number++;
					count = 0;
					if (number == 10) break;
				}
			}
			count = 0;
		}
		}
		else
		{
			if (x == 2)
			{
				mas[number] = 2;
				number++;
			}
			else
			{
				if (x == 5)
				{
					mas[number] = 5;
					number++;
				}
				else
				{
					printf("Nqma prosti chisla zavurshvashti na vuvedenoto!\n");
					Bool = 0;
				}
			} 
		}
		if (Bool == 1)
		{
		printf("Vzetite prosti chisla: \n");
		for (i = 0; i < number; i++)
		{
			printf("%d\n", mas[i]);
		}
		}
	
return 0;
}
