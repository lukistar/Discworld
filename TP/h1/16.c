/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе целочислено число x, където x e интервала [0; +∞). Да се намерят първите 10 нечетни числа делители на x и да се запишат в масив. Масивът да се изведе на екрана и да се намерят простите числа в този масив.
*/

#include<stdio.h>
#include<limits.h>

int main()
{
	int x;
		
		do
		{
			printf("Vuvedete cqlo x za intervala [0; +∞) \n");
			scanf("%d", &x);
		}
		while (x < 0);
	
	int br;
	int mas[10];
	int count = 0;
		
		for(br = 1; br < (INT_MAX-2); br+=2)
		{
			if (x % br == 0)
			{
				mas[count] = br;
				count++;
				if (count == 10) break;
			}
		}
		
		int i;
		int count2 = 0;
		
		if (count != 0)
		{
			printf("Namerenite nechetni deliteli na x: \n");
			for (br = 0; br < count; br++)
			{
				for (i = 1; i <= mas[br]; i+=2)
				{
					if (mas[br] % i == 0) count2++;
					if (count2 > 2) break;
				}
				if (count2 <= 2) printf("%d -prosto chislo\n", mas[br]);
				else printf("%d\n", mas[br]);
				count2 = 0;
			}
		}
		else printf("Nqma nechetnideliteli!\n");
		
return 0;
}
