/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе две целочислени числа, x и y, където x < y. Да се намери и изведе сумата на числата делящи се на 17 в интервал [x, y].
*/

#include<stdio.h>

int main()
{
	int xx = 0;
	int yy = 0;
	
	printf("Vuvedete stoinost za x\n");
	scanf("%d", &xx);
	do
	{
	printf("Vuvedete stoinost za y(da e po-golqma ot x)\n");
	scanf("%d", &yy);
	}
	while (xx>=yy);
	int cont;
	int suma = 0;
	for (cont=xx; cont<=yy; cont++)
	{
		if (cont%17 == 0) suma+=cont;
	}
	printf("Sumata e: %d\n", suma);



return 0;
}
