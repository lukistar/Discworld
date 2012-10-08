/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе целочислено число x, където 0<x<10. Да се инициализира масив от 100 целочислени елемента. Стойностите на елементите да са случайни числа в интервала [0, 100). Елементите на масива да се подредят така, че числата завършващи на x да са в началото.
*/

#include<stdio.h>

int main()
{
	int x = 0;
	
	while ((x<=0)||(x>=10))
	{
		printf("Vuvedete chislo v intervala (0,10)\n");
		scanf("%d", &x);
		if (x<=0 || x>=10) printf("@@@@ ERROR! Chislo trqbva da e mejdu 0 i 10! @@@@\n");
	}
	int masiv[100];
	srand((unsigned)time(NULL));
	int i;
	for (i = 0; i<100; i++)
	{
		masiv[i] = rand()%100;
		printf("%d\t", masiv[i]);
	}
	int box, number;
	int used = -1;
	for (i = 0; i<100; i++)
	{
		number = masiv[i];
		if ((number%=10) == x)
		{
			used++;
			box = masiv[used];
			masiv[used] = masiv[i];
			masiv[i] = box;
		}
	}
	printf("Chislata: \n");
	for (i = 0; i<100; i++) printf("%d\t", masiv[i]);

return 0;
}
