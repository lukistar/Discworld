/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе целочислено число x, където 0<=x<10. Да се инициализира масив от 10 елемента. Да се намерят първите 10 числа на Фибоначи в [0; +∞), които се делят на x без остатък. Намерените стойности да се зададат като стойности на елементите в масива. Елементите на масива да се изведат на стандартния изход.
*/

#include<stdio.h>

int main()
{
	int x;
	do
	{
		printf("Vuvedete x da e v interval (0,10)\n");
		scanf("%d", &x);
	} while ((x<=0)||(x>=10));
	int mas[10];
	int cont1 = 1;
	int cont2 = 1;
	int count = 0;
	while (count<10)
	{
		if (cont2%x == 0)
		{
			mas[count] = cont2;
			count++;
		}
		cont2 += cont1;
		if (cont2 < 0) break; //zaradi prevurtaneto
		cont1 = cont2-cont1;
	}
	int i;
	printf("Namerenite chisla(ako sa po-malko ot 10 znachi e ''nadskochen'' int-a): \n");
	for (i=0; i<count; i++)
	{
		printf("%d\n", mas[i]);
	}

return 0;
}
