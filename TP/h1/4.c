/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе две целочислени числа, x и y, където x < y. Да се намерят и изведат всички числа на Фибоначи в интервала [x, y].
*/

#include<stdio.h>

int main()
{
	int xx = 0;
	int yy = 0;
	printf("Vuvedete x\n");
	scanf("%d", &xx);
	do
	{
	printf("Vuvedete y, koeto da e po-golqmo ot x\n");
	scanf("%d", &yy);
	}
	while (yy<=xx);
	printf("Chislata na Fibonachi v intervala [x,y] sa:\n");
	int cont1 = 1;
	int cont2 = 1; 
	while (cont2<=yy)
	{
		if ((xx <= 1)&&(cont2 == 1)) printf("1\n"); //chasten sluchai, koito ne vliza v "algorituma" mi
		if ((cont2>=xx)&&(cont2<=yy)) printf("%d\n", cont2);
		cont2 += cont1;
		cont1 = cont2-cont1;
	}

return 0;
}
