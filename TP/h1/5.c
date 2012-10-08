/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе целочислено число, x, където 0 < x < 10. Да се инициализират масива от 10 елемента. Стойностите на елементите на масива да са равни на косинус от индекса на елемента. Да се изведе масивът, след което да се сортира в низходящ ред и отново да се изведе.
*/

#include<stdio.h>
#include<math.h>

int main()
{
 	float z[10];
 	int i, b;
 	float box;
	
	printf("Nepodredenite chisla: \n");
	for (i = 0; i<10; i++)
	{
		z[i] = cos(i);
		printf("%.5f\n", z[i]);	
   	}
	for (i = 0; i<10; i++)
	{
		for (b = i; b<9; b++)
		{
			if (z[i]<z[b+1])
			{
				box = z[i];
				z[i] = z[b+1];
				z[b+1] = box;
			}
		}	
	}
	printf("Podredenite elementi: \n");
	for (i = 0; i<10; i++)
	{
		printf("%.5f\n", z[i]);	
   	}
	
return 0; 
}
