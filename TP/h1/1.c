/*
#school - ТУЕС
#class - 11Б
#num - 20
#name - Красимир Светославов Стойков
#task - Да се разработи програма, която изисква от потребителя да въведе две целочислени числа, x и y, където x < y.
Да се намери сумата на всички нечетни числа в интервала [x,y].
*/

#include<stdio.h>

int main()
{
	int xx;
	int yy;
	
	printf("Vuvedete stoinost za x\n");
	scanf("%d", &xx);
	// Sorry za "goto"-to, no reshih che tova e sgoden sluchai da go izpolzvam
	fix: 
	printf("Vuvedete stoinost za y, koqto da e po-golqma ot x\n");
	scanf("%d", &yy);
	if (yy <= xx) goto fix;
	int cont;
	int suma = 0;
	for (cont=xx; cont<=yy; cont++)
	{
		if (cont%2 != 0) suma+=cont;
	}
	printf("Sumata ot nechetnitre chisla v intervala [x,y]: %d\n", suma);
	
	
 	





return 0;
}

