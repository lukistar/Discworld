/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе две целочислени числа, x и y, където x < y. Да се намерят и изведат всички прости числа завършващи на 3 в интервал [x,y].
*/

#include<stdio.h>

int main()
{
	int xx;
	int yy;
	
	printf("Vuvedete x\n");
	scanf("%d", &xx);
	do
	{
		printf("Vuvedete y(da e po-golqmo ot x)\n");
		scanf("%d", &yy);
	}
	while (xx>=yy);
	int cont;
	int br;
	int count = 0;
	printf("Prostite chisla zavursvashti na 3 v intervala [x,y]\n");
	for (cont=xx; cont<=yy; cont++)
	{
		count = 0; //restartira broqcha na vuzmojnite deliteli na dadenoto chislo
		for (br=1; br<=cont; br++)
		{
			if ((cont%br) == 0) count++;
			if (count>2) break;
		}
		if (count<=2)
		{
			int cont3 = cont;
			cont3%=10;
			if (cont3 == 3) printf("%d\n", cont);
		}	
	}

return 0;
}
